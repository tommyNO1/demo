package com.o2o.web;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.SessionCookieConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WebInterceptor implements HandlerInterceptor {

  //处理器方法映射之前执行
  //返回true，放行；false，不放行
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    System.out.println("处理器方法映射之前执行");
    Object userId = request.getAttribute("userId");
    HttpSession session = request.getSession();
    Object attribute = session.getAttribute(userId.toString());
    if (attribute == null){
      return false;
    }else{
      return true;
    }

  }

  //处理器方法映射执行之后会自动调用
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    System.out.println("处理器方法映射执行之后会自动调用");
  }

  //所有请求完成之后调用
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    System.out.println("所有请求完成之后调用");
  }

}
