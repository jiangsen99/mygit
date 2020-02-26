package com.itheima;

import com.itheima.utils.ConnectionUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2020-02-16  14:36
 * 切面
 *
 * AOP的作用:
 *  将重复代码抽取出来，然后使用动态代理技术在运行的时候进行增强
 */
public class TransactionAspect {
    @Autowired
    private ConnectionUtil connectionUtil;

    public boolean addTransaction(ProceedingJoinPoint joinPoint){
        //执行具体的转账业务之前，先开启事务
        connectionUtil.startTransaction();

        //执行具体的转账业务
        try {
            joinPoint.proceed();
            //没有出现异常，则提交事务
            connectionUtil.commit();
            return true;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //如果出现异常，则回滚事务
            connectionUtil.rollback();
            return false;
        }finally {
            //清理资源
            connectionUtil.clear();
        }
    }
}
