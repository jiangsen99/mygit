package com.itheima;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2020-02-15  14:38
 * 我们得给这个类添加一个Configuration注解，标示它是一个配置类,那么我们创建核心容器的时候就可以
 * 来加载这个配置类
 *
 * 让配置类能够完成如下的事情:
 *  1. 包扫描,通过ComponentScan注解指定要扫描的包名
 *  2. 创建QueryRunner对象以及DataSource对象 （转移到JdbcConfig类中）
 *     配置类是通过方法创建对象的,方法的返回值就是创建的对象，方法的参数就是要注入的数据；
 *     并且一定要给方法添加Bean注解
 *
 *
 *  使用Import注解导入其它的类
 */
@Configuration
@ComponentScan("com.itheima")
@Import(JdbcConfig.class)
public class SpringConfiguration {

}
