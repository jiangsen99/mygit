package com.itheima.dao;

import java.sql.SQLException;

/**
 * 包名:com.itheima.dao
 * 作者:Leevi
 * 日期2020-02-16  09:06
 */
public interface AccountDao {
    void updateAccount(int id, double money) throws SQLException;
}
