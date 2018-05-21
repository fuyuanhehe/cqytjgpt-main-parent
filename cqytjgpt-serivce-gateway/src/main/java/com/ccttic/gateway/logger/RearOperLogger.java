package com.ccttic.gateway.logger;

import com.netflix.zuul.ZuulFilter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

public class RearOperLogger extends ZuulFilter {
    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        return null;
    }
}
