package com.itheima.service.serviceImpl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import com.itheima.utils.ConnectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * 包名:com.itheima.service
 * 程序猿:wushengdaozu
 * 日期: 2020--02--16    13:43:11
 */
@Service
public class AccountServiceImpl implements AccountService {
 @Autowired
 private AccountDao accountDao;
 @Autowired
 private ConnectionUtil connectionUtil;

 @Override
 public boolean transfer(int fromid, int intid, double money) throws SQLException {



   accountDao.updata(fromid, -money);
   int i=10/0;
   accountDao.updata(intid, money);
   return true;



 }



}
