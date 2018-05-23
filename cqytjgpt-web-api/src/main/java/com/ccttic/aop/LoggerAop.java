package com.ccttic.aop;

import com.ccttic.util.logger.aspect.LoggerAspect;
import com.ccttic.util.logger.worker.UserOperLoggerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Configuration
public class LoggerAop {

    @Autowired
    private LoggerAspect loggerAspect;

    @Around("execution(* com.ccttic.controller..*.*(..))")
    public void logAspect(ProceedingJoinPoint joinPoint) {
        loggerAspect.doAroundLogger(joinPoint);
    }

    @Bean(destroyMethod = "destroy")
    public LoggerAspect loggerAspect(UserOperLoggerService userOperLoggerService) {
        LoggerAspect loggerAspect = new LoggerAspect();
        loggerAspect.setUserOperLoggerService(userOperLoggerService);
        return loggerAspect;
    }
}
