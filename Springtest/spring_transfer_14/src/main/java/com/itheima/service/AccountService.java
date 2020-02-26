package com.itheima.service;

import java.sql.SQLException;

/**
 * 包名:com.itheima.service
 * 作者:Leevi
 * 日期2020-02-16  09:07
 */
public interface AccountService {
    boolean transfer(int fromId, int toId, double money) throws SQLException;
}
