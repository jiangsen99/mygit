package com.itheima.service;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.itheima.service
 * 作者:Leevi
 * 日期2020-02-15  10:33
 * accountServiceImplAnother
 */
@Service("accountService2")
public class AccountServiceImplAnother implements AccountService{
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() throws SQLException {
        System.out.println("调用AccountServiceImplAnother的方法");
        return accountDao.findAll();
    }
}
