package com.emp.web;

import com.emp.model.Emp;
import com.emp.service.EmpService;
import com.emp.service.IEmpService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class EmpUpdataSubmitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置字符集
        //接受客户端请求（数据）
        String id = request.getParameter("id");
        String sname = request.getParameter("sname");
        String ssex = request.getParameter("ssex");
        String age = request.getParameter("age");
        String salary = request.getParameter("salary");
        //处理数据  调至业务层
        IEmpService empService=new EmpService();
        empService.meger(new Emp(Integer.parseInt(id),sname,ssex,Integer.parseInt(age),Float.parseFloat(salary)));
        //设置数据
        //响应数据
        response.sendRedirect("/EmpManager/EmpListServlet");
    }
}
