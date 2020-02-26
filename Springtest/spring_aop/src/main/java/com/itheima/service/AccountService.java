package com.itheima.service;

import java.sql.SQLException;

public interface AccountService {

 boolean transfer(int fromid, int intid, double money) throws SQLException;
}
