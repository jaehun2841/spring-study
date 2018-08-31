package com.example.springstudy.demo2.controller;

import com.example.springstudy.demo2.exception.DemoException;
import com.example.springstudy.demo2.exception.FilterException;
import com.example.springstudy.demo2.exception.InterceptorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class DemoControllerAdvisor {

    @ExceptionHandler(value = DemoException.class)
    public String handleDemoExceptionForGlobal(DemoException e) {
        log.error(e.getMessage());
        return "/error/404";
    }

    @ExceptionHandler(value = FilterException.class)
    public void handleFilterException(FilterException e) {
        System.out.println("DemoControllerAdvisor:handleFilterException => " + e.getMessage());
    }

    @ExceptionHandler(value = InterceptorException.class)
    public void handleInterceptorException(InterceptorException e) {
        System.out.println("DemoControllerAdvisor:handleInterceptorException => " + e.getMessage());
    }
}
