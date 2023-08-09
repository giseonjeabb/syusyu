package com.teamProject.syusyu.common.interceptor;

import com.teamProject.syusyu.service.base.product.CategoryServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Component
public class CategoryInterceptor implements HandlerInterceptor {
    @Autowired
    private CategoryServiceBase categoryService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        // Check if categories data is already in session
        if (session.getAttribute("categories") == null) {
            Map<String, Object> categories = categoryService.getCategoryAllList();
            session.setAttribute("categories", categories);
        }
        return true;
    }
}
