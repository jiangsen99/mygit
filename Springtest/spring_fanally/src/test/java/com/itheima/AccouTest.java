package com.itheima;

import com.itheima.controller.AccountController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 包名:com.itheima
 * 程序猿:wushengdaozu
 * 日期: 2020--02--18    11:18:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccouTest {
 @Autowired
 private AccountController accountController;
 @Test
 public void testTransfer(){
  accountController.tansfer(1,2,300);
 }
}
