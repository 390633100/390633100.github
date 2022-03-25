package com.emp.web; /**
 * @author 故离
 * @data 2022/3/14  10:53
 */

import com.emp.model.User;
import com.emp.service.IUserService;
import com.emp.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sname = request.getParameter("sname");
        String spasswd = request.getParameter("spasswd");
        String autoLogin = request.getParameter("autoLogin");
        IUserService userService=new UserService();
        User user=userService.login(sname,spasswd);
        if (user == null) {
            request.setAttribute("errMsg","账户名与密码不匹配，请重新输入");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

        request.getSession().setAttribute("loginUser",user);
//设置自动登录cookie
        if("ok".equals(autoLogin)){
            Cookie cookie = new Cookie("autoLogin",user+"—"+spasswd);
            cookie.setMaxAge(60*60*24*7);
        }
        response.sendRedirect("/EmpManager/EmpListServlet");
    }
}
