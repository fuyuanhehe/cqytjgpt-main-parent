package com.ccttic.gateway.logger;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

/**
 * 说明：后置日志操作管理（用户访问具体服务之后进行记录）
 * */
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
        RequestContext currentContext = RequestContext.getCurrentContext();
        String shardId = String.class.cast(currentContext.get(PreOperLogger.LINK_SHARD_ID));
        System.out.println("========================" + shardId);
        Throwable throwable = currentContext.getThrowable();
        if (throwable != null) {
            System.out.println("==================================" + throwable.getCause());
        }
        return null;
    }
}
