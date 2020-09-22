package com.o2o.dao;

import com.o2o.BaseTest;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.WechatAuth;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class WechatAuthDaoTest extends BaseTest {

    @Autowired
    private WechatAuthDao wechatAuthDao;

    @Test
    @Ignore
    public void testInsertWechatAuth(){
        WechatAuth wechatAuth = new WechatAuth();
        wechatAuth.setOpenId("text");
        wechatAuth.setCreateTime(new Date());
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(1l);
        wechatAuth.setPersonInfo(personInfo);
        int effectNum = wechatAuthDao.insertWechatAuth(wechatAuth);
        assertEquals(1,effectNum);
    }

    @Test
    public void testQueryWechatAuthByOpenId(){
        WechatAuth wechatAuth = wechatAuthDao.queryWechatInfoByOpenId("ovLbns-gxJHqC-UTPQKvgEuENl-E");
        System.out.println(wechatAuth.getWechatAuthId());
        System.out.println(wechatAuth.getPersonInfo().getName());
    }



}
