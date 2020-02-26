package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;

/**
 * 包名:com.itheima.dao.impl
 * 作者:Leevi
 * 日期2020-02-16  09:06
 *
 * dao层，使用JdbcTemplate
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void updateAccount(int id, double money) throws SQLException {
        String sql = "update account set money=money+? where id=?";
        jdbcTemplate.update(sql,money,id);
    }
}
