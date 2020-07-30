package com.o2o.entity;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseEntity {

  private Date createDate;

  private Date lastEditTime;
}
