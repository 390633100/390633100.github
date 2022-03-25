package com.emp.utils;

import java.sql.*;
public class JdbcUtil {
    static final String url="jdbc:mysql://localhost:3306/d1";
    static final String sname="root";
    static final String spasswd="333";
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
         return DriverManager.getConnection(url,sname,spasswd);
    }
    public static void close(Connection conn, Statement stamt, ResultSet rs) throws SQLException {
        try {
            if (rs!= null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (stamt!= null) {
                try {
                    stamt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                finally {
                    if (conn!= null) {
                        conn.close();
                    }
                }
            }
        }

    }
}
