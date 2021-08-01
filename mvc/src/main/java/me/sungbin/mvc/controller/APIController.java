package me.sungbin.mvc.controller;

import me.sungbin.mvc.dto.UserReq;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {

    @GetMapping
    public UserReq user(UserReq userReq) {
        return userReq;
    }
}
