package com.ccttic.gateway.logger;

import com.ccttic.entity.OperLogger;
import com.ccttic.gateway.logger.storage.OperLoggerStorage;
import com.ccttic.gateway.servicefallback.CqytjgptWebApiFallBack;
import com.ccttic.util.common.CCtticDateUtils;
import com.ccttic.util.jwt.JWTUtil;
import com.ccttic.util.logger.aspect.LoggerAspect;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

/**
 * 说明：后置日志操作管理（用户访问具体服务之后进行记录）
 */
@Component
public class RearOperLogger extends ZuulFilter {

    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        // 获得当前请求的上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 获得上下文中的日志
        OperLogger logger = OperLogger.class.cast(currentContext.get(PreOperLogger.LINK_SHARD_OPER));
        // 设置错误信息
        Throwable throwable = RequestContext.getCurrentContext().getThrowable();
        if (throwable != null) {
            // 没有操作成功
            logger.setSuccess(1);
            // 记录错误信息
            logger.setAbnormity(throwable.getMessage());
        }
        // 设置结束时间
        logger.setEndTime(CCtticDateUtils.presentDay("yyyy-MM-dd HH:mm:ss"));
        String back = (String) currentContext.get(CqytjgptWebApiFallBack.WEB_API_FALL_BACK);
        if (back != null) {
            logger.setSuccess(1);
            logger.setAbnormity(back);
        }
        // 放入队列
        OperLoggerStorage.addOperLoggerStorage(logger);
        return null;
    }
}
