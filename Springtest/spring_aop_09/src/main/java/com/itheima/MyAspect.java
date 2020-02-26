package com.itheima;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2020-02-16  11:36
 * MyAspect类就是一个切面
 *
 * security()方法就是一个通知
 */
public class MyAspect {

    public void security(){
        System.out.println("执行权限校验....");
    }

    public void printLog(){
        System.out.println("执行成功...");
    }

    public void rollback(){
        System.out.println("出现异常,回滚事务...");
    }

    public void sayHello(){
        System.out.println("hello,执行了最终通知...");
    }

    public void showTime(ProceedingJoinPoint joinPoint){
        //执行核心方法(查询所有)之前，打印当前时间
        long timeMillis1 = System.currentTimeMillis();
        System.out.println("执行查询所有之前的时间:" + timeMillis1);

        //执行核心方法(查询所有),也就是执行切入点方法
        try {
            //这就是执行切入点
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        //执行核心方法之后，打印当前时间
        long timeMillis2 = System.currentTimeMillis();
        System.out.println("执行查询所有之后的时间:" + timeMillis2);
        System.out.println("查询所有所花费的时间是:" + (timeMillis2 - timeMillis1));
    }
}
