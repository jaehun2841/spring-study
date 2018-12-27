package com.example.springstudy.demo6;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestRepository {

    List<TestDTO> getTestAll();
}
