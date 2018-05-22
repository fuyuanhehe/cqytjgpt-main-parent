package com.ccttic.gateway.logger;

import com.ccttic.entity.OperLogger;
import com.ccttic.gateway.service.OperLoggerService;
import com.ccttic.util.common.CCtticDateUtils;
import com.ccttic.util.common.CommonGenerator;
import com.ccttic.util.web.CCtticWebUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.util.*;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 说明：前前置日志操作管理（用户访问具体服务之前进行记录）
 * */
@Component
public class PreOperLogger extends ZuulFilter {
    public static final String LINK_SHARD_OPER = "shardOper";

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
        // 得到log
        OperLogger operLogger = getOperLogger(request);
        operLogger.setStartTime(CCtticDateUtils.presentDay("yyyy-MM-dd HH:mm:ss"));
        operLogger.setEndTime("");
        // 设置这次的日志
        currentContext.set(LINK_SHARD_OPER, operLogger);
        return null;
    }

    public static OperLogger getOperLogger(HttpServletRequest request) {
        // 日志实体类
        OperLogger operLogger = new OperLogger();
       // 设置ID
        String shardId = CommonGenerator.DistributiveIDGenerator();
        operLogger.setId(shardId);
        // 获得参数
        Map<String, Object> requestParams = CCtticWebUtils.getRequestParams(request);
        operLogger.setParams(requestParams.toString());
        // 设置URL连接
        operLogger.setUrl(request.getRequestURL().toString());
        operLogger.setSuccess(0);
        return operLogger;
    }
}
