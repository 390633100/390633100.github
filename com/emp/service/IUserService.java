package com.emp.service;

import com.emp.model.User;

/**
 * @author 故离
 * @data 2022/3/14  11:16
 */
public interface IUserService {
    User login(String sname, String spasswd);
}
