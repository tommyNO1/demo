package com.o2o.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Product extends  BaseEntity{
    private Long productId;
    private String productName;
    private String productDesc;
    //缩略图
    private String imgAddr;
    private String normalPrice;
    private String PromotionPrice;
    private Integer priority;

    //-1不可用 0下架 1在前端展示系统展示
    private Integer enableStatus;

    private List<ProductImg> productImgList;
    private ProductCategory productCategory;
    private Shop shop;

}
