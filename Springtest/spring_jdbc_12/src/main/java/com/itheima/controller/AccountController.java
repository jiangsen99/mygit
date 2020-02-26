package com.itheima.controller;

import com.itheima.pojo.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 包名:com.itheima.controller
 * 作者:Leevi
 * 日期2020-02-17  09:34
 */
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    public void add(Account account){
        accountService.add(account);
    }

    public void deleteById(int id){
        accountService.deleteById(id);
    }

    public void update(Account account){
        accountService.update(account);
    }

    public Account findById(int id){
        return accountService.findById(id);
    }

    public List<Account> findAll(){
        return accountService.findAll();
    }
}
