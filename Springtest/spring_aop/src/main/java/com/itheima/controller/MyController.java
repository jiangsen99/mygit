package com.itheima.controller;

import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;

/**
 * 包名:com.itheima.controller
 * 程序猿:wushengdaozu
 * 日期: 2020--02--16    13:38:27
 */@Controller
public class MyController {
  @Autowired
 private AccountService accountService;
 public void transfer(int fromid,int intid,double money) throws SQLException {
  boolean flag=accountService.transfer(fromid,intid,money);
  if(flag){
   System.out.println("转账成功");
  }else {
   System.out.println("转账失败");
 }

 }
}
