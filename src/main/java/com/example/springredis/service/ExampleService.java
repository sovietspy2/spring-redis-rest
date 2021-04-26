package com.example.springredis.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExampleService {

    @Cacheable(cacheNames = "myExample")
    public String someProcessing() {

        log.info("This is not from cache!");
        return "LOL";
    }

}
