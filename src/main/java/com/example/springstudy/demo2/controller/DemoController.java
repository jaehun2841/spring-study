package com.example.springstudy.demo2.controller;

import com.example.springstudy.demo2.exception.DemoException;
import com.example.springstudy.demo2.exception.FilterException;
import com.example.springstudy.demo2.exception.InterceptorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@Controller
public class DemoController {

    @GetMapping(path="/exception/demo")
    public String occurDemoException() {
        throw new DemoException();
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Permission Denied")
    @ExceptionHandler(value=DemoException.class)
    public String handleDemoException(DemoException e) {
        log.error(e.getMessage());
        return "/error/403";
    }


    @GetMapping(path = "/exception/filter")
    public String occurFilterException() {
        return "";
    }

    @GetMapping(path = "/exception/interceptor")
    public String occurInterceptorException() {
        return "";
    }

    @ExceptionHandler(value = FilterException.class)
    public void handleFilterException(FilterException e) {
        System.out.println("DemoController:handleFilterException => " + e.getMessage());
    }

    @ExceptionHandler(value = InterceptorException.class)
    public void handleInterceptorException(InterceptorException e) {
        System.out.println("DemoController:handleInterceptorException => " + e.getMessage());
        throw e;
    }
}
