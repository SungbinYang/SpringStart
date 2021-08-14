package me.sungbin.client.service;

import lombok.extern.slf4j.Slf4j;
import me.sungbin.client.dto.Req;
import me.sungbin.client.dto.UserRequest;
import me.sungbin.client.dto.UserResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

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

    public void post() {
        // http://lcoalhost:9090/api/server/user/{userId}/name/{userName}

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand("100", "robert")
                .toUri();

        log.info(String.valueOf(uri));

        // http body -> object -> object mapper -> rest template -> http body json
        UserRequest req = new UserRequest();
        req.setName("robert");
        req.setAge(10);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(uri, req, String.class);

        log.info(String.valueOf(response.getStatusCode()));
        log.info(String.valueOf(response.getHeaders()));
        log.info(String.valueOf(response.getBody()));

//        return response.getBody();
    }

    public UserResponse exchange() {
        // http://lcoalhost:9090/api/server/user/{userId}/name/{userName}

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand("100", "robert")
                .toUri();

        log.info(String.valueOf(uri));

        // http body -> object -> object mapper -> rest template -> http body json
        UserRequest req = new UserRequest();
        req.setName("robert");
        req.setAge(10);

        RequestEntity<UserRequest> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header", "ffffff")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.exchange(requestEntity, UserResponse.class);

        return response.getBody();
    }

    public Req<UserResponse> genericExchange() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand("100", "robert")
                .toUri();

        log.info(String.valueOf(uri));

        // http body -> object -> object mapper -> rest template -> http body json
        UserRequest userRequest = new UserRequest();
        userRequest.setName("robert");
        userRequest.setAge(10);

        Req<UserRequest> req = new Req<>();
        req.setHeader(
                new Req.Header()
        );
        req.setResBody(
                userRequest
        );

        RequestEntity<Req<UserRequest>> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header", "ffffff")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Req<UserResponse>> response = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<>() {});

        return Objects.requireNonNull(response.getBody());
    }
}
