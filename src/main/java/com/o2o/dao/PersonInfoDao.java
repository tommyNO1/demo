package com.o2o.dao;

import com.o2o.entity.PersonInfo;

public interface PersonInfoDao extends BaseDao<PersonInfo>{

  PersonInfo validUser(String email, String pwd);

  PersonInfo findUserWithEmail(String email);

}
