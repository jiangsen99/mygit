package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * 包名:com.itheima.service.impl
 * 作者:Leevi
 * 日期2020-02-16  09:07
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;


    @Override
    @Transactional(rollbackFor = Exception.class,
                   noRollbackFor = NullPointerException.class,
                   isolation = Isolation.REPEATABLE_READ)
    public boolean transfer(int fromId, int toId, double money) throws SQLException {
        //进行转账
        //1. 付款方扣款
        accountDao.updateAccount(fromId,-money);
        int num = 10/0; //会出现除零异常，导致转账失败
        //2. 收款方收款
        accountDao.updateAccount(toId,money);
        return true;
    }
}
