package com.ccttic.util.logger.worker;

import com.ccttic.entity.UserOperLogger;

import java.util.List;
import java.util.Map;

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

    /**
     * 说明：查询所有的参数
     * map keys：【content：内容，operBy：操作者，operTime：操作时间，ipAddr：ip地址，remark：备注，
     * startRecod：开始页码，offset：结束页码】
     * */
    List<UserOperLogger> findAllUserOperLogger(Map<String, Object> params);

    /**
     * 统计条数
     * 说明：查询所有的参数
     * map keys：【operName：操作者，url：访问的URL，startTime：开始时间，endTime：结束时间，success：是否成功】
     * */
    Integer findAllUserOperLoggerCount(Map<String, Object> params);

    /**
     * 说明：查找单个日志
     * */
    UserOperLogger findSingleUserOperLog(String id);
}
