package com.emp.web;

import com.emp.model.Emp;
import com.emp.service.EmpService;
import com.emp.service.IEmpService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class EmpDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置字符集
        //接受客户端请求（数据）
        String did = request.getParameter("did");
        //处理数据  调至业务层
        IEmpService empService=new EmpService();
        empService.remove(new Emp(Integer.parseInt(did)));
        //设置数据

        //响应数据
        response.sendRedirect("/EmpManager/EmpListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
