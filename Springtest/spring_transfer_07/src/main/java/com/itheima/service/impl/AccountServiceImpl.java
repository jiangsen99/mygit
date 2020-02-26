package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import com.itheima.utils.ConnectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 包名:com.itheima.service.impl
 * 作者:Leevi
 * 日期2020-02-16  09:07
 * 目标:给转账案例，添加事务
 * 添加事务的步骤:
 *    1. 在业务逻辑开始之前，开启事务,connection.setAutoCommit(false);
 *    2. 在业务逻辑执行完毕之后，没有出现异常则提交事务 connection.commit();
 *    3. 在业务逻辑执行过程中出现了异常，则回滚事务 connection.rollback();
 *
 * 我们要确保的一点:操作事务的connection，要和真正执行SQL语句的connection是同一个连接对象
 *
 * 那么我们怎么保证开启事务的connection和执行SQL语句的connection是同一个connection呢?
 * 那么我们就使用ThreadLocal对象在同一个线程中共享数据
 *
 *
 * 思考一个问题:能不能在spring核心容器中配置一个连接对象，在业务层和持久层都注入这个连接对象?
 * 整个项目就只能有一个连接了!!!  所有sql语句都只有一个连接对象，这是绝对不行的
 *
 * 再思考一个问题: 如果项目中有多个功能都要使用事务控制，那么我们业务层的多个方法中，是不是会出现重复代码?
 *
 * 接下来我们要达成的目标是: 让业务层只关注自己具体的业务逻辑，事务相关的代码，全部交给"代理者去完成"
 *                      将重复性的代码，抽取出来，在要使用的地方插入就可以了---->AOP思想
 *
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private ConnectionUtil connectionUtil;//注入实例工厂对象

    @Override
    public boolean transfer(int fromId, int toId, double money){
        try {
            //执行转账之前，先开启事务
            connectionUtil.startTransaction();//开启事务

            //进行转账
            //1. 付款方扣款
            accountDao.updateAccount(fromId,-money);

            //int num = 10/0; //会出现除零异常，导致转账失败

            //2. 收款方收款
            accountDao.updateAccount(toId,money);
            //如果转账过程中，没有出现异常，则转账成功

            //如果没有出现异常，则提交事务
            connectionUtil.commit();//提交事务
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            //如果转账过程中出现了异常，则转账失败,回滚事务
            connectionUtil.rollback();//回滚事务
            return false;
        }finally {
            //清理资源
            connectionUtil.clear();
        }
    }
}
