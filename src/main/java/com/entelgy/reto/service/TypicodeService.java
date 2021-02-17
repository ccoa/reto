package com.entelgy.reto.service;

import com.entelgy.reto.util.PostTypicode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
@Slf4j
public class TypicodeService {

    @Value("${app.ws.typicode.url}")
    private String typicodeUrl;

    private final RestTemplate restTemplate;

    public TypicodeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PostTypicode[] getPosts() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<PostTypicode[]> entity = new HttpEntity<>(headers);

        PostTypicode[] postTypicodes = null;

        try {
            postTypicodes = restTemplate.exchange(typicodeUrl, HttpMethod.GET, entity, PostTypicode[].class).getBody();
        } catch (Exception e) {
            log.error("Exception {}", e.getMessage());
        }

        return postTypicodes;
    }
}
