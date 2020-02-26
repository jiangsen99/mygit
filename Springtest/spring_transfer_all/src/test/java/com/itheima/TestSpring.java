package com.itheima;

import com.itheima.controller.AccountController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2020-02-17  14:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class TestSpring {
    @Autowired
    private AccountController accountController;

    @Test
    public void testTransfer(){
        accountController.transfer(1,2,520.0);
    }
}
