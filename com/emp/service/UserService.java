package com.emp.service;

import com.emp.dao.UserDao;
import com.emp.dao.UserDaoImpl;
import com.emp.model.User;

import java.sql.SQLException;

/**
 * @author 故离
 * @data 2022/3/14  11:14
 */
public class UserService implements IUserService{
    UserDao dao=new UserDaoImpl();
    @Override
    public User login(String sname, String spasswd) {
        try {
            return dao.selectUserByNameAndPasswd(sname,spasswd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
