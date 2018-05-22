package com.ccttic.gateway.mapper;

import com.ccttic.entity.OperLogger;

/**
 *  说明：操作日志mapper
 * */
public interface OperLoggerMapper {
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
    OperLogger isExist(String id);
}
