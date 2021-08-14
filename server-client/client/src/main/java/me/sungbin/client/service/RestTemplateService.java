package me.sungbin.client.service;

import lombok.extern.slf4j.Slf4j;
import me.sungbin.client.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class RestTemplateService {

    // http://localhost/api/server/hello
    // response
    public UserResponse hello() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name", "aaaaa")
                .queryParam("age", 99)
                .encode()
                .build()
                .toUri();

        log.info(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);

        log.info(String.valueOf(result.getStatusCode()));
        log.info(String.valueOf(result.getBody()));

        return result.getBody();
    }
}
