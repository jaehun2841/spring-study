package com.example.springstudy.config;

import com.example.springstudy.demo1.interceptor.TestInterceptor;
import com.example.springstudy.demo1.interceptor.TestInterceptor2;
import com.example.springstudy.demo1.resolver.ClientIpArgumentResolver;
import com.example.springstudy.demo2.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(new ClientIpArgumentResolver());
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/*");
        registry.addInterceptor(new TestInterceptor2()).addPathPatterns("/*");
        registry.addInterceptor(new DemoInterceptor()).addPathPatterns("/exception/interceptor");
    }
}
