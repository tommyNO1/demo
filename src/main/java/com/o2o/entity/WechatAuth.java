package com.o2o.entity;

import lombok.Data;


@Data
public class WechatAuth extends BaseEntity{
    private Long wechatAuthId;
    private String openId;
    private PersonInfo personInfo;

    }
