package com.ccttic.task.execute;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.ccttic.task.feign.ICarServiceFeign;

@Component
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class CarDangerTask extends QuartzJobBean{
	
	@Autowired
	private ICarServiceFeign  feign;
	
	//执行方法
	@Override
	protected void executeInternal(JobExecutionContext arg) throws JobExecutionException {
//		feign.updateCar();
//		
//		feign.addCarIllega();
		System.out.print("-----------------------------开始--------------------------------------");
		feign.addCarDanger();
		System.out.print("-----------------------------结束--------------------------------------");
	}
}
