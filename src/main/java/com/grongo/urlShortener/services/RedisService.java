package com.grongo.urlShortener.services;



public interface RedisService {

    Long getId();
    void putUrl(String id, String url);
    String getUrl(String id);

}
