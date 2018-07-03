package com.ccttic.task.execute;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.ccttic.task.feign.IDriverServiceFeign;

@Component
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class DriverDangerTask extends QuartzJobBean{
	
	@Autowired
	private IDriverServiceFeign  feign;
	
	//执行方法
	@Override
	protected void executeInternal(JobExecutionContext arg) throws JobExecutionException {
		
		feign.updateDriver();
		feign.addDriverIllega();
		feign.addDriverDanger();
	}
}
