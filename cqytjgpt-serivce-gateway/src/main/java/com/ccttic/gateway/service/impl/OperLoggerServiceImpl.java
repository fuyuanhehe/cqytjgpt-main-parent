package com.ccttic.gateway.service.impl;

import com.ccttic.entity.OperLogger;
import com.ccttic.gateway.mapper.OperLoggerMapper;
import com.ccttic.gateway.service.OperLoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
