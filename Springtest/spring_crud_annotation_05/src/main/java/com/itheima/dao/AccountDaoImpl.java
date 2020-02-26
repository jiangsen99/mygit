package com.itheima.dao;

import com.itheima.pojo.Account;
import com.itheima.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.itheima.dao
 * 作者:Leevi
 * 日期2020-02-15  10:33
 * 真正执行从数据库中查询所有账号信息写在dao层
 */
@Repository
public class AccountDaoImpl implements AccountDao{
    @Autowired
    private QueryRunner queryRunner;

    @Override
    public List<Account> findAll() throws SQLException {
        //从数据库中查询所有账号信息
        String sql = "select * from account";
        List<Account> accountList = queryRunner.query(sql, new BeanListHandler<>(Account.class));
        return accountList;
    }
}
