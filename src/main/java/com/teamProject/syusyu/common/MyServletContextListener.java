package com.teamProject.syusyu.common;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();

        sc.setAttribute("cssUrlFos", "/static/fos/css");
        sc.setAttribute("jsUrlFos", "/static/fos/js");
        sc.setAttribute("imgUrl", "/static/image");
    }
}
