package com.ccttic.logger.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.entity.logger.UserOperLogger;
import com.ccttic.logger.mapper.UserOperLoggerMapper;
import com.ccttic.logger.service.UserOperLoggerService;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageImpl;
import com.ccttic.util.page.Pageable;


@Service
@Transactional
public class UserOperLoggerServiceImpl implements UserOperLoggerService {

    @Autowired
    private UserOperLoggerMapper userOperLoggerMapper;

    @Async
    @Override
    public boolean addUserOperLogger(UserOperLogger userOperLogger) {
        return userOperLoggerMapper.addUserOperLogger(userOperLogger);
    }

    @Async
    @Override
    public boolean renewUserOperLogger(UserOperLogger userOperLogger) {
        return userOperLoggerMapper.renewUserOperLogger(userOperLogger);
    }

    @Async
    @Override
    public boolean delUserOperLogger(String id) {
        return userOperLoggerMapper.delUserOperLogger(id);
    }
    

    @Async
	@Override
	public boolean addUserOperLoggerTb() {
    	Date nextDate = DateUtils.addDays(new Date(), 1);
    	String nextDateStr = DateFormatUtils.format(nextDate, "yyyyMMdd");
		return userOperLoggerMapper.addUserOperLoggerTb(nextDateStr);
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
    public UserOperLogger findSingleUserOperLog(String id) {
        return userOperLoggerMapper.findSingleUserOperLog(id);
    }
}
