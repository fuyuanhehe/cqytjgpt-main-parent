package com.ccttic.task.execute;

import com.ccttic.task.feign.IDriverServiceFeign;
import com.ccttic.task.feign.ISceenTotalFeign;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class ScreenTotalTask extends QuartzJobBean {
    @Autowired
    private ISceenTotalFeign feign;
    //执行方法
    @Override
    protected void executeInternal(JobExecutionContext arg) throws JobExecutionException {
        feign.screenTotal();
    }
}