package com.ccttic.gateway.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.entity.logger.OperLogger;
import com.ccttic.gateway.mapper.OperLoggerMapper;
import com.ccttic.gateway.service.OperLoggerService;

@Service
@Transactional
public class OperLoggerServiceImpl implements OperLoggerService {

    @Autowired
    private OperLoggerMapper operLoggerMapper;

    @Override
    public boolean addOperlog(OperLogger operLogger) {
        return operLoggerMapper.addOperlog(operLogger);
    }

    @Override
    public boolean renewOperlog(OperLogger operLogger) {
        return operLoggerMapper.renewOperlog(operLogger);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(String id) {
        OperLogger exist = operLoggerMapper.isExist(id);
        return exist != null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OperLogger> findSysOperLogger(Map<String, Object> params) {
        return operLoggerMapper.findSysOperLogger(params);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer findSysOperLoggerCount(Map<String, Object> params) {
        return operLoggerMapper.findSysOperLoggerCount(params);
    }

    @Override
    @Transactional(readOnly = true)
    public OperLogger findSingleSysOperLogger(String id) {
        return operLoggerMapper.findSingleSysOperLogger(id);
    }
}
