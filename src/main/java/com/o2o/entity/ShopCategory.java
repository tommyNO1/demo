package com.o2o.entity;

import lombok.Data;


@Data
public class ShopCategory extends BaseEntity{
    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private ShopCategory parent;


}
