package com.itheima.service;

/**
 * 包名:com.itheima.service
 * 作者:Leevi
 * 日期2020-02-16  10:47
 */
public interface UserService {
    void add();//添加方法
    void delete();//删除方法
    void update();//修改方法

    void findAll() throws InterruptedException;
}
