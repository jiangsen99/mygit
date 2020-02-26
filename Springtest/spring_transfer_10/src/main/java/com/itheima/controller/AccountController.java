package com.itheima.controller;

import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;

/**
 * 包名:com.itheima.controller
 * 作者:Leevi
 * 日期2020-02-16  09:06
 */
@Controller
public class AccountController {
    //依赖注入
    @Autowired
    private AccountService accountService;
    /**
     *
     * @param fromId 转出账户的id
     * @param toId 转入账户的id
     * @param money 转账金额
     */
    public void transfer(int fromId,int toId,double money) throws SQLException {
        //调用业务层的方法进行转账
        boolean flag = accountService.transfer(fromId,toId,money);
        //判断是否转账成功
        if (flag) {
            System.out.println("转账成功...");
        }else {
            System.out.println("转账失败...");
        }
    }

}
