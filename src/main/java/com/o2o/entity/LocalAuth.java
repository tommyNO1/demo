package com.o2o.entity;

import lombok.Data;

import java.util.Date;

@Data
public class LocalAuth {
    private Long localAuthId;
    private String username;
    private String password;

    private PersonInfo personInfo;


}
