package com.itheima.dao;

import com.itheima.pojo.Account;

import java.util.List;

/**
 * 包名:com.itheima.dao
 * 作者:Leevi
 * 日期2020-02-17  09:34
 */
public interface AccountDao {
    void add(Account account);

    void deleteById(int id);

    void update(Account account);

    Account findById(int id);

    List<Account> findAll();

}
