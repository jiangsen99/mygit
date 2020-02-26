package com.itheima.controller;

import com.itheima.factory.InstanceFactory;
import com.itheima.factory.StaticFactory;
import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 包名:com.itheima.controller
 * 作者:Leevi
 * 日期2020-02-13  11:50
 * spring的使用步骤:
 * 1. 引入spring的依赖(固定的)
 * 2. 创建spring的配置文件(引入约束文件)重点
 * 3. 创建spring的核心容器(固定的)
 * 4. 使用spring的核心容器获取根据id获取对象(固定的)
 */
public class UserController {
    public static void main(String[] args) {
        //调用UserServiceImpl类的getName方法，获取名字
        //1.左边变量声明成接口类型
        //2.右边的让别人(spring的核心容器)帮我们创建对象

        //创建spring的核心容器对象,指定要读取的配置文件
        ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
        //FileSystemXmlApplicationContext act = new FileSystemXmlApplicationContext("C:/JavaEE_Relation/JavaEE86/beans.xml");

        //我们要创建的对象，就在act核心容器中
        //我们根据id，从核心容器中获取对象
        UserService userService = (UserService) act.getBean("userService");

        UserService userService1 = (UserService) act.getBean("userService");

        System.out.println(userService == userService1);
        //String name = userService.getName();
        //System.out.println(name);

        //act.close();//核心容器销毁，那么对象也销毁(只针对单例的情况)
    }
}
