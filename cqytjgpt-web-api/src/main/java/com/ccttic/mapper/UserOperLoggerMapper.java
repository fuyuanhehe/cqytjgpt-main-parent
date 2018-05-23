package com.ccttic.mapper;

import com.ccttic.entity.UserOperLogger;

/**
 * 说明：用户日志操作
 * */
public interface UserOperLoggerMapper {
    /**
     * 说明：增加UserOperLogger
     * */
    boolean addUserOperLogger(UserOperLogger userOperLogger);

    /**
     * 说明：更新一个UserOperLogger
     * */
    boolean renewUserOperLogger(UserOperLogger userOperLogger);

    /**
     * 说明：删除一个UserOperLogger
     * */
    boolean delUserOperLogger(String id);
}
