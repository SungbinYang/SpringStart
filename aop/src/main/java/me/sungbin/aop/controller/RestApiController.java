package me.sungbin.aop.controller;

import me.sungbin.aop.annotation.Decode;
import me.sungbin.aop.annotation.Timer;
import me.sungbin.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        System.out.println("get method");
        System.out.println("get method: " + id);
        System.out.println("get method: " + name);

        return id + " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {
        System.out.println("post method: " + user);
        return user;
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user) {
        System.out.println("put method: " + user);
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {

        // db logic
        Thread.sleep(2000);
    }
}
