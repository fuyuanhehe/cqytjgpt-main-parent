package com.ccttic.util.logger.worker;

import com.ccttic.entity.UserOperLogger;

public interface UserOperLoggerService {
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
