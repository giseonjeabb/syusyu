//package com.teamProject.syusyu.common.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//@WebFilter(urlPatterns = "/*")
//public class LoginCheckFilter implements Filter {
////    List<String> urlList;
//    @Override
//    public void init(FilterConfig filterConfig) {
//        //TODO 얘 왜 동작 안 하지
////        urlList = Arrays.asList("/fos/login", "/static");
////        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        // 로그인이 필요하지 않은 URL 목록을 정의한다.
//
//        List<String> urlList = Arrays.asList("/fos/login", "/static", "/register/register","/prodList");
//
//        String requestUrl = request.getRequestURI();
//
//        // 1. 로그인이 되어있는지 체크한다.
//        //      로그인 체크하는 방법
//        //      session으로 체크
//        // 단, 로그인이 필요하지 않은 URL일 경우 체크하지 않는다.
//        boolean isExcludedUrl = urlList.stream().anyMatch(requestUrl::startsWith);
//        System.out.println("isExcludedUrl = " + isExcludedUrl);
//
//        // 요청이 온 url이 제외된 url로 시작하는지로 검증했기 때문에 '/'를 넣어두면 모든 url에 대해서 로그인 체크를 해서 '/'검증은 따로 빼둠
//        // 제외된 url이 아니고 index url(/)이 아닐 경우에 로그인 체크를 한다.
//        if (!isExcludedUrl && !requestUrl.equals("/")) {
//            HttpSession session = request.getSession();
//            if (session == null || session.getAttribute("id") == null) {
//                // 1-2. 로그인이 되어있지 않으면 login.jsp로 redirect.
//                response.sendRedirect("/fos/login?toURL=" + request.getRequestURI());
//                return;
//            }
//        }
//
//        // 1-1. 로그인이 되어있다면 chain.doFilter(request, response)를 호출한다.
//        filterChain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}