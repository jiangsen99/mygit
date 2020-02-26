package com.itheima.service.impl;

import com.itheima.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 包名:com.itheima.service.impl
 * 作者:Leevi
 * 日期2020-02-16  10:48
 * //在增删改方法之前，都添加权限校验的代码
 */
@Service
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("添加用户。。。");
    }

    @Override
    public void delete() {
        System.out.println("删除用户。。。");
    }

    @Override
    public void update() {
        System.out.println("修改用户。。。");
    }

}
