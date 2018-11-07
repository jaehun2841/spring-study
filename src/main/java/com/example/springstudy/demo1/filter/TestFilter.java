package com.example.springstudy.demo1.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Component
@WebFilter(
        description = "1번째 필터",
        urlPatterns = "/*",
        filterName = "Test-Filter1"
)
@Order(2)
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("start testFilter1");
        filterChain.doFilter(servletRequest, servletResponse);
        //System.out.println("finish testFilter1");
    }

    @Override
    public void destroy() {

    }
}
