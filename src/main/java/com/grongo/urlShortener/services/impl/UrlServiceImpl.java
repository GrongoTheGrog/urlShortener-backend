package com.grongo.urlShortener.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grongo.urlShortener.services.UrlService;
import com.grongo.urlShortener.utils.Base62;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    RedisServiceImpl redisService;
    ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public String shortenUrl(String url, String domain) {
        Long redisInt = redisService.getId();
        String id = Base62.encode(redisInt);

        redisService.putUrl(id, url);
        return domain + "/r/" + id;
    }

    @Override
    public String getUrl(String id) {
        return redisService.getUrl(id);
    }
}
