package com.o2o.entity;

import lombok.Data;


@Data
public class HeadLine  extends BaseEntity{
    private Long lineId;
    private String lineName;
    private String lineLink;
    private String lineImg;
    private Integer priority;
    //0表示不可用 1表示可用
    private Integer enableStatus;



}
