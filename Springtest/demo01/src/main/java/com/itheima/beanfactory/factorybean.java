package com.itheima.beanfactory;

import com.itheima.service.serviceImpl;

/**
 * 包名:com.itheima.beanfactory
 * 程序猿:wushengdaozu
 * 日期: 2020--02--13    13:32:35
 */
public class factorybean {
 public static Object getBean(String className) {
  //使用反射，创建类的对象
  try {
   return Class.forName(className).newInstance();
  } catch (Exception e) {
   e.printStackTrace();
   throw new RuntimeException("创建对象失败");
  }
 }
}