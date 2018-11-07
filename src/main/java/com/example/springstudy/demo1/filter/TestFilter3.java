package com.example.springstudy.demo1.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Component
@WebFilter(description = "3번째 필터",
        urlPatterns = "/*",
        filterName = "Test-Filter3"
)
@Order(3)
public class TestFilter3 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("start testFilter3");
        filterChain.doFilter(servletRequest, servletResponse);
        //System.out.println("finish testFilter3");
    }

    @Override
    public void destroy() {

    }
}
