package com.itheima.factory;

import com.itheima.service.MyUserService;
import com.itheima.service.UserService;

/**
 * 包名:com.itheima.factory
 * 作者:Leevi
 * 日期2020-02-13  14:48
 * 实例工厂:工厂中的方法，不是静态方法，需要先创建工厂对象才能调用方法
 */
public class InstanceFactory {
    /**
     * 这个方法也是创建MyUserService对象
     * @return
     */
    public UserService getUserService(){
        System.out.println("调用了实例工厂对象的方法....");
        return new MyUserService();
    }
}
