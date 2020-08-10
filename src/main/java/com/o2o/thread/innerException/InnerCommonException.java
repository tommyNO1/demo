package com.o2o.thread.innerException;

public class InnerCommonException extends RuntimeException {
  public InnerCommonException(String message, Throwable cause) {
    super(message, cause);
  }
}
