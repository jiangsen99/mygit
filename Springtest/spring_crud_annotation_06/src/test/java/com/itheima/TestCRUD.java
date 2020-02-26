package com.itheima;

import com.itheima.controller.AccountController;
import com.itheima.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2020-02-15  10:39
 *
 * 使用spring整合Junit，让我们在执行测试用例的时候，Junit自动给我们创建核心容器
 *  1. 引入spring整合Junit的依赖
 *  2. 通过RunWith注解指定运行的测试环境
 *  3. ContextConfiguration来指定要加载的配置文件或者配置类
 */
@RunWith(SpringJUnit4ClassRunner.class)//指定运行的测试环境
@ContextConfiguration(classes=SpringConfiguration.class)//指定要加载的配置类
public class TestCRUD {
    @Autowired
    private AccountController accountController;
    @Test
    public void testFindAll() throws SQLException {
        /*//创建AccountController的对象，调用findAll()方法
        //1. 创建spring的核心容器(加载配置类，也就是创建一个基于注解的核心容器)
        ApplicationContext act = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        //2. 从核心容器中获取AccountController对象
        AccountController accountController = (AccountController) act.getBean("accountController");*/


        List<Account> accountList = accountController.findAll();
        System.out.println(accountList);
    }
}
