package com.grongo.urlShortener.controllers;


import com.grongo.urlShortener.services.UrlService;
import com.grongo.urlShortener.services.impl.UrlServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class UrlController {

    @Autowired
    UrlService urlService;

    @PostMapping("/shortenUrl")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> shortenUrl(
            @RequestBody String url
    ){
        return ResponseEntity.ok().body(urlService.shortenUrl(url));
    }

    @GetMapping("/{id}")
    public RedirectView redirect(@PathVariable String id, HttpServletRequest request){
        String url = urlService.getUrl(id);
        RedirectView redirectView = new RedirectView(url);
        redirectView.setStatusCode(HttpStatus.PERMANENT_REDIRECT);
        return redirectView;
    }
}
