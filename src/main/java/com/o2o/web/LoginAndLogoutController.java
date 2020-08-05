package com.o2o.web;

import com.o2o.entity.PersonInfo;
import com.o2o.exceptions.ShopOperationException;
import com.o2o.service.impl.PersonInfoServiceImpl;
import com.o2o.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/v1/o2o/user")
public class LoginAndLogoutController {

  @Autowired
  private PersonInfoServiceImpl personInfoService;

  @RequestMapping(value = "/login", method = {RequestMethod.GET})
  public String login(){
    return "shop/login";
  }

  @RequestMapping(value = "/login", method = {RequestMethod.POST})
  public void userLogin(HttpServletRequest request) throws NoSuchAlgorithmException {
    String email = HttpServletRequestUtil.getString(request, "email");
    String pwd = HttpServletRequestUtil.getString(request, "pwd");
    PersonInfo personInfo = personInfoService.validUser(email, pwd);
    if (personInfo != null){
      if (personInfo.getEnableStatus() == 0){
        throw new ShopOperationException("you account is unavailable right now" + email);
      }
      request.getSession().setAttribute(personInfo.getUserId().toString(), personInfo);
      switch (personInfo.getUserType()){
        case 1:
          //跳转到对应页
        case 2:
          //跳转到对应页
        case 3:
          //跳转到对应页
        default:
          //跳转到对应页
      }
    }else{
      throw new ShopOperationException("can not find user : " + email);
    }
  }


  @RequestMapping(value = "/logout", method = {RequestMethod.POST})
  public void logout(HttpServletRequest request){
    String userId = HttpServletRequestUtil.getString(request, "userId");
    HttpSession session = request.getSession();
    session.removeAttribute(userId);
    //TODO 重定向到首页或者登陆页
  }


}
