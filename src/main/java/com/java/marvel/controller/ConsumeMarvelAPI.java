package com.java.marvel.controller;

import java.util.Arrays;

import com.java.marvel.model.CharacterItem;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/characters")
    public String getCharactersList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String url = "https://gateway.marvel.com:443/v1/public/characters?ts=1&apikey=9412d02c19994d916e56ec1700a9ff74&hash=431140e0f8d521ac0347d573ffc357d2";

        return restTemplate.exchange(
                url,
                HttpMethod.GET, entity, String.class).getBody();
    }
}
