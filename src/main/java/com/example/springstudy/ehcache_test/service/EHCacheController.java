package com.example.springstudy.ehcache_test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EHCacheController {

    @Autowired
    private EHCacheRepository repository;

    @GetMapping("/data/{id}")
    public String getData(@PathVariable("id") int id) throws InterruptedException {

        long start = System.currentTimeMillis();
        String data = repository.getData(id);
        long end = System.currentTimeMillis();

        log.info("쿼리 수행 시간 : {}ms", end-start);
        return data;
    }

    @GetMapping("/data/delete/{id}")
    public void getExpireCache(@PathVariable("id") int id) {
        repository.evictCache(id);
    }
}
