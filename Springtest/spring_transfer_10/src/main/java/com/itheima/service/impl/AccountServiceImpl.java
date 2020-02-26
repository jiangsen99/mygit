package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

/**
 * 包名:com.itheima.service.impl
 * 作者:Leevi
 * 日期2020-02-16  09:07
 * 目标:业务层，只关注具体的业务逻辑；而不关注事务相关的代码
 * 实现的技术:使用AOP技术，将事务相关的操作制作成通知，插入到业务层的方法中
 *
 * 此处使用什么通知??? 使用环绕通知
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public boolean transfer(int fromId, int toId, double money) throws SQLException {
        //进行转账
        //1. 付款方扣款
        accountDao.updateAccount(fromId,-money);
        //int num = 10/0; //会出现除零异常，导致转账失败
        //2. 收款方收款
        accountDao.updateAccount(toId,money);
        return true;
    }
}
