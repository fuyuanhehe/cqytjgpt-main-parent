package com.ccttic.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ccttic.util.common.SystemEnvironment;
import com.ccttic.util.logger.aspect.LoggerAspect;
import com.ccttic.util.logger.worker.UserOperLoggerService;
import com.ccttic.util.task.GeneralTestQueueExecutor;

/**
 * 说明：记录用户操作日志
 * @author wl
 * @date 2018年5月24日 09:45:49
 * */
@Aspect
@Configuration
public class LoggerAop {

    @Autowired
    private LoggerAspect loggerAspect;

    @Around("execution(* com.ccttic.controller..*.*(..))")
    public Object logAspect(ProceedingJoinPoint joinPoint) {
         return loggerAspect.doAroundLogger(joinPoint);
    }

    @Bean(destroyMethod = "destroy")
    public LoggerAspect loggerAspect(UserOperLoggerService userOperLoggerService, GeneralTestQueueExecutor generalTestQueueExecutor) {
        LoggerAspect loggerAspect = new LoggerAspect();
        // 设置日志写入的异步执行类，这个类型来执行主要的逻辑
        loggerAspect.setGeneralTestQueueExecutor(generalTestQueueExecutor);
        // 设置向日志写入的主要Service方法
        loggerAspect.setUserOperLoggerService(userOperLoggerService);
        return loggerAspect;
    }

    /**
     * 注意：初始化完成后，必须调用GeneralTestQueueExecutor#start() 方法
     * */
    @Bean(initMethod = "start", destroyMethod = "destroy")
    public GeneralTestQueueExecutor generalTestQueueExecutor() {
        // SystemEnvironment.PROCESSOR 与CPU核心数一样的写入线程
        // 队列中最大的任务数量为2000
        // 两个监听消费者
        GeneralTestQueueExecutor generalTestQueueExecutor
                = new GeneralTestQueueExecutor(SystemEnvironment.PROCESSOR, 2000, 2);
        return generalTestQueueExecutor;
    }
}
