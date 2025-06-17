package com.grongo.urlShortener.services;


public interface UrlService {

    String shortenUrl(String url);
    String getUrl(String id);

}
