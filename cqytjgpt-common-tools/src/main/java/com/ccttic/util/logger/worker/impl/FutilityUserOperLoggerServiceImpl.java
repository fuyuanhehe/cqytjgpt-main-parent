package com.ccttic.util.logger.worker.impl;

import java.util.Map;

import com.ccttic.entity.logger.UserOperLogger;
import com.ccttic.util.logger.worker.UserOperLoggerService;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.Pageable;

/**
 * 说明：无用的UserOperLoggerService
 * */
public class FutilityUserOperLoggerServiceImpl implements UserOperLoggerService {
    @Override
    public boolean addUserOperLogger(UserOperLogger userOperLogger) {
        throw new RuntimeException("配置错误，你必须实现 com.ccttic.util.logger.worker.UserOperLoggerService 让后将他注入给我");
    }

    @Override
    public boolean renewUserOperLogger(UserOperLogger userOperLogger) {
        throw new RuntimeException("配置错误，你必须实现 com.ccttic.util.logger.worker.UserOperLoggerService 让后将他注入给我");
    }

    @Override
    public boolean delUserOperLogger(String id) {
        throw new RuntimeException("配置错误，你必须实现 com.ccttic.util.logger.worker.UserOperLoggerService 让后将他注入给我");
    }

    @Override
    public Page<UserOperLogger> findAllUserOperLogger(UserOperLogger logger, Pageable page) {
        throw new RuntimeException("配置错误，你必须实现 com.ccttic.util.logger.worker.UserOperLoggerService 让后将他注入给我");
    }

    @Override
    public Long findAllUserOperLoggerCount(Map<String, Object> params) {
        throw new RuntimeException("配置错误，你必须实现 com.ccttic.util.logger.worker.UserOperLoggerService 让后将他注入给我");
    }

    @Override
    public UserOperLogger findSingleUserOperLog(String id) {
        throw new RuntimeException("配置错误，你必须实现 com.ccttic.util.logger.worker.UserOperLoggerService 让后将他注入给我");
    }
}
