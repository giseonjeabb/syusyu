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
        registry.addViewController("/alertPopup").setViewName("/fos/common/alertPopup");
        registry.addViewController("/dlvAddrPopup").setViewName(ViewPath.FOS_POPUP + "dlvAddrPopup");
        registry.addViewController("/couponPopup").setViewName(ViewPath.FOS_POPUP + "couponPopup");
        registry.addViewController("/orderComplete").setViewName(ViewPath.FOS_ORDER + "orderComplete");
    }
}
