package com.ccttic.cqytjgpt.webapi.service.logger;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.cqytjgpt.webapi.interfaces.logger.UserOperLoggerService;
import com.ccttic.cqytjgpt.webapi.mapper.logger.UserOperLoggerMapper;
import com.ccttic.entity.logger.UserOperLogger;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;


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
    public Page<UserOperLogger> findAllUserOperLogger(UserOperLogger userOperLogger, Pageable page) {
    	Page<UserOperLogger> pager = new PageImpl<UserOperLogger>(page);
    	Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
        params.put("operType", userOperLogger.getOperType());
        params.put("operBy", userOperLogger.getOperBy());
        params.put("content", userOperLogger.getContent());
        params.put("operTime", userOperLogger.getOperTime());
        params.put("ipAddr", userOperLogger.getIpAddr());
        params.put("remark", userOperLogger.getRemark());
		pager.setTotalRows(userOperLoggerMapper.findAllUserOperLoggerCount(params));
		pager.setRecords(userOperLoggerMapper.findAllUserOperLogger(params));
        return pager;
    }

    @Override
    @Transactional(readOnly = true)
    public Long findAllUserOperLoggerCount(Map<String, Object> params) {
        return userOperLoggerMapper.findAllUserOperLoggerCount(params);
    }

    @Override
    @Transactional(readOnly = true)
    public UserOperLogger findSingleUserOperLog(String id) {
        return userOperLoggerMapper.findSingleUserOperLog(id);
    }
}
