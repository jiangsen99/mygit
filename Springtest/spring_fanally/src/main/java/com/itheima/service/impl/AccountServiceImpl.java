package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 包名:com.itheima.service.impl
 * 程序猿:wushengdaozu
 * 日期: 2020--02--18    10:21:24
 */
@Service
public class AccountServiceImpl implements AccountService {
 @Autowired
 private AccountDao accountDao;
 @Override
 @Transactional
 public void transfer(int fromid, int toid, double money) {
  accountDao.transfer(fromid,-money);
  int n=1/0;
  accountDao.transfer(toid,money);
 }
}
