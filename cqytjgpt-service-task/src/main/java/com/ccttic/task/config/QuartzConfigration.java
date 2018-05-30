package com.ccttic.task.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfigration {
	
    @Autowired
    private MyJobFactory myJobFactory;
    
    @Autowired
    private DataSource dataSource;
	
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory() {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
        factory.setOverwriteExistingJobs(true);
        // 延时启动，应用启动1秒后
        factory.setStartupDelay(5);
        
        factory.setDataSource(dataSource);
        
        factory.setConfigLocation(new ClassPathResource("/quartz.yml"));

        // 自定义Job Factory，用于Spring注入
        factory.setJobFactory(myJobFactory);
        return factory;
    }
}
