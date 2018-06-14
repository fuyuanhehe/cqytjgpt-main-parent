package com.ccttic.task.taskexecute;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ccttic.task.feign.IDriverServiceFeign;
import com.ccttic.task.runer.AbstractTask;

@Component
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class DriverDangerTask extends AbstractTask{
	
	@Autowired
	private IDriverServiceFeign  feign;
	
	//启动时间
	@Override
	public String getCronStr() {
		return "30 * * * * ?";
	}
	//执行方法
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {

		feign.addDriveIllega();
		feign.addDriverDanger();
	}

}
