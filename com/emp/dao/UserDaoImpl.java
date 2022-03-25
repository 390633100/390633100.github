package com.emp.dao;

import com.emp.model.Emp;
import com.emp.model.User;
import com.emp.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 故离
 * @data 2022/3/14  11:33
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User selectUserByNameAndPasswd(String sname, String spasswd) throws SQLException {
            Connection conn=null;
            PreparedStatement pstmt=null;
            ResultSet rs=null;
            String sql="select * from user where sname=? and spasswd=?";
            try {
                conn= JdbcUtil.getConnection();
                pstmt=conn.prepareStatement(sql);
                pstmt.setObject(1,sname);
                pstmt.setObject(2,spasswd);
                rs=pstmt.executeQuery();
                while(rs.next()){
                    return  new User(rs.getInt("id"),
                             rs.getString("sname"),
                    rs.getString("spasswd"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                JdbcUtil.close(conn,pstmt,rs);

            }
            return null;
        }
}
