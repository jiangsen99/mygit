package com.itheima.service.impl;

import com.itheima.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 包名:com.itheima.service.impl
 * 作者:Leevi
 * 日期2020-02-16  10:48
 * //目标1:在添加方法之前，添加权限校验的代码
 *
 * //目标2:在执行删除方法之后，打印日志,输出一句话"执行成功"
 *   切入点:delete()方法
 *   通知:后置通知，一个打印日志的方法
 *
 * //目标3:执行UserServiceImpl类中的所有方法，出现异常的时候，我们回滚事务
 *   切入点:UserServiceImpl类的所有方法
 *   通知:异常通知(就是在切入点方法出现异常的时候执行通知)，一个回滚的方法
 *
 * //目标4:执行UserServiceImpl类中的delete方法，无论抛出或者不抛出异常都执行该通知，并且是在delete之后执行
 *   最终通知
 *
 *   AOP中的通知的分类:
 *      1. 前置通知:执行切入点之前执行
 *      2. 后置通知:执行切入点之后，没有异常则执行
 *      3. 异常通知:执行切入点，出现异常则执行
 *      4. 最终通知:执行切入点之后，无论是否出现异常都执行
 *
 *  目标5:在查询所有用户信息之前，打印时间，在执行查询所有之后，打印时间，计算出执行查询所有花了多少毫秒
 *       环绕通知
 */
@Service
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("添加用户。。。");
        int num = 10/0;
    }

    @Override
    public void delete() {
        System.out.println("删除用户。。。");
        //int num = 10/0;
    }

    @Override
    public void update() {
        System.out.println("修改用户。。。");
    }

    @Override
    public void findAll() throws InterruptedException {
        System.out.println("查询所有用户信息...");
        Thread.sleep(1008);
    }
}
