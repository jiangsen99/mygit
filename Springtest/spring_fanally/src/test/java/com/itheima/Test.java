package com.itheima;

import com.itheima.controller.AccountController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 包名:com.itheima
 * 程序猿:wushengdaozu
 * 日期: 2020--02--18    13:09:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class Test {
 @Autowired
private AccountController accountController;
 @org.junit.Test
public void test(){
  accountController.tansfer(1,2,5);
 }
}
