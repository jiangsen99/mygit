package com.itheima.dao;

import com.itheima.pojo.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.itheima.dao
 * 作者:Leevi
 * 日期2020-02-15  10:33
 */
public interface AccountDao {
    List<Account> findAll() throws SQLException;
}
