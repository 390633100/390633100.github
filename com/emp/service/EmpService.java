package com.emp.service;

import com.emp.dao.EmpDao;
import com.emp.dao.EmpDaoImpl;
import com.emp.model.Emp;

import java.sql.SQLException;
import java.util.List;

public class EmpService implements IEmpService {
    EmpDao dao=new EmpDaoImpl();
    @Override
    public int add(Emp emp) {
        try {
            return dao.insert(emp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int remove(Emp emp) {
        try {
            return dao.delete(emp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int meger(Emp emp) {
        try {
            return dao.updata(emp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Emp> getAll() {
        try {
            return dao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Emp findById(Integer id) {
        try {
            return dao.select(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
