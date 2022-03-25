package com.emp.web; /**
 * @author 故离
 * @data 2022/3/16  17:18
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                  request.getSession().removeAttribute("loginUser");
                  response.sendRedirect("/EmpManager/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
