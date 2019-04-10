package com.blackfish.springSource.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/9 16:10
 * @Description:
 */
public class MyDataContextListener implements ServletContextListener {

    private ServletContext servletContext = null;

    public MyDataContextListener() {

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("myData","this is my Data");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        this.servletContext = null;
    }
}
