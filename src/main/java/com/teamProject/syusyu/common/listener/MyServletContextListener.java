package com.teamProject.syusyu.common.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        // 공통
        sc.setAttribute("jsUrlCommon", "/static/common/js");

        // FOS
        sc.setAttribute("cssUrlFos", "/static/fos/css");
        sc.setAttribute("jsUrlFos", "/static/fos/js");
        sc.setAttribute("imgUrl", "/static/image");

        // BOS
        sc.setAttribute("cssUrlBos","/static/bos/css");
        sc.setAttribute("jsUrlBos", "/static/bos/js");

        // tiles
        sc.setAttribute("title", "syusyu");
        sc.setAttribute("commonLayoutFos", "/WEB-INF/views/fos/common");
        sc.setAttribute("commonLayoutBos", "/WEB-INF/views/bos/dashboard");

        sc.setAttribute("productLayoutBos", "/WEB-INF/views/bos/product");

    }
}
