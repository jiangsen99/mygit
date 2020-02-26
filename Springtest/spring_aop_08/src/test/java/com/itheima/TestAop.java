package com.itheima;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
    public void test1(){
        //使用JDK的动态代理技术，添加权限校验代码
        Class<? extends UserService> clazz = userService.getClass();
        ClassLoader classLoader = clazz.getClassLoader();
        UserService proxyInstance = (UserService) Proxy.newProxyInstance(classLoader, new Class[]{UserService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //对方法进行代理
                //在执行方法之前，添加权限校验的代码
                System.out.println("添加权限校验。。。");
                //执行具体的业务逻辑方法
                Object obj = method.invoke(userService, args);

                System.out.println("清理资源....");
                return obj;
            }
        });

        //上面就使用了jdk的动态代理，创建了一个UserService的代理对象
        //我们调用代理对象的方法
        proxyInstance.add();
    }

    @Test
    public void test2(){
        //1. 创建一个Enhancer对象
        Enhancer enhancer = new Enhancer();
        //2. 设置要代理的类
        enhancer.setSuperclass(UserServiceImpl.class);
        //3. 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //method就是要代理的方法
                System.out.println("添加权限校验。。。");
                //执行具体的业务方法
                Object obj = method.invoke(userService, objects);
                System.out.println("清理资源...");
                return obj;
            }
        });
        //4. 创建代理对象
        UserService proxyInstance = (UserService) enhancer.create();

        proxyInstance.add();
    }
}
