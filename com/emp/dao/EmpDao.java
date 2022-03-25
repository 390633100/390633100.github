package com.emp.dao;

import com.emp.model.Emp;

import java.sql.SQLException;
import java.util.List;

/*
员工访问接口
 */
public interface EmpDao {
//    添加
    public int insert(Emp emp) throws SQLException;
//    删除
    public int delete(Emp emp) throws SQLException;
//    修改
    public int  updata(Emp emp) throws SQLException;
//    查询所有
    public List<Emp> selectAll() throws SQLException;
//    查询单个
    public Emp select(Integer id) throws SQLException;
}
