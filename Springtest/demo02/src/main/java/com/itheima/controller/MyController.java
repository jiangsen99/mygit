package com.itheima.controller;

import com.itheima.factory.FactoryBean;
import com.itheima.factory.FactoryInstance;
import com.itheima.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 包名:com.itheima.controller
 * 程序猿:wushengdaozu
 * 日期: 2020--02--13    16:28:15
 */
public class MyController {
 public static void main(String[] args) {
  ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
  UserService userservice = (UserService) classPathXmlApplicationContext.getBean("userservice");
  UserService userservice2 = (UserService) classPathXmlApplicationContext.getBean("userservice");
  System.out.println(userservice == userservice2);
  UserService userService3 = FactoryBean.getBean();
  FactoryInstance factoryInstance = new FactoryInstance();
  UserService userService4 = factoryInstance.getUserService();
 /* FileSystemXmlApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext("d:/bean.xml");
  UserService userservice = (UserService) fileSystemXmlApplicationContext.getBean("userservice");*/
  String name = userservice.getName();
  System.out.println(name);


 }
}
