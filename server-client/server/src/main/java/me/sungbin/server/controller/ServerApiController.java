package me.sungbin.server.controller;

import lombok.extern.slf4j.Slf4j;
import me.sungbin.server.dto.Req;
import me.sungbin.server.dto.User;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);

        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public Req<User> post(
//                          HttpEntity httpEntity,
                          @RequestBody Req<User> user,
                          @PathVariable int userId, @PathVariable String userName,
                          @RequestHeader("x-authorization") String authorization, @RequestHeader("custom-header") String customHeader) {
//        log.info("req: {}", httpEntity.getBody());
        log.info("userId: {}, userName: {}", userId, userName);
        log.info("authorization: {}, custom: {}", authorization, customHeader);
        log.info("client req: {}", user);

        Req<User> response = new Req<>();
        response.setHeader(new Req.Header());
        response.setResBody(user.getResBody());

        return response;
    }
}
