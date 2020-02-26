package com.itheima.controller;

import com.itheima.pojo.Account;
import com.itheima.service.AccountService;

import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.itheima.controller
 * 作者:Leevi
 * 日期2020-02-15  10:32
 */
public class AccountController {
    private AccountService accountService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public List<Account> findAll() throws SQLException {
        //调用service的方法查询所有的账户信息
        return accountService.findAll();
    }
}
