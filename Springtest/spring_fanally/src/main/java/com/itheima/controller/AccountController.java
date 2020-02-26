package com.itheima.controller;

import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * 包名:com.itheima.controller
 * 程序猿:wushengdaozu
 * 日期: 2020--02--18    10:19:58
 */
@Controller
public class AccountController {


 @Autowired
 private AccountService accountService;

 public void tansfer(int fromid, int toid, double money) {
  try {
   accountService.transfer(fromid, toid, money);
   System.out.println("转账成功");
  } catch (Exception e) {
   e.printStackTrace();
   System.out.println("转账失败");
  }
 }

 public static void main(String[] args) {
  ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
  AccountController accountController = (AccountController) classPathXmlApplicationContext.getBean("accountController");
  accountController.tansfer(1,2,3);
 }

}
