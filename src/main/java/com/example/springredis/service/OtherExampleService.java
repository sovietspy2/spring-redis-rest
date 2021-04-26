package com.example.springredis.service;

import com.example.springredis.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class OtherExampleService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void addItemToRedis(String key, Object item) {
        redisTemplate.opsForValue().set(key, item);
    }

    public Item getItemFromRedis(String key) {
        Item item = new Item();

        String cached = (String) redisTemplate.opsForValue().get(key);

        item.setName(cached);

        return item;
    }


    public void addToList(String item) {
        redisTemplate.opsForList().rightPush("myList", item);
    }

    public String getLastItemFromList() {
        return (String) redisTemplate.opsForList().rightPop("myList");
    }

    public String getFirstElementFromList() {
        return (String) redisTemplate.opsForList().leftPop("myList");
    }



}
