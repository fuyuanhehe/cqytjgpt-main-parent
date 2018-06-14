package com.ccttic.cqytjgpt.webapi.aspect;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ccttic.cqytjgpt.webapi.interfaces.logger.UserOperLoggerService;
import com.ccttic.entity.logger.LoggerModel;
import com.ccttic.entity.logger.UserOperLogger;
import com.ccttic.util.common.CCtticDateUtils;
import com.ccttic.util.common.CommonGenerator;
import com.ccttic.util.jwt.JWTUtil;
import com.ccttic.util.task.GeneralTestQueueExecutor;
import com.ccttic.util.web.CCtticWebUtils;

/**
 * 说明：日志切面配置
 */
public class LoggerAspect {
    // 日志
    private Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    // token key
    public final static String AUTHORIZATION = "Authorization";

    // 网关中必须将用户姓名写入request域，USER_NAME_TOKEN 就是key
    public static final String USER_NAME_TOKEN = "authentication_name";

    // 默认会抛异常的 userOperLoggerService
    private UserOperLoggerService userOperLoggerService;

    /**
     * 说明：-1 默认为处理器数量
     * 500 队列最大数量
     * 2 两个消费者
     * */
    private GeneralTestQueueExecutor generalTestQueueExecutor;

    /**
     * 说明：日志环绕通知
     */
    public Object doAroundLogger(ProceedingJoinPoint joinPoint) {
        Object proceed = null;  // 返回的数据
        Method method = null;   // 执行的目标方法
        // 获得request
        HttpServletRequest request = getHttpServletRequest();
        try {
            // 如果request为空或者generalTestQueueExecutor为空，那么直接执行后退出
            if (generalTestQueueExecutor == null || request == null) {
                logger.warn("当前不是web环境或者generalTestQueueExecutor为空，无法增加记录");
                return proceed = joinPoint.proceed();
            }
            // 获得方法对象
            method = ((MethodSignature) joinPoint.getSignature()).getMethod();
            // 获得用户的基本操作日志
            UserOperLogger userOperLoggerDataInfo = getUserOperLoggerDataInfo(request);
            // 异步保存用户日志
            generalTestQueueExecutor.putTask(new UserOperLoggerTask(method, userOperLoggerService, userOperLoggerDataInfo));
            // 执行目标方法,如果这一句不执行，那么目标方法不会执行
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }

    class UserOperLoggerTask implements Runnable {
        private UserOperLoggerService userOperLoggerService;
        private UserOperLogger userOperLogger;
        private Method method;

        public UserOperLoggerTask(Method method, UserOperLoggerService userOperLoggerService, UserOperLogger userOperLogger) {
            this.method = method;
            this.userOperLoggerService = userOperLoggerService;
            this.userOperLogger = userOperLogger;
        }

        @Override
        public void run() {
            // 获得方法和他所在类它上面的注解信息
            LoggerModel loggerInfo = LoggerWorker.getLoggerInfo(method);
            if (loggerInfo != null) {
                userOperLogger.setContent(loggerInfo.getContent());
                userOperLogger.setRemark(loggerInfo.getRemark());
                userOperLogger.setOperType(loggerInfo.getOperType());
            }
            userOperLoggerService.addUserOperLogger(userOperLogger);
        }
    }

    /**
     * 说明：通过request创建一个UserOperLogger
     * */
    public static UserOperLogger getUserOperLoggerDataInfo(HttpServletRequest request) {
        // 需要保持的UserOperLogger
        UserOperLogger userOperLogger = new UserOperLogger();
        String token = request.getHeader(AUTHORIZATION);
        String zjhm = null;
        if (token == null)
            userOperLogger.setOperBy("游客");
        else {
            // 获得姓名  这一步可以异步操作，优化响应时间
            zjhm = JWTUtil.getUsername(token);
            if (zjhm == null)
                zjhm = "游客";
            userOperLogger.setOperBy("" + zjhm);
        }
        // 设置基本信息
        userOperLogger.setOperType(3);
        userOperLogger.setId(CommonGenerator.distributiveIDGenerator());
        userOperLogger.setIpAddr(CCtticWebUtils.getRemoteHost(request));
        userOperLogger.setOperTime(CCtticDateUtils.presentDay("yyyy-MM-dd HH:mm:ss"));
        return userOperLogger;
    }

    /**
     * @Description: 获取request
     * @author wl
     * @date 2018-05-23
     */
    public HttpServletRequest getHttpServletRequest() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        if (ra == null)
            return null;
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        return request;
    }

    public void destroy() {
        generalTestQueueExecutor.destroy();
    }

    /**
     * 说明：需要将UserOperLoggerService注入进来
     * */
    public void setUserOperLoggerService(UserOperLoggerService userOperLoggerService) {
        this.userOperLoggerService = userOperLoggerService;
    }

    /**
     * 说明：需要将GeneralTestQueueExecutor注入进来
     * */
    public void setGeneralTestQueueExecutor(GeneralTestQueueExecutor generalTestQueueExecutor) {
        this.generalTestQueueExecutor = generalTestQueueExecutor;
    }
}
