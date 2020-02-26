package com.itheima.controller;

import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 包名:com.itheima.controller
 * 作者:Leevi
 * 日期2020-02-17  14:08
 */
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    public void transfer(int fromId,int toId,double money){
        try {
            accountService.transfer(fromId,toId,money);
            //没有出现异常，则转账成功
            System.out.println("转账成功...");
        } catch (Exception e) {
            e.printStackTrace();
            //出现异常，则转账失败
            System.out.println("转账失败...");
        }
    }
}
