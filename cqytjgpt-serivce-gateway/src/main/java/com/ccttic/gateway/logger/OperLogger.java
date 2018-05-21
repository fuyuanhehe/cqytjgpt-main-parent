package com.ccttic.gateway.logger;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 说明：日志操作管理
 * */
@Component
public class OperLogger extends ZuulFilter {

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        // 获得当前请求的 request
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        if (request.getMethod().equalsIgnoreCase("POST")) {
            System.out.println(getPostParams(request));
        }
        return null;
    }

    /**
     * 说明：获得HttpServletRequest POST的参数
     * */
    private Map<String, String[]> getPostParams(HttpServletRequest request) {
        Map<String, String[]> map = null;
        if (request.getMethod().equalsIgnoreCase("POST")) {
            map = request.<String, String[]>getParameterMap();
        }
        return map;
    }
}
