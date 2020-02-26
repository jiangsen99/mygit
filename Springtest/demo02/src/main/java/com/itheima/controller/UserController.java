package com.itheima.controller;


import com.itheima.factory.beanFactory;
import com.itheima.service.UserService;
import com.sun.xml.internal.txw2.NamespaceResolver;

/**
 * 包名:com.itheima.controller
 * 作者:Leevi
 * 日期2020-02-13  10:17
 * 面向接口编程:
 */
public class UserController {
 public static void main(String[] args) {

 
  UserService userService= (UserService) beanFactory.getBean("com.itheima.service.ServiceImpl");
  String name = userService.getName();
  System.out.println(name);
 }

}
