package com.itheima;


import com.itheima.utils.ConnectionUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionAspect {
    @Autowired
    private ConnectionUtil connectionUtil;
public boolean addTransaction(ProceedingJoinPoint joinPoint){
    connectionUtil.startTransaction();
    try {
        joinPoint.proceed();
        connectionUtil.commit();
        return true;
    } catch (Throwable throwable) {
        throwable.printStackTrace();
        connectionUtil.rollback();
        return false;
    }finally {
        connectionUtil.clear();
    }
}
}
