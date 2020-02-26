package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 包名:com.itheima.utils
 * 作者:Leevi
 * 日期2020-02-16  09:42
 */
public class ConnectionUtil {
    @Autowired
    private ThreadLocal<Connection> tLocal;
    @Autowired
    private DataSource dataSource;

    /**
     * 从ThreadLocal中获取connection对象
     * @return
     */
    public Connection getConnection(){
        try {
            //如果ThreadLocal对象中，有connection，则直接获取ThreadLocal中的connection
            Connection conn = tLocal.get();

            if (conn == null) {
                //说明ThreadLocal中没有连接对象，则从连接池对象中获取连接
                conn = dataSource.getConnection();
                //并且要将这个连接对象存放到ThreadLocal中去
                tLocal.set(conn);
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    //只要调用这个工具类的startTransaction()方法，就能够开启事务
    public void startTransaction(){
        try {
            getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    //只要调用工具类的commit()方法，就能提交事务
    public void commit(){
        try {
            getConnection().commit();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    //只要调用工具类的rollback()方法，就能回滚事务
    public void rollback(){
        try {
            getConnection().rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void clear(){
        try {
            getConnection().close();//将连接归还到连接池
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        //当业务逻辑执行完毕之后，清除ThreadLocal中的连接，将连接归还到连接池
        tLocal.remove();//清除ThreadLocal中的连接
    }
}
