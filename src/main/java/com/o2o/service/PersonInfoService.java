package com.o2o.service;

import com.o2o.entity.PersonInfo;

import java.security.NoSuchAlgorithmException;

public interface PersonInfoService extends BaseService<PersonInfo> {

  PersonInfo validUser(String email, String pwd) throws NoSuchAlgorithmException;

}
