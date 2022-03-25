package com.emp.web; /**
 * @author 故离
 * @data 2022/3/14  15:00
 */

import com.emp.model.User;
import com.emp.service.IUserService;
import com.emp.service.UserService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) resp;
        String requestURI = request.getRequestURI();
        if("/EmpManager/login.jsp".equals(requestURI)){
            chain.doFilter(req, resp);
            return;
        }
        if("/EmpManager/LoginServlet".equals(requestURI)){
            chain.doFilter(req, resp);
            return;
        }

        User loginUser =(User) request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            Cookie[] cookies = request.getCookies();
            if(cookies.length>0&&cookies!=null){
                for(Cookie cookie:cookies){
                    if("autoLogin".equals(cookie.getName())){
                        String value = cookie.getValue();
                        String[] split = value.split("-");
                        IUserService userService=new UserService();
                        User user = userService.login(split[0], split[1]);
                        System.out.println(split[0]);
                        System.out.println(split[1]);
                        if (user!= null) {
                            request.getSession().setAttribute("loginUser",user);
                            response.sendRedirect("/EmpManager/EmpListServlet");
                            return;
                        }
                    }
                }
            }
            response.sendRedirect("/EmpManager/login.jsp");
            return;
        }
        chain.doFilter(req, resp);
    }
}
