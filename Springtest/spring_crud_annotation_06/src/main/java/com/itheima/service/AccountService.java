package com.itheima.service;

import com.itheima.pojo.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.itheima.service
 * 作者:Leevi
 * 日期2020-02-15  10:33
 */
public interface AccountService {
    List<Account> findAll() throws SQLException;

}
