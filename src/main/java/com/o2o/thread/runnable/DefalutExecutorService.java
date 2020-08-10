package com.o2o.thread.runnable;

import com.o2o.thread.innerException.InnerCommonException;

import java.util.concurrent.*;

public class DefalutExecutorService extends ThreadPoolExecutor{
  private static ScheduledExecutorService scheduleService = Executors.newSingleThreadScheduledExecutor();

  /**
   * 是否使用度量
   */
  private boolean isMetric;

  private String groupName;

  public XlinkExecutorService(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler, boolean userMetric, String groupName) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    this.isMetric = userMetric;
    this.groupName = groupName;
    if (isMetric) {
      scheduleService.scheduleAtFixedRate(() -> {
        XLOG.info("thread pool statistics: groupName={},coreSize={},currentSize={},queueSize={}", this.groupName, this.getCorePoolSize(), this.getPoolSize(), this.getQueue().size());
      }, 0, 60, TimeUnit.SECONDS);

    }
  }

  /**
   * 执行自定义的Runnable类
   *
   * @param xlinkRunnable
   */
  public void execute(XlinkRunnable xlinkRunnable) {
    super.execute(xlinkRunnable);
  }


  @Override
  public String toString() {
    return "[group name = " + groupName +
            ", pool size = " + this.getPoolSize() +
            ", active threads = " + this.getActiveCount() +
            ", queued tasks = " + this.getTaskCount() +
            ", completed tasks = " + this.getCompletedTaskCount() +
            "]";
  }

  /**
   * 执行任务具有超时时间，如果超时，停止执行的线程
   *
   * @param callable 带返回的结果的任务，任务执行完成会返回结果
   * @param timeout
   * @param timeUnit
   * @param <T>      返回结果
   * @return
   */
  public <T> T submitWithTimeOut(Callable<T> callable, long timeout, TimeUnit timeUnit) {
    Future<T> future = super.submit(callable);

    try {
      return future.get(timeout, timeUnit);
    } catch (InterruptedException | TimeoutException | ExecutionException e) {
      future.cancel(true);
      throw new InnerCommonException("ExecutorService timeout", e);
    }
  }

  /**
   * 执行任务具有超时时间，如果超时，停止执行的线程
   *
   * @param callable 无返回结果的任务
   * @param timeout
   * @param timeUnit
   * @return
   */
  public void submitWithTimeOut(Runnable callable, long timeout, TimeUnit timeUnit) {
    Future<?> future = super.submit(callable);

    try {
      future.get(timeout, timeUnit);
    } catch (TimeoutException | InterruptedException e) {
      future.cancel(true);
      e.printStackTrace();
    } catch (ExecutionException e) {
      future.cancel(true);
      e.printStackTrace();
    }
  }
}
