package com.ccttic.util.logger.aspect;

import com.ccttic.entity.UserOperLogger;
import com.ccttic.util.common.CCtticDateUtils;
import com.ccttic.util.common.CommonGenerator;
import com.ccttic.util.logger.model.LoggerModel;
import com.ccttic.util.logger.worker.impl.FutilityUserOperLoggerServiceImpl;
import com.ccttic.util.logger.worker.LoggerWorker;
import com.ccttic.util.logger.worker.UserOperLoggerService;
import com.ccttic.util.task.GeneralTestQueueExecutor;
import com.ccttic.util.web.CCtticWebUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 说明：日志切面配置
 */
public class LoggerAspect {

    public static final String USER_NAME_TOKEN = "authentication_name";

    // 默认会抛异常的 userOperLoggerService
    private UserOperLoggerService userOperLoggerService = new FutilityUserOperLoggerServiceImpl();

    /**
     * 说明：-1 默认为处理器数量
     * 500 队列最大数量
     * 2 两个消费者
     * */
    private GeneralTestQueueExecutor generalTestQueueExecutor = new GeneralTestQueueExecutor(-1, 500, 2);

    public LoggerAspect() {
        generalTestQueueExecutor.start();
    }

    /**
     * 说明：日志环绕通知
     */
    public Object doAroundLogger(ProceedingJoinPoint joinPoint) {
        Object proceed = null;  // 返回的数据
        Method method = null;   // 执行的目标方法
        LoggerModel loggerInfo = null;  // 注解的信息
        // 获得request
        HttpServletRequest request = getHttpServletRequest();
        try {
            // 如果request为空或者userOperLoggerService，那么直接执行后退出
            if (userOperLoggerService == null || request == null) {
                System.out.println("当前不是web环境或者userOperLoggerService为空，无法增加记录");
                return proceed = joinPoint.proceed();
            }
            // 获得方法对象
            method = ((MethodSignature) joinPoint.getSignature()).getMethod();
            // 执行目标方法,如果这一句不执行，那么目标方法不会执行
            proceed = joinPoint.proceed();
            // 获得方法和他所在类它上面的注解信息
            loggerInfo = LoggerWorker.getLoggerInfo(method);
            // 要保存的信息
            UserOperLogger userOperLoggerDataInfo = getUserOperLoggerDataInfo(request, loggerInfo);
           //  userOperLoggerService.addUserOperLogger(userOperLoggerDataInfo);
            generalTestQueueExecutor.putTask(new UserOperLoggerTask(userOperLoggerService, userOperLoggerDataInfo));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }

    public static UserOperLogger getUserOperLoggerDataInfo(HttpServletRequest request, LoggerModel loggerInfo) {
        // 需要保持的UserOperLogger
        UserOperLogger userOperLogger = new UserOperLogger();
        Object user_name_token = request.getAttribute("USER_NAME_TOKEN");
        String userName = null;
        if (user_name_token != null) {
            userName = String.valueOf(user_name_token);
        } else
            userName = "未知用户";
        userOperLogger.setOperBy(userName);
        // 设置基本信息
        userOperLogger.setId(CommonGenerator.distributiveIDGenerator());
        userOperLogger.setIpAddr(CCtticWebUtils.getRemoteHost(request));
        userOperLogger.setContent(loggerInfo.getContent());
        userOperLogger.setRemark(loggerInfo.getRemark());
        userOperLogger.setOperType(loggerInfo.getOperType());
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

    class UserOperLoggerTask implements Runnable {
        private UserOperLoggerService userOperLoggerService;
        private UserOperLogger userOperLogger;

        public UserOperLoggerTask(UserOperLoggerService userOperLoggerService, UserOperLogger userOperLogger) {
            this.userOperLoggerService = userOperLoggerService;
            this.userOperLogger = userOperLogger;
        }

        @Override
        public void run() {
            userOperLoggerService.addUserOperLogger(userOperLogger);
        }
    }

    /**
     * 说明：需要将UserOperLoggerService注入进来
     * */
    public void setUserOperLoggerService(UserOperLoggerService userOperLoggerService) {
        this.userOperLoggerService = userOperLoggerService;
    }
}
