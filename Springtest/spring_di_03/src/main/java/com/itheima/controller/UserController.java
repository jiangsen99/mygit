package com.itheima.controller;

import com.itheima.service.UserService;

import java.util.Map;

/**
 * 包名:com.itheima.controller
 * 作者:Leevi
 * 日期2020-02-15  09:10
 * 模拟三层结构
 * 依赖注入的目标:给对象的成员变量赋值!!!
 * 外部怎么才能给一个类的私有成员变量赋值:
 * 1. set方法
 * 2. 构造函数
 */
public class UserController {
    private UserService userService;//注入对象类型
    private String username;//注入简单类型
    private String[] hobbies;//注入数组类型(了解)
    private Map<String,Object> map;//注入map类型的数据

    public UserController() {
    }

    public UserController(UserService userService, String username,String[] hobbies,Map<String,Object> map) {
        this.userService = userService;
        this.username = username;
        this.hobbies = hobbies;
        this.map = map;
    }

    /*public void setUsername(String username) {
        this.username = username;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/

    public void saveUser(){
        //调用业务层的方法来保存用户信息
        System.out.println(map);
        userService.saveUser();
    }
}
