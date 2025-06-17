package com.grongo.urlShortener.interceptors;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.xml.crypto.Data;
import java.util.Date;

public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ){
        System.out.printf("[INFO] %s %s\n", new Date(), request.getRequestURL());

        return true;
    }

}
