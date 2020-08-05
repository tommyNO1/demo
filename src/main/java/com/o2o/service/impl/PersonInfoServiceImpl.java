package com.o2o.service.impl;


import com.o2o.dao.PersonInfoDao;
import com.o2o.entity.PersonInfo;
import com.o2o.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PersonInfoServiceImpl implements PersonInfoService {

  @Autowired
  private PersonInfoDao personInfoDao;


  @Override
  @Transactional(readOnly = true)
  public PersonInfo getById(Long id) {
    PersonInfo personInfo = personInfoDao.queryById(id);
    return personInfo;
  }

  @Override
  public void updateById(PersonInfo personInfo) {
    personInfoDao.update(personInfo);
  }

  @Override
  public void insertOne(PersonInfo personInfo) {
    personInfoDao.insert(personInfo);
  }

  @Override
  public void deleteManyByIds(Long... ids) {
    for(Long id: ids){
      personInfoDao.deleteById(id);
    }
  }

  @Override
  @Transactional(readOnly = true)
  public List<PersonInfo> basePageList(Map map) {
    List<PersonInfo> list = personInfoDao.getList(map);
    return list;
  }



}
