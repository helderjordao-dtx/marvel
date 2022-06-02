package com.java.marvel.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeMarvelAPI {

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.url}")
    private String apiUrl;

    @RequestMapping(value = "/characters")
    public String getCharactersList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET, entity, String.class).getBody();
        return response;

    }
}
