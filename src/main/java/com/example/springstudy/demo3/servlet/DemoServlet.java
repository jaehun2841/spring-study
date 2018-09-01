package com.example.springstudy.demo3.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class DemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doGet() 실행실행실행!!!");
        Thread thread = Thread.currentThread();
        log.info("Thread ID : " + thread.getId());
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        log.info("Servlet destroy()");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        log.info("Servlet init()");
        super.init();
    }
}
