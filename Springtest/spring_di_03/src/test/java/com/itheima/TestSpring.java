package com.itheima;

import com.itheima.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2020-02-15  09:13
 */
public class TestSpring {
    @Test
    public void test01(){
        //创建UserController对象
        //1. 创建spring的核心容器
        ApplicationContext act = new ClassPathXmlApplicationContext("spring.xml");
        //2. 从核心容器中根据id获取UserController的对象
        UserController userController = (UserController) act.getBean("userController");

        //调用它的saveUser()方法
        userController.saveUser();
    }
}
