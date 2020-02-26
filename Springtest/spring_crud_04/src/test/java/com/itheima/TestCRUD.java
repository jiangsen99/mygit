package com.itheima;

import com.itheima.controller.AccountController;
import com.itheima.pojo.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2020-02-15  10:39
 */
public class TestCRUD {
    @Test
    public void testFindAll() throws SQLException {
        //创建AccountController的对象，调用findAll()方法
        //1. 创建spring的核心容器
        ApplicationContext act = new ClassPathXmlApplicationContext("spring.xml");
        //2. 从核心容器中获取AccountController对象
        AccountController accountController = (AccountController) act.getBean("accountController");
        List<Account> accountList = accountController.findAll();

        System.out.println(accountList);
    }
}
