package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.utils.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 包名:com.itheima.dao.impl
 * 作者:Leevi
 * 日期2020-02-16  09:06
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner queryRunner;

    @Autowired
    private ConnectionUtil connectionUtil;//注入实例工厂对象

    @Override
    public void updateAccount(int id, double money) throws SQLException {
        String sql = "update account set money=money+? where id=?";
        Connection conn = connectionUtil.getConnection();//这个连接对象就和业务层开启事务的连接对象是同一个
        queryRunner.update(conn,sql,money,id);
    }
}
