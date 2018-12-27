package com.example.springstudy.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.example.springstudy.demo6")
public class MybatisConfig {
}
