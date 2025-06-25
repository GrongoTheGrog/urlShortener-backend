package com.grongo.urlShortener.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.grongo.urlShortener.services.RedisService;
import com.grongo.urlShortener.services.UrlService;
import com.grongo.urlShortener.services.impl.UrlServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UrlController {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private static class UrlBody {
        private String url;
    }

    @Autowired
    UrlService urlService;

    @Autowired
    RedisService redisService;

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/")
    public String ping(){
        return "pong";
    }

    @GetMapping("/urls/{id}")
    public String get(@PathVariable String id){
        return urlService.getUrl(id);
    }

    @PostMapping("/shortenUrl")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> shortenUrl(
            @RequestBody UrlBody urlBody
    ){
        return ResponseEntity.ok().body(urlService.shortenUrl(urlBody.getUrl()));
    }

    @GetMapping("/r/{id}")
    public RedirectView redirect(@PathVariable String id, HttpServletRequest request){
        System.out.println(id);
        String url = urlService.getUrl(id);
        System.out.println(url);
        RedirectView redirectView = new RedirectView(url);
        redirectView.setStatusCode(HttpStatus.TEMPORARY_REDIRECT);
        return redirectView;
    }

}
