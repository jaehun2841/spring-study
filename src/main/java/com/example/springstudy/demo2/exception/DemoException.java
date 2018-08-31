package com.example.springstudy.demo2.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED, reason = "This Method Not Allowed!!")
public class DemoException extends RuntimeException {
}
