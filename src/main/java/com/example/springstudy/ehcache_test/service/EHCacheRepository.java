package com.example.springstudy.ehcache_test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class EHCacheRepository {

    @Cacheable(value = "testData", key = "#id")
    public String getData(int id) throws InterruptedException {
        Thread.sleep(3000);
        return "test-data";
    }

    @CacheEvict(value = "testData", allEntries = true)
    public void evictCache(int id) {
        log.info("delete cache all");
    }
}
