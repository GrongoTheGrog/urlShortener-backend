package com.grongo.urlShortener.services;


import jakarta.servlet.http.HttpServletRequest;

public interface UrlService {

    String shortenUrl(String url, String domain);
    String getUrl(String id);
    String buildRequestUrl(HttpServletRequest request);
}
