package com.itheima.factory;

import com.itheima.service.ServiceImpl;
import com.itheima.service.UserService;

/**
 * 包名:com.itheima.factory
 * 程序猿:wushengdaozu
 * 日期: 2020--02--13    17:04:52
 */
public class FactoryBean {
  public static UserService getBean(){
   System.out.println("静态方法调用了");
   return new ServiceImpl();
      }
}
