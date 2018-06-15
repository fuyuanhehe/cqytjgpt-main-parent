package com.ccttic.task.runer;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.ccttic.util.common.RandomHelper;

@Component
public class SchedulerRuner implements ApplicationRunner, ApplicationContextAware {

	@Autowired
	private Scheduler scheduler;

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Map<String, AbstractTask> taskMap = applicationContext.getBeansOfType(AbstractTask.class);
		for (String clazz : taskMap.keySet()) {
			AbstractTask task = taskMap.get(clazz);
			String taskGroup = task.getTaskGroup();  //任务分组
			String taskName= task.getTaskName();
			if(StringUtils.isEmpty(taskName)){
				taskName = "TK_" + clazz+RandomHelper.uuid() ;    
			}
			// 创建任务
			JobDetail jobDetail = JobBuilder.newJob(task.getClass()).withIdentity(taskName, taskGroup).build();
			// 时间调度
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(task.getCronStr());
			// 创建任务触发器
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity(taskName, taskGroup)
					.withSchedule(scheduleBuilder).build();
			// 将触发器与任务绑定到调度器内
			scheduler.scheduleJob(jobDetail, trigger);
		}
	}
}
