package com.itheima;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * 包名:com.itheima
 * 作者:Leevi
 * 日期2020-02-15  14:58
 * 用来配置一些数据库相关的东西
 * 我们通过PropertySource注解引入外部的properties文件
 */
@PropertySource("druid.properties")
public class JdbcConfig {
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Bean
    public QueryRunner createQueryRunner(DataSource dataSource){
        //这个方法的参数，就相当于注入
        //我们要往QueryRunner的构造函数中传入一个DataSource对象
        return new QueryRunner(dataSource);
    }

    @Bean
    public DataSource createDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        //给dataSource设置数据url、username、password、driver等等数据
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }
}
