package com.itheima.dao;

import java.sql.SQLException;

public interface AccountDao {
 void updata(int fromid, double money) throws SQLException;
}
