package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 包名:com.itheima.service.impl
 * 作者:Leevi
 * 日期2020-02-17  14:08
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional
    public void transfer(int fromId, int toId, double money) {
        //1. 转出账户扣款
        accountDao.updateAccount(fromId,-money);


        //2. 转入账户收款
        accountDao.updateAccount(toId,money);
    }
}
