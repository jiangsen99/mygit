package com.itheima.factory;

import com.itheima.service.MyUserService;
import com.itheima.service.UserService;

/**
 * 包名:com.itheima.factory
 * 作者:Leevi
 * 日期2020-02-13  14:39
 */
public class StaticFactory {
    /**
     * 这个方法，就是创建MyUserService 对象的静态方法
     * @return
     */
    public static UserService createUserService(){
        System.out.println("静态工厂方法调用了...");
        return new MyUserService();
    }
}
