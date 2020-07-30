package com.o2o.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ProductImg extends BaseEntity{
    private Long productImgId;
    private String imgAddr;
    private String imgDesc;
    private Integer priority;
    private Date createTime;
    private Long productID;


}
