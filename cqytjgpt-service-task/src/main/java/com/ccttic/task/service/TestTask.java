package com.ccttic.task.service;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import com.ccttic.task.runer.BaseTask;

/**
 * 定时器Demo 服务方法
 * @author zhuliang
 *
 */
@Component
public class TestTask extends BaseTask {
	
	// 注入服务方法
	//@Autowired
	//XXXService;

	/**
	 * 覆盖父类方法，设置调度得时间
	 * @return
	 */
	@Override
	public String getCronStr() {
		return "0/30 * * * * ?";
	}
	
	/**
	 * 重写方法调用服务类
	 */
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// 调用服务方法
      System.out.println("1111");		
	}
}


