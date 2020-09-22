package com.o2o.dao;

import com.o2o.BaseTest;
import com.o2o.entity.PersonInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PersonInfoDaoTest extends BaseTest  {
    @Autowired
    private PersonInfoDao personInfoDao;

    @Test
    @Ignore
    public void testInsertPersonInfo(){
        PersonInfo personInfo = new PersonInfo();
        personInfo.setName("小鸣");
        personInfo.setGender("1");
        personInfo.setEmail("testEmail");
        personInfo.setCreateTime(new Date());
        personInfo.setLastEditTime(new Date());
        personInfo.setProfileImg("textProfile");
        personInfo.setUserType(1);
        personInfo.setEnableStatus(1);
        int effectNum  = personInfoDao.insertPersonInfo(personInfo);
        assertEquals(1,effectNum);
    }

    @Test
    public void testQueryPersonInfoById(){
        PersonInfo personInfo = personInfoDao.queryPersonInfoById(8);
        System.out.println(personInfo.getName());
    }


}
