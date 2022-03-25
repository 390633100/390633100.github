package com.emp.web;

import com.emp.model.Emp;
import com.emp.model.User;
import com.emp.service.EmpService;
import com.emp.service.IEmpService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class EmpListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User loginUser =(User) request.getSession().getAttribute("loginUser");
//        if (loginUser == null) {
//            response.sendRedirect("/EmpManager/login.jsp");
//            return;
//        }
        //验证用户是否登录
        request.getSession().getAttribute("loginUser");
        //接受客户端请求（数据）
        //处理数据  调至业务层
        IEmpService empService=new EmpService();
        List<Emp> all = empService.getAll();
        //设置数据
        request.setAttribute("empList",all);
        //响应数据
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
