package com.ccttic.service.impl;

import com.ccttic.entity.UserOperLogger;
import com.ccttic.mapper.UserOperLoggerMapper;
import com.ccttic.util.logger.worker.UserOperLoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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
