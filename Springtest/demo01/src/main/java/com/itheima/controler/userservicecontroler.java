package com.itheima.controler;

import com.itheima.beanfactory.BeanFactory;
import com.itheima.beanfactory.factorybean;

import com.itheima.service.userservice;

/**
 * 包名:com.itheima.controler
 * 程序猿:wushengdaozu
 * 日期: 2020--02--13    13:47:25
 */
public class userservicecontroler {
 public void getName(){
  //userservice userservice = (userservice) factorybean.getBean("com.itheima.service.serviceImpl");
  userservice userservice = (userservice) BeanFactory.getBean("userservice");
  String name = userservice.getname();
  System.out.println(name);
 }

 public static void main(String[] args) {
  userservicecontroler userservicecontroler = new userservicecontroler();
  userservicecontroler.getName();
 }
}
