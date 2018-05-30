package com.ccttic.task.service;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class TestTask extends BaseTask {

	@Override
	public String getCronStr() {
		return "0/30 * * * * ?";
	}
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
      System.out.println("1111");		
	}
}


