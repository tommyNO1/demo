package com.o2o.common.threadPool;

import com.o2o.util.thread.ThreadPoolBuilder;
import com.o2o.util.thread.runnable.DefaultExecutorService;

public class AsyncThreadPool {

  private static AsyncThreadPool singleton = new AsyncThreadPool();
  private final DefaultExecutorService threadPool;
  private String poolName = "async-pool";

  public static int ASYNS_QUEUE = 10000;

  public static int ASYNC_CORE_THREAD = Runtime.getRuntime().availableProcessors() * 2;

  public static int ASYNC_MAX_THREAD = 16;

  private AsyncThreadPool() {
    ThreadPoolBuilder builder = new ThreadPoolBuilder();
    builder.withGroupName(poolName)
            // 设置队列最大长度
            .withWorkQueueSize(ASYNS_QUEUE)
            // 设置线程池核心线程数
            .withCorePoolSize(ASYNC_CORE_THREAD)
            // 设置线程池最大值
            .withMaximumPoolSize(ASYNC_MAX_THREAD)
            // 打开线程池内部监控日志
            .withUseMetric(true);
    threadPool = builder.limitQueueBuilder();
  }

  public static AsyncThreadPool instance() {
    return singleton;
  }

  public void execute(Runnable runnable) {
    threadPool.execute(runnable);
  }

}
