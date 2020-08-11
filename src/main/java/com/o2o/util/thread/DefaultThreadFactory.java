package com.o2o.util.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadFactory implements ThreadFactory {
  private final AtomicInteger threadNumber = new AtomicInteger(1);
  private final ThreadGroup group;
  private final String namePrefix;

  public DefaultThreadFactory(String namePrefix) {
    SecurityManager s = System.getSecurityManager();
    group =(s != null) ?s.getThreadGroup():Thread.currentThread().getThreadGroup();
    this.namePrefix=namePrefix+"-";
  }


  @Override
  public Thread newThread(Runnable r) {
    return new Thread(group,r,namePrefix+threadNumber.getAndIncrement(),0);
  }
}
