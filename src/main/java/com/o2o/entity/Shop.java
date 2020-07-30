package com.o2o.entity;

import lombok.Data;


@Data
public class Shop extends BaseEntity {
    private Long shopId;
    private String shopName;
    private String shopDesc;
    private String shopAddr;
    private String phone;
    private String shopImg;
    private Integer priority;

    //-1不可以 0审核中 1可用
    private Integer enableStatus;
    private String advice;
    private Area area;
    private PersonInfo owner;
    private ShopCategory shopCategory;


}
