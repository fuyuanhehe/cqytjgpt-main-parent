package com.ccttic.gateway.service.impl;

import com.ccttic.gateway.mapper.OperLoggerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OperLoggerServiceImpl {

    @Autowired
    private OperLoggerMapper operLoggerMapper;

}
