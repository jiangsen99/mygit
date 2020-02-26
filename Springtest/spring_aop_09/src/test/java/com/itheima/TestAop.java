package com.itheima;

import com.itheima.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2020-02-16  10:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class TestAop {
    @Autowired
    private UserService userService;

    @Test
    public void test01() throws InterruptedException {
        //直接调用add()方法，那么使用aop增强add方法，并且在add之前加入权限校验
        //userService.add();

        //执行完delete方法，就会调用打印日志的通知
        //userService.delete();

        //执行findAll()
        userService.findAll();
    }
}
