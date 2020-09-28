package com.o2o.service;

import com.o2o.dto.WechatAuthExecution;
import com.o2o.entity.WechatAuth;
import com.o2o.exceptions.WechatAuthOperationException;
import org.springframework.stereotype.Service;

public interface WechatAuthService {
    /*
    * 通过openId查找平台对应的微信账号
    *
    * @param openId
    * @return
    * */
    WechatAuth getWechatAuthByOpenId(String openId);

    /*
    * 注册本平台的微信账号
    * @param wechatAuth
    * @param profileImg
    * @return
    * */
    WechatAuthExecution register(WechatAuth wechatAuth) throws WechatAuthOperationException;

}
