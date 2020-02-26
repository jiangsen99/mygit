package com.itheima;


import com.itheima.controller.MyController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2020-02-16  09:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class TestTransfer {
    @Autowired
    private MyController myController;
    @Test
    public void transfer() throws SQLException {
        //直接调用AccountController的转账方法
        myController.transfer(1,2,520.0);

    }
}
