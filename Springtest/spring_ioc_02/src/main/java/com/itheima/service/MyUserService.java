package com.itheima.service;

/**
 * 包名:com.itheima.service
 * 作者:Leevi
 * 日期2020-02-13  12:04
 * 目标:
 *    在MyUserService对象创建的时候调用initMethod()方法
 *    在MyUserService对象销毁的时候调用destroyMethod()方法
 */
public class MyUserService implements UserService{

    public void initMethod(){
        System.out.println("MyUserService对象的创建了...");
    }

    public void destroyMethod(){
        System.out.println("MyUserService对象销毁了...");
    }

    @Override
    public String getName() {
        return "奥巴马";
    }
}
