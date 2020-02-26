package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.dao.UserDaoImpl;

/**
 * 包名:com.itheima.service
 * 作者:Leevi
 * 日期2020-02-15  09:10
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        //调用UserDao的方法，保存用户信息
        userDao.saveUser();
    }
}
