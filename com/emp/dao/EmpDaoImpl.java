package com.emp.dao;

import com.emp.model.Emp;
import com.emp.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
员工数据访问实现类
 */
public class EmpDaoImpl implements EmpDao {
    @Override
    public int insert(Emp emp) throws SQLException {
        Connection conn=null;
        PreparedStatement pstmt=null;
        String sql="insert into emp values(null,?,?,?,?)";
        try {
            conn= JdbcUtil.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setObject(1,emp.getSname());
            pstmt.setObject(2,emp.getSsex());
            pstmt.setObject(3,emp.getAge());
            pstmt.setObject(4,emp.getSalary());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn,pstmt,null);
        }
        return 0;
    }

    @Override
    public int delete(Emp emp) throws SQLException {

        Connection conn=null;
        PreparedStatement pstmt=null;
        String sql="delete from emp where id=?";
        try {
            conn= JdbcUtil.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setObject(1,emp.getId());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn,pstmt,null);
        }
        return 0;
    }

    @Override
    public int updata(Emp emp) throws SQLException {
        Connection conn=null;
        PreparedStatement pstmt=null;
        String sql="update emp set sname=?,ssex=?,age=?,salary=? where id=?";
        try {
            conn= JdbcUtil.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setObject(1,emp.getSname());
            pstmt.setObject(2,emp.getSsex());
            pstmt.setObject(3,emp.getAge());
            pstmt.setObject(4,emp.getSalary());
            pstmt.setObject(5,emp.getId());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn,pstmt,null);
        }
        return 0;
    }

    @Override
    public List<Emp> selectAll() throws SQLException {
        {
            List<Emp> list=new ArrayList<>();
            Connection conn=null;
            PreparedStatement pstmt=null;
            ResultSet rs=null;
            String sql="select * from emp";
            try {
                conn= JdbcUtil.getConnection();
                pstmt=conn.prepareStatement(sql);
                rs=pstmt.executeQuery();
                while(rs.next()){
                    Emp emp = new Emp(rs.getInt("id"),
                            rs.getString("sname"),
                            rs.getString("ssex"),
                            rs.getInt("age"),
                            rs.getFloat("salary"));
                    list.add(emp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                JdbcUtil.close(conn,pstmt,rs);
            }
            return list;
        }
    }

    @Override
    public Emp select(Integer id) throws SQLException {
                Connection conn=null;
                PreparedStatement pstmt=null;
                ResultSet rs=null;
                String sql="select * from emp where id=?";
                try {
                    conn= JdbcUtil.getConnection();
                    pstmt=conn.prepareStatement(sql);
                    pstmt.setObject(1,id);
                    rs=pstmt.executeQuery();
                    while(rs.next()){
                        return  new Emp(rs.getInt("id"),
                                rs.getString("sname"),
                                rs.getString("ssex"),
                                rs.getInt("age"),
                                rs.getFloat("salary"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    JdbcUtil.close(conn,pstmt,rs);

                }
                return null;
    }
}
