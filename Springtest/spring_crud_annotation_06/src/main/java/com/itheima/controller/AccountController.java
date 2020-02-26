package com.itheima.controller;

import com.itheima.pojo.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.itheima.controller
 * 作者:Leevi
 * 日期2020-02-15  10:32
 * 使用注解方式进行依赖注入，不需要set方法或者有参构造函数
 *
 * 其实注解方式进行IOC有如下一些注解:
 * 1. Controller 注解 建议使用在表现层
 * 2. Service 注解 建议使用在业务层
 * 3. Repository 注解 建议使用在持久层
 * 4. Component 注解 建议使用在其他地方
 *
 * 关于注解IOC的总结:只要创建对象的类是你自己写的类，那么就在该类上添加上述四个注解中的一个，
 * 就可以让spring核心容器管理这个对象；但是如果要创建对象的类不是我们自己写的类，那么现在就只能使用配置文件的方式进行IOC
 *
 * 我们通过ioc将对象存放到核心容器的时候，要指定这个对象的id，如果没有指定id那么默认的id就是"类名将首字母该小写"；
 * 当然我们也可以通过ioc注解设置值的方式来手动指定id
 *
 * 使用注解方式进行依赖注入
 * 1. Autowired注解进行依赖注入:它会进行自动装配
 *      1.1 如果spring核心容器中只有一个该类型的对象，那么就把那个对象进行注入(只需要掌握这个，因为实际项目中不可能存在dao或者service接口有俩实现类)
 *      1.2 如果spring核心容器中有多个该类型的对象，那么首先根据属性名匹配id,匹配上哪个对象的id那么就注入哪个对象
 *      1.3 如果spring核心容器中有多个该类型的对象，那么首先根据属性名匹配id,如果属性名和任何一个id都不匹配，那么就得通过Qualifier手动自己指定
 *          要注入哪个对象
 *
 * 使用注解方式进行依赖注入的总结:
 *      要注入哪个属性，就在那个属性上添加@Autowired注解就可以了，但是这个注解只能注入"对象类型"
 *      如果要注入简单类型的数据，那么就得使用@Value注解(通常是结合配置文件一起使用)
 *
 *      Resource注解，我们可以不用，它的作用和Autowired注解的作用是一样的
 */
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Value("张三丰")
    private String username;

    public List<Account> findAll() throws SQLException {
        System.out.println("username的值:" + username);
        //调用service的方法查询所有的账户信息
        return accountService.findAll();
    }
}
