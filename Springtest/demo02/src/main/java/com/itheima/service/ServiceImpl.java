package com.itheima.service;

/**
 * 包名:com.itheima.service
 * 程序猿:wushengdaozu
 * 日期: 2020--02--13    15:48:31
 */
public class ServiceImpl implements UserService {
 public ServiceImpl(){
  System.out.println("ServiceImpl被创建了");
 }
 @Override
 public String getName() {
  return "你好世界!";
 }
}
