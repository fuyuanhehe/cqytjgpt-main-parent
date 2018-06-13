package com.ccttic.task.runer;

import org.apache.commons.lang.StringUtils;
import org.springframework.scheduling.quartz.QuartzJobBean;

public abstract class AbstractTask extends QuartzJobBean{
	
	/**
	 * 获取定时任务分组
	 * @return
	 */
	public String getTaskGroup(){
		return "cqytjpt-task";  //默认返回
	}
	
	/**
	 * 获取定时任务名称
	 * @return
	 */
	public String getTaskName(){
		return StringUtils.EMPTY;
	}
	
	/**
	 * 获取定时任务时间Cron
	 * @return
	 */
	public abstract String getCronStr();
	
}
