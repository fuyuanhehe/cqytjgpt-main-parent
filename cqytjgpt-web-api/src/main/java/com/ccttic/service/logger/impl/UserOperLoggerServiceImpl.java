package com.ccttic.service.logger.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.entity.logger.UserOperLogger;
import com.ccttic.mapper.logger.UserOperLoggerMapper;
import com.ccttic.util.logger.worker.UserOperLoggerService;


@Service
@Transactional
public class UserOperLoggerServiceImpl implements UserOperLoggerService {

    @Autowired
    private UserOperLoggerMapper userOperLoggerMapper;

    @Override
    public boolean addUserOperLogger(UserOperLogger userOperLogger) {
        return userOperLoggerMapper.addUserOperLogger(userOperLogger);
    }

    @Override
    public boolean renewUserOperLogger(UserOperLogger userOperLogger) {
        return userOperLoggerMapper.renewUserOperLogger(userOperLogger);
    }

    @Override
    public boolean delUserOperLogger(String id) {
        return userOperLoggerMapper.delUserOperLogger(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserOperLogger> findAllUserOperLogger(Map<String, Object> params) {
        return userOperLoggerMapper.findAllUserOperLogger(params);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer findAllUserOperLoggerCount(Map<String, Object> params) {
        return userOperLoggerMapper.findAllUserOperLoggerCount(params);
    }

    @Override
    @Transactional(readOnly = true)
    public UserOperLogger findSingleUserOperLog(String id) {
        return userOperLoggerMapper.findSingleUserOperLog(id);
    }
}
