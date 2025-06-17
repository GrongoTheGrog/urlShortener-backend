package com.grongo.urlShortener.services.impl;


import com.grongo.urlShortener.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private String incrementCmd = "INCR url:id";


    @Override
    public Long getId() {
        return redisTemplate.opsForValue().increment(incrementCmd);
    }

    @Override
    public void putUrl(String id, String url) {
        redisTemplate.opsForValue().set(id, url);
    }

    @Override
    public String getUrl(String id) {
        return redisTemplate.opsForValue().get(id);
    }
}
