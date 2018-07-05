package com.ccttic.task.execute;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.task.feign.IUserOperLogger;

@Component
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class UserOperLoggerTask extends QuartzJobBean{
	
	private Logger logger = LoggerFactory.getLogger(UserOperLoggerTask.class);
	
	@Autowired
	private IUserOperLogger feign;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		ResponseMsg<Boolean> result = feign.addOperLoggerTb();
		if(result.getStatus() == -1){
			logger.error(result.getMessage());
		}
	}
}
