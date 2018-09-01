package com.example.springstudy.demo3.config;

import com.example.springstudy.demo3.servlet.DemoServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoServletConfig {

    @Bean
    public ServletRegistrationBean demoServletRegistrationBean() {
        ServletRegistrationBean demoServletRegistrationBean = new ServletRegistrationBean();
        demoServletRegistrationBean.setServlet(new DemoServlet());
        demoServletRegistrationBean.addUrlMappings("/servlet/demo");
        return demoServletRegistrationBean;
    }
}
