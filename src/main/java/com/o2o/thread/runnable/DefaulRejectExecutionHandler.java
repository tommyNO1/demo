package com.o2o.thread.runnable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;


public class DefaulRejectExecutionHandler implements RejectedExecutionHandler {
  Logger logger = LoggerFactory.getLogger(DefaulRejectExecutionHandler.class);


  @Override
  public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
    logger.error("defaultPoolReject " + Integer.toHexString(r.hashCode()) + " from " + executor.toString());
  }
}
