package com.teamProject.syusyu.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class MultipartConfig {

    //파일 업로드 설정
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(5242880); // 파일 최대 크기: 5MB
        multipartResolver.setMaxUploadSizePerFile(1048576); // 파일당 최대 크기: 1MB
        return multipartResolver;
    }
}
