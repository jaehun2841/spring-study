package com.example.springstudy.config;

import com.example.springstudy.demo1.filter.TestFilter;
import com.example.springstudy.demo1.filter.TestFilter2;
import com.example.springstudy.demo1.filter.TestFilter3;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

@Configuration
public class WebInitializerConfig extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{
                new TestFilter(),
                new TestFilter2(),
                new TestFilter3()
        };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
