package com.ccttic.gateway.logger;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import java.util.*;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 说明：前前置日志操作管理（用户访问具体服务之前进行记录）
 * */
@Component
public class PreOperLogger extends ZuulFilter {
    public static final String LINK_SHARD_ID = "shardId";

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
        // 获得当前请求的上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 获得当前请求的 request
        HttpServletRequest request = currentContext.getRequest();
        // 设置这次的日志链ID，在路由出去的时候将会使用该ID
        String shardId = UUID.randomUUID().toString();
        currentContext.set(LINK_SHARD_ID, shardId);
        // 获得参数
        if (request.getMethod().equalsIgnoreCase("POST")) {
            // 打印参数
            System.out.println(getPostParams(request));
        }
        // 存储数据库的操作
        // ******
        return null;
    }

    /**
     * 说明：获得HttpServletRequest POST的参数
     * */
    private Map<String, Object> getPostParams(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        // 必须是POST方式
        if (!request.getMethod().equalsIgnoreCase("POST")) {
            return map;
        }
        // 得到参数，如果参数为空就返回
        Map<String, String[]> parameterMap = request.<String, String[]>getParameterMap();
        if (parameterMap == null || parameterMap.size() == 0)
            return map;
        // 循环遍历元素
        String next = null;
        String[] param = null;
        List<String> templist = null;
        Iterator<String> iterator = parameterMap.keySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            param = parameterMap.get(next);
            // 如果没有参数
            if (param == null || param.length == 0) {
                map.put(next, null);
                continue;
            }
            // 如果只有一个参数
            if (param.length == 1) {
                map.put(next, param[0]);
            } else {    // 多个参数
                templist = new ArrayList<>();
                for (String val : param) {
                    templist.add(val);
                }
                map.put(next, templist);
            }
        }
        return map;
    }
}
