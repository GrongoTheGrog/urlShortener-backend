package com.grongo.urlShortener.services;


public interface UrlService {

    String shortenUrl(String url, String domain);
    String getUrl(String id);

}
