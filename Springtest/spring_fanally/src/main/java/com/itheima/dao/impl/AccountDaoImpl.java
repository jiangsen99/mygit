package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 包名:com.itheima.dao.impl
 * 程序猿:wushengdaozu
 * 日期: 2020--02--18    10:23:16
 */
@Repository
public class AccountDaoImpl implements AccountDao {
 @Autowired
private JdbcTemplate jdbcTemplate;
 @Override
 public void transfer(int id, double money) {
  String sql="update account set money=money+? where id=?";;
  jdbcTemplate.update(sql,money,id);
 }
}
