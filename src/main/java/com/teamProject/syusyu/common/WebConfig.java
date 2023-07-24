package com.teamProject.syusyu.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /* ===== FOS ===== */
        // 공통
        registry.addViewController(ViewPath.FOS + "alertPopup").setViewName("/fos/common/alertPopup");

        // 팝업
        registry.addViewController(ViewPath.FOS + "dlvAddrPopup").setViewName(ViewPath.FOS_POPUP + "dlvAddrPopup");
        registry.addViewController(ViewPath.FOS + "couponPopup").setViewName(ViewPath.FOS_POPUP + "couponPopup");

        // MEMBER

        // PRODUCT

        // ORDER
        registry.addViewController(ViewPath.FOS + "cart").setViewName(ViewPath.FOS_ORDER + "cart");
        registry.addViewController(ViewPath.FOS + "orderView").setViewName(ViewPath.FOS_MYPAGE + "orderView");
        registry.addViewController(ViewPath.FOS + "order/complete").setViewName(ViewPath.FOS_ORDER + "orderComplete");

        // CS
        registry.addViewController(ViewPath.FOS + "mypage/main").setViewName(ViewPath.FOS_MYPAGE + "mypageMain");

        /* ===== BOS ===== */
        registry.addViewController(ViewPath.BOS + "orders/view").setViewName(ViewPath.BOS_ORDER + "orderView");
    }
}
