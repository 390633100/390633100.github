package com.emp.web;

import com.emp.model.Emp;
import com.emp.service.EmpService;
import com.emp.service.IEmpService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class EmpUpdataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置字符集
        //接受客户端请求（数据）
        String uid = request.getParameter("uid");
        //处理数据  调至业务层
        IEmpService empService=new EmpService();
        Emp emp = empService.findById(Integer.parseInt(uid));
        //设置数据
           request.setAttribute("emp",emp);
        //响应数据
        request.getRequestDispatcher("updata.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
