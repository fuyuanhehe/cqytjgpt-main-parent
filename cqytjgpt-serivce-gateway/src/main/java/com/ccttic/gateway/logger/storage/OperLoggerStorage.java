package com.ccttic.gateway.logger.storage;

import com.ccttic.entity.OperLogger;
import com.ccttic.gateway.service.OperLoggerService;
import com.ccttic.util.common.SystemEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.*;

@Component
public class OperLoggerStorage {
    private Logger logger = LoggerFactory.getLogger(OperLoggerStorage.class);

    @Autowired
    private OperLoggerService operLoggerService;

    // 是不是开启
    private volatile static boolean enabled = true;

    // 任务队列 500
    private static final BlockingQueue<OperLogger> taskQueue = new LinkedBlockingQueue<>(500);

    // 任务队列线程池
    public ExecutorService executorService = null;

    private MonitorOperLoggerStorage monitorOperLoggerStorage = null;

    // 初始化应用
    @PostConstruct
    public void init() {
        if (logger.isInfoEnabled()) {
            logger.info("开始初始化OperLoggerStorage#executorService,执行线程数 {}", SystemEnvironment.PROCESSOR);
        }
        executorService = Executors.newFixedThreadPool(SystemEnvironment.PROCESSOR);
        record();
    }

    // 启动工作线程
    public void record() {
        MonitorOperLoggerStorage monitorOperLoggerStorage = new MonitorOperLoggerStorage(executorService, operLoggerService);
        monitorOperLoggerStorage.setName("OperLoggerStorage-thread");
        monitorOperLoggerStorage.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        monitorOperLoggerStorage.start();
    }

    // 监听任务的线程
    public  static class MonitorOperLoggerStorage extends Thread {
        public ExecutorService executorService = null;
        private OperLoggerService operLoggerService;

        public  MonitorOperLoggerStorage(ExecutorService executorService, OperLoggerService operLoggerService) {
            this.executorService = executorService;
            this.operLoggerService = operLoggerService;
        }

        @Override
        public void run() {
            while (enabled && !Thread.currentThread().isInterrupted()) {
                try {
                    executorService.execute(new OperLoggerStorageTask(operLoggerService, taskQueue.take()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // 中断线程，并且销毁资源
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // 执行任务的线程
    public static class OperLoggerStorageTask implements Runnable {
        private OperLoggerService operLoggerService;
        private OperLogger operLogger;

        public OperLoggerStorageTask(OperLoggerService operLoggerService, OperLogger operLogger) {
            this.operLoggerService = operLoggerService;
            this.operLogger = operLogger;
        }

        @Override
        public void run() {
            operLoggerService.addOperlog(operLogger);
        }
    }

    class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            logger.error("线程{}执行异常，{}，重新启动新的线程", t.getName(), e.getCause().getMessage());
            if (!t.isInterrupted()) {
                t.interrupt();
                monitorOperLoggerStorage = new MonitorOperLoggerStorage(executorService, operLoggerService);
                monitorOperLoggerStorage.setName("OperLoggerStorage-thread");
                monitorOperLoggerStorage.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
                monitorOperLoggerStorage.start();
            }
        }
    }

    // 在应用销毁之前执行
    @PreDestroy
    public void destroy() {
        enabled = false;
        monitorOperLoggerStorage.interrupt();
        if (executorService != null && !executorService.isShutdown()) {
            try {
                executorService.shutdown();
                if (logger.isInfoEnabled()) {
                    logger.info("正在关闭OperLoggerStorage#executorService");
                }
                // 60 s 没有执行完毕将强制关闭
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    if (logger.isInfoEnabled()) {
                        logger.info("OperLoggerStorage#executorService等待{}秒没有关闭，正在强制关闭", 60);
                    }
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean enabled) {
        enabled = enabled;
    }

    public static void addOperLoggerStorage(OperLogger operLogger) {
        if (enabled) {
            try {
                taskQueue.put(operLogger);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
