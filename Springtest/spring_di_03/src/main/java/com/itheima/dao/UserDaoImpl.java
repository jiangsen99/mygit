package com.itheima.dao;

/**
 * 包名:com.itheima.dao
 * 作者:Leevi
 * 日期2020-02-15  09:11
 */
public class UserDaoImpl implements UserDao{
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void saveUser() {
        System.out.println("保存了用户信息到数据库:"+name);
    }
}
