package com.itheima.controller;

import com.itheima.factory.BeanFactory;
import com.itheima.service.UserService;
/**
 * 包名:com.itheima.controller
 * 作者:Leevi
 * 日期2020-02-13  10:17
 * 面向接口编程:
 */
public class UserController {
   /* public void getName(){
        //调用UserServiceImpl对象的getName方法
        //1. 变量类型，声明成"接口类型"
        //这里其实就是多态(它是解耦中必不可少的东西)

        //2. 右边创建对象，一定要由别人帮我们创建对象
        UserService userService = (UserService) BeanFactory.getBean("com.itheima.service.UserServiceImpl");//创建UserServiceImpl类的对象

        String name = userService.getName();

        System.out.println(name);
    }*/
    public void getName(){
       //调用UserServiceImpl对象的getName方法
       //1. 变量类型，声明成"接口类型"
       //这里其实就是多态(它是解耦中必不可少的东西)

       //2. 右边创建对象，一定要由别人帮我们创建对象
       UserService userService = (UserService) BeanFactory.getBean("userService");//创建UserServiceImpl类的对象

       String name = userService.getName();

       System.out.println(name);
    }

    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.getName();
    }
}
