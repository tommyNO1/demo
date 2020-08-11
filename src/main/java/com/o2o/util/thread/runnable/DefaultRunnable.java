package com.o2o.util.thread.runnable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class DefaultRunnable implements Runnable {
  Logger logger = LoggerFactory.getLogger(DefaultRunnable.class);


  private long      costTime;
  private Throwable exception;

  public abstract DefaultRunnableType getTaskType();

  public long costTime() {
    return costTime;
  }

  public abstract void execute() throws Throwable;

  @Override
  final public void run() {
    long start = System.currentTimeMillis();
    try {
      execute();
    } catch (Throwable a) {
      exception = a;
    } finally {
      costTime = System.currentTimeMillis() - start;
      if (exception == null) {
        logger.info("XlinkRunnable run success, type {} cost {} ms", this.getTaskType().description(), costTime);
      } else {
        logger.error("XlinkRunnable execute error, type is " + this.getTaskType().description() + ", cost " + costTime + " ms", exception);
      }
    }
  }

  @Override
  public String toString() {
    return getTaskType().description();
  }
}
