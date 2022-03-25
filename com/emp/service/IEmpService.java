package com.emp.service;

import com.emp.model.Emp;

import java.util.List;

/*
员工业务接口
 */
public interface IEmpService {
    /*
    添加
     */
  public int add(Emp emp);
 /*
 删除
  */
    public int remove(Emp emp);
    /*
    修改
     */
    public int meger(Emp emp);
    /*
    查询所有
     */
    public List<Emp> getAll();
    /*
    查询单个
     */
    public Emp findById(Integer id);
}
