package com.emp.web;

import javax.servlet.*;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author 故离
 * @data 2022/3/15  17:05
 */
public class  OnLIneListener implements HttpSessionListener, ServletRequestListener {
    private Long clilkCount=0l;
    private Long onlineUser=0l;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().getServletContext().setAttribute("onlineUser",++onlineUser);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSessionListener.super.sessionDestroyed(se);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletRequestListener.super.requestDestroyed(sre);
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        sre.getServletContext().setAttribute("clilkCount",++clilkCount);
    }
}
