package com.ccttic.task.service;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public abstract class BaseTask extends QuartzJobBean{
	public abstract String getCronStr();

}
