package com.example.springstudy.demo1.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Component
@WebFilter(description = "2번째 필터",
        urlPatterns = "/*",
        filterName = "Test-Filter2"
)
@Order(1)
public class TestFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("start testFilter2");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("finish testFilter2");
    }

    @Override
    public void destroy() {

    }
}
