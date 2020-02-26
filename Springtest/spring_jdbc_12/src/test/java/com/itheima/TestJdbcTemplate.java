package com.itheima;

import com.itheima.controller.AccountController;
import com.itheima.pojo.Account;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2020-02-17  09:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class TestJdbcTemplate {
    @Autowired
    private AccountController accountController;

    @Test
    public void testAdd(){
        Account account = new Account(null, "aobama", 1000.0);
        accountController.add(account);
    }

    @Test
    public void testDeleteById(){
        accountController.deleteById(4);
    }

    @Test
    public void testUpdate(){
        //1. 根据id查询账号
        Account account = accountController.findById(3);
        //2.修改账号
        account.setName("jay");
        account.setMoney(1500.0);
        //3. 调用update方法
        accountController.update(account);
    }
    @Test
    public void testFindAll(){
        System.out.println(accountController.findAll());
    }
}
