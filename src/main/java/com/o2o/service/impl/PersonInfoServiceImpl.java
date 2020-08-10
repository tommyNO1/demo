package com.o2o.service.impl;


import com.o2o.dao.PersonInfoDao;
import com.o2o.entity.PersonInfo;
import com.o2o.exceptions.ShopOperationException;
import com.o2o.service.PersonInfoService;
import com.o2o.util.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
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
  public void insertOne(PersonInfo personInfo) throws Exception {
    PersonInfo userWithEmail = personInfoDao.findUserWithEmail(personInfo.getEmail());
    String sha256Pwd = EncodeUtil.SHA256(personInfo.getPassword());
    if (userWithEmail != null){
      throw new Exception("this email has signed up by other people");
    }else{
      personInfo.setPassword(sha256Pwd);
      personInfoDao.insert(personInfo);
    }
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


  @Override
  public PersonInfo validUser(String email, String pwd) throws NoSuchAlgorithmException {
    String encodePwd = EncodeUtil.SHA256(pwd);
    PersonInfo personInfo = personInfoDao.validUser(email, encodePwd);
    return personInfo;
  }

  @Override
  public void signUp(PersonInfo personInfo) throws Exception {
    PersonInfo userWithEmail = personInfoDao.findUserWithEmail(personInfo.getEmail());
    if (userWithEmail != null){
      throw new ShopOperationException("this email has been used");
    }
    String encodePwd = EncodeUtil.SHA256(personInfo.getPassword());
    personInfo.setPassword(encodePwd);
    personInfoDao.insert(personInfo);
  }

}
