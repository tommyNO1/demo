package com.o2o.util.thread;

import com.o2o.util.thread.runnable.DefaulRejectExecutionHandler;
import com.o2o.util.thread.runnable.DefaultExecutorService;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.TimeUnit;

public class ThreadPoolBuilder {

  /**
   * 默认一个核心线程
   */
  private int                      corePoolSize    = 1;
  /**
   * 默认最大线程数为CPU核数的2倍
   */
  private int                      maximumPoolSize = Runtime.getRuntime().availableProcessors() * 2;
  /**
   * 线程存活时间，对于超过核心线程数的线程，当线程处理空闲状态下，且维持时间达到keepAliveTime时，线程将被销毁；
   */
  private long                     keepAliveTime   = 10;
  /**
   * 单位是秒
   */
  private TimeUnit unit            = TimeUnit.SECONDS;
  /**
   * 默认工作队列长度为1000
   */
  private int                      workQueueSize   = 1000;
  /**
   * 线程名
   */
  private String                   groupName       = "default-pool";
  /**
   * 拒接处理
   */
  private RejectedExecutionHandler rejectHandler   = new DefaulRejectExecutionHandler();

  /**
   * 是否使用度量
   */
  private boolean useMetric = false;

  /**
   * 在创建线程池的时候进行参数检查
   */
  private void buildCheck() {
    if (this.corePoolSize > this.maximumPoolSize) {
      this.maximumPoolSize = 2 * this.corePoolSize;
    }
  }


  /**
   * 产生无边界的线程池
   *
   * @return
   */
  public DefaultExecutorService unlimitQueueBuilder() {
    buildCheck();
    return new DefaultExecutorService(corePoolSize, maximumPoolSize, keepAliveTime,
            unit, new LinkedBlockingDeque<>(), new DefaultThreadFactory(groupName), rejectHandler, useMetric, groupName);
  }

  /**
   * 建立有界的线程池
   *
   * @return
   */
  public DefaultExecutorService limitQueueBuilder() {
    buildCheck();
    return new DefaultExecutorService(corePoolSize, maximumPoolSize, keepAliveTime,
            unit, new ArrayBlockingQueue<>(workQueueSize), new DefaultThreadFactory(groupName), rejectHandler, useMetric, groupName);
  }


  public ThreadPoolBuilder withCorePoolSize(int corePoolSize) {
    if (corePoolSize > 0) {
      this.corePoolSize = corePoolSize;
    }
    return this;
  }

  public ThreadPoolBuilder withMaximumPoolSize(int maximumPoolSize) {
    if (maximumPoolSize >= 0) {
      this.maximumPoolSize = maximumPoolSize;
    }
    return this;
  }

  public ThreadPoolBuilder withKeepAliveTime(long keepAliveTime) {
    this.keepAliveTime = keepAliveTime;
    return this;
  }

  public ThreadPoolBuilder withUnit(TimeUnit unit) {
    this.unit = unit;
    return this;
  }

  public ThreadPoolBuilder withWorkQueueSize(int workQueueSize) {
    this.workQueueSize = workQueueSize;
    return this;
  }

  public ThreadPoolBuilder withGroupName(String groupName) {
    this.groupName = groupName;
    return this;
  }

  public ThreadPoolBuilder withRejectHandler(RejectedExecutionHandler rejectHandler) {
    this.rejectHandler = rejectHandler;
    return this;
  }

  public ThreadPoolBuilder withUseMetric(boolean useMetric) {
    this.useMetric = useMetric;
    return this;
  }


}
