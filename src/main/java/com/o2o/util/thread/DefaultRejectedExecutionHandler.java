package com.o2o.util.thread;

import com.o2o.util.thread.runnable.DefaultRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class DefaultRejectedExecutionHandler implements RejectedExecutionHandler {
  Logger logger = LoggerFactory.getLogger(DefaultRejectedExecutionHandler.class);


  @Override
  public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
    logger.error("ThreadPoolReject " + Integer.toHexString(r.hashCode()) + " from " + executor.toString());
  }
}
