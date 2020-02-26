package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * 包名:com.itheima.dao.impl
 * 作者:Leevi
 * 日期2020-02-17  09:35
 * dao里面就是使用JdbcTemplate执行SQL语句，使用步骤:
 * 1. 创建一个JdbcTemplate对象,并且往它的构造函数中传入一个DataSource对象
 * 2. 使用jdbcTemplate对象执行SQL语句，如果是执行增删改的SQL语句则调用update方法
 *    如果是查询一条数据封装到Bean对象中，则调用queryForObject方法
 *    如果是查询多条数据封装到Bean对象中，则调用query方法
 *
 *
 * 改造Dao层，让AccountDaoImpl类，继承JdbcDaoSupport类
 * JdbcDaoSupport类中，有一个JdbcTemplate对象，但是需要我们往父类注入一个DataSource对象
 *
 * 目标:要在AccountDaoImpl类中调用setDataSource方法
 */
/*@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void add(Account account) {
        String sql = "insert into account values (null,?,?)";
        jdbcTemplate.update(sql,account.getName(),account.getMoney());
    }

    @Override
    public void deleteById(int id) {
        String sql = "delete from account where id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void update(Account account) {
        String sql = "update account set name=?,money=? where id=?";
        jdbcTemplate.update(sql,account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public Account findById(int id) {
        String sql = "select * from account where id=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Account.class),id);
    }

    @Override
    public List<Account> findAll() {
        String sql = "select * from account";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Account.class));
    }
}*/
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void add(Account account) {
        String sql = "insert into account values (null,?,?)";
        getJdbcTemplate().update(sql,account.getName(),account.getMoney());
    }

    @Override
    public void deleteById(int id) {
        String sql = "delete from account where id=?";
        getJdbcTemplate().update(sql,id);
    }

    @Override
    public void update(Account account) {
        String sql = "update account set name=?,money=? where id=?";
        getJdbcTemplate().update(sql,account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public Account findById(int id) {
        String sql = "select * from account where id=?";
        return getJdbcTemplate().queryForObject(sql,new BeanPropertyRowMapper<>(Account.class),id);
    }

    @Override
    public List<Account> findAll() {
        String sql = "select * from account";
        return getJdbcTemplate().query(sql,new BeanPropertyRowMapper<>(Account.class));
    }
}
