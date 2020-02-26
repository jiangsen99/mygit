package com.itheima.factory;

import com.itheima.service.ServiceImpl;
import com.itheima.service.UserService;

/**
 * 包名:com.itheima.factory
 * 程序猿:wushengdaozu
 * 日期: 2020--02--13    17:19:19
 */
public class FactoryInstance {
 public UserService getUserService() {
  System.out.println("调用了实例工厂对象的方法....");
  return new ServiceImpl();
 }
}