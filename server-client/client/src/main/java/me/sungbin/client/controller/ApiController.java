package me.sungbin.client.controller;

import lombok.RequiredArgsConstructor;
import me.sungbin.client.dto.UserResponse;
import me.sungbin.client.service.RestTemplateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ApiController {

    private final RestTemplateService restTemplateService;

    @GetMapping("/hello")
    public UserResponse getHello() {
        return restTemplateService.hello();
    }
}
