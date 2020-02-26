package com.itheima.dao.daoImpl;

import com.itheima.dao.AccountDao;
import com.itheima.utils.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 包名:com.itheima.dao.daoImpl
 * 程序猿:wushengdaozu
 * 日期: 2020--02--16    13:41:18
 */
@Repository
public class AccountDaoImpl implements AccountDao {
 @Autowired
 private QueryRunner queryRunner;
 @Autowired
 private ConnectionUtil connectionUtil;
 @Override
 public void updata(int id, double money) throws SQLException {
  String sql = "update account set money=money+? where id=?";
  Connection connection = connectionUtil.getConnection();
  queryRunner.update(connection,sql,money,id);
 }
}