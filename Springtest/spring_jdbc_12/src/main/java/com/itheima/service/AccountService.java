package com.itheima.service;

import com.itheima.pojo.Account;

import java.util.List;

/**
 * 包名:com.itheima.service
 * 作者:Leevi
 * 日期2020-02-17  09:34
 */
public interface AccountService {
    void add(Account account);

    void deleteById(int id);

    void update(Account account);

    Account findById(int id);

    List<Account> findAll();

}
