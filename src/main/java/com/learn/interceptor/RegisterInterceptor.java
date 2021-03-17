package com.learn.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RegisterInterceptor implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //测试切面校验sign
        /*registry.addInterceptor(new BaseInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new SecondInterceptor()).addPathPatterns("/**");*/
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
