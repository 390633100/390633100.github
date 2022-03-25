package com.emp.dao;

import com.emp.model.User;

import java.sql.SQLException;

/**
 * @author 故离
 * @data 2022/3/14  11:33
 */
public interface UserDao {
    User selectUserByNameAndPasswd(String sname, String spasswd) throws SQLException;
}
