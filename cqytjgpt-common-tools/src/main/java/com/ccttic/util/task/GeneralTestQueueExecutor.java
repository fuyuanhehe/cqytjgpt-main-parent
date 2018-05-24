package com.ccttic.util.task;

import com.ccttic.util.common.SystemEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.relation.RoleUnresolved;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class GeneralTestQueueExecutor {
    // 日志
    private Logger logger = LoggerFactory.getLogger(GeneralTestQueueExecutor.class);

    // 重试的Map
    private ConcurrentHashMap<WrapTask, Integer> retryMap = new ConcurrentHashMap<>();
    /**
     * 说明：监听器的线程池
     */
    private final ExecutorService listenerService;

    /**
     * 说明：存储执行任务的队列
     */
    private final BlockingQueue<WrapTask> task_queue;

    /**
     * 说明：执行任务的工作线程
     */
    private final ExecutorService executorService;

    /**
     * 开关
     */
    private volatile boolean enabled = true;

    /**
     * 说明：ListenerWorker持有
     */
    private final List<ListenerWorker> listenerWorkers = new LinkedList<>();

    /**
     * 要启动的监听者数量
     */
    private int consumer = 1;

    public GeneralTestQueueExecutor(int workerThreadNumber, int queueBorder, int consumer) {
        // 初始化
        if (workerThreadNumber < 1)
            workerThreadNumber = SystemEnvironment.PROCESSOR;
        this.executorService = Executors.newFixedThreadPool(workerThreadNumber);
        if (queueBorder < 1)
            queueBorder = 500;
        this.task_queue = new LinkedBlockingQueue<>(queueBorder);
        if (consumer > 1)
            this.consumer = consumer;
        this.listenerService = Executors.newFixedThreadPool(this.consumer);
    }

    /**
     * 开始执行
     */
    public void start() {
        if (logger.isInfoEnabled()) {
            logger.info("GeneralTestQueueExecutor 开始执行....");
        }
        // 开始设置监听者,并执行
        for (int i = 0; i < consumer; i++) {
            final ListenerWorker listenerWorker = new ListenerWorker();
            listenerWorker.setName("ListenerWorker-thread-" + i);
            listenerWorker.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler(listenerWorker));
            listenerService.execute(listenerWorker);
            listenerWorkers.add(listenerWorker);
        }
    }

    public void putTask(Runnable runnable) {
        if (enabled) {
            try {
                WrapTask wrapTask = new WrapTask(runnable);
                wrapTask.setUncaughtExceptionHandler(new WrapTaskUncaughtExceptionHandler(wrapTask));
                task_queue.put(wrapTask);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 说明：true开启，false关闭
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        synchronized (this) {
            if (this.enabled) {
                for (ListenerWorker worker : listenerWorkers) {
                    listenerService.execute(worker);
                }
            }
        }
    }

    /**
     * 说明：销毁资源
     */
    public void destroy() {
        this.enabled = false;
        // 不在监听任务了
        synchronized (listenerWorkers) {
            listenerWorkers.clear();
        }
        if (listenerWorkers != null && !listenerService.isShutdown()) {
            listenerService.shutdown();
            try {
                if (listenerService.awaitTermination(60, TimeUnit.SECONDS)) {
                    logger.error("强制关闭listenerService");
                    listenerService.shutdownNow();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdown();
            try {
                if (executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    logger.error("executorService");
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 说明：监听者
     */
    class ListenerWorker extends Thread {
        private Random random = new Random();

        @Override
        public void run() {
            WrapTask wrapTask = null;
            while (enabled && !Thread.currentThread().isInterrupted()) {
                try {
                    wrapTask = task_queue.take();
                    // 沉睡随机时间,防止大量数据摧毁系统
                    Thread.sleep(random.nextInt(300));
                    executorService.execute(wrapTask);
                    if (retryMap.get(wrapTask) != null)
                        retryMap.remove(wrapTask);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

        private ListenerWorker listenerWorker;

        public MyUncaughtExceptionHandler(ListenerWorker listenerWorker) {
            this.listenerWorker = listenerWorker;
        }
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            logger.error("线程名称：" + t.getName() + " listenerWorker 出现异常：" + e.getMessage() + " 重新启动中");
            synchronized (listenerWorker) {
                listenerWorkers.remove(listenerWorker);
                listenerWorker.interrupt();
                final ListenerWorker newWorker = new ListenerWorker();
                newWorker.setName(listenerWorker.getName());
                newWorker.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler(newWorker));
                listenerService.execute(newWorker);
                listenerWorkers.add(newWorker);
            }
        }
    }

    class WrapTask extends Thread {
        private Runnable runnable;

        public WrapTask(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override
        public void run() {
            runnable.run();
        }
    }

    class WrapTaskUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

        private WrapTask wrapTask;

        public WrapTaskUncaughtExceptionHandler(WrapTask wrapTask) {
            this.wrapTask = wrapTask;
        }

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            logger.error("线程名称：" + t.getName() + " wrapTask 出现异常：" + e.getMessage() + " 重新执行3次");
            Integer retry = 1;
            // 判断是不是重新执行的队列
            if (retryMap.get(wrapTask) != null) {
                retry = retryMap.get(wrapTask);
                retry = retry + 1;
                retryMap.put(wrapTask, retry);
            }
            try {
                if (retry < 3)
                    task_queue.put(wrapTask);
                else
                    retryMap.remove(wrapTask);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
}
