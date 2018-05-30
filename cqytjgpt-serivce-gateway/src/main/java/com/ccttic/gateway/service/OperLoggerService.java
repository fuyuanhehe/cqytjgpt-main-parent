package com.ccttic.gateway.service;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.logger.OperLogger;

/**
 * 说明：操作日志数据库服务层
 * */
public interface OperLoggerService {
    /**
     * 说明：添加一个系统操作日志
     * */
    boolean addOperlog(OperLogger operLogger);

    /**
     * 说明：更新一个系统操作日志
     * */
    boolean renewOperlog(OperLogger operLogger);

    /**
     * 说明：查找一个日志是否存在，返回为空则不存在
     * */
    boolean isExist(String id);

    /**
     * 说明：查询所有的参数
     * map keys：【operName：操作者，url：访问的URL，startTime：开始时间，
     * endTime：结束时间，success：是否成功，startRecod：开始页，offset：查询数据量】s
     * */
    List<OperLogger> findSysOperLogger(Map<String, Object> params);

    /**
     * 统计条数
     * 说明：查询所有的参数
     * map keys：【operName：操作者，url：访问的URL，startTime：开始时间，endTime：结束时间，success：是否成功】
     * */
    Integer findSysOperLoggerCount(Map<String, Object> params);

    /**
     * 说明：查询单个操作日志
     * */
    OperLogger findSingleSysOperLogger(String id);
}
