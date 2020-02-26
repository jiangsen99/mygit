package com.itheima.factory;

/**
 * 包名:com.itheima.factory
 * 程序猿:wushengdaozu
 * 日期: 2020--02--13    15:59:26
 */
public class beanFactory {
 public static Object getBean(String forName) {
  try {
   return Class.forName(forName).newInstance();
  } catch (Exception e) {
   e.printStackTrace();
   throw new RuntimeException("创建对象失败");
  }
 }
}
