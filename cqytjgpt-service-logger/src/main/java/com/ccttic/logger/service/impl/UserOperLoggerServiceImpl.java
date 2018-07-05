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
    public void addUserOperLogger(UserOperLogger userOperLogger) {
    	String now = DateFormatUtils.format(new Date(), "yyyyMMdd");
        userOperLoggerMapper.addUserOperLogger(userOperLogger,now);
    }

    @Async
    @Override
    public void delUserOperLogger(String id) {
    	String now = DateFormatUtils.format(new Date(), "yyyyMMdd");
        userOperLoggerMapper.delUserOperLogger(id,now);
    }
    

    @Async
	@Override
	public void addUserOperLoggerTb() {
    	Date nextDate = DateUtils.addDays(new Date(), 1);
    	String nextDateStr = DateFormatUtils.format(nextDate, "yyyyMMdd");
		userOperLoggerMapper.addUserOperLoggerTb(nextDateStr);
	}

    @Override
    @Transactional(readOnly = true)
    public Page<UserOperLogger> findAllUserOperLogger(UserOperLogger userOperLogger, Pageable page) {
    	String now = DateFormatUtils.format(new Date(), "yyyyMMdd");
    	Page<UserOperLogger> pager = new PageImpl<UserOperLogger>(page);
    	Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
        params.put("operType", userOperLogger.getOperType());
        params.put("operBy", userOperLogger.getOperBy());
        params.put("content", userOperLogger.getContent());
        params.put("operTime", userOperLogger.getOperTime());
        params.put("startTime", userOperLogger.getStartTime());
        params.put("endTime", userOperLogger.getEndTime());
        params.put("ipAddr", userOperLogger.getIpAddr());
        params.put("remark", userOperLogger.getRemark());
		pager.setTotalRows(userOperLoggerMapper.findAllUserOperLoggerCount(params,now));
		pager.setRecords(userOperLoggerMapper.findAllUserOperLogger(params,now));
        return pager;
    }

    @Override
    @Transactional(readOnly = true)
    public UserOperLogger findSingleUserOperLog(String id) {
    	String now = DateFormatUtils.format(new Date(), "yyyyMMdd");
        return userOperLoggerMapper.findSingleUserOperLog(id,now);
    }
}
