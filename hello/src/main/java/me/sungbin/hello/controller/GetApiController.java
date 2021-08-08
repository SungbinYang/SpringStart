package me.sungbin.hello.controller;

import me.sungbin.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") // http:localhost:9090/api/get/hello
    public String hello() {
        return "get Hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET) // get방식의 또 다른 방식  // http:localhost:9090/api/get/hi
    public String hi() {
        return "hi";
    }

    // http:localhost:9090/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName) {
        System.out.println("PathVariable: " + pathName);
        return pathName;
    }

    // search?q=intellij
    // &oq=intel
    // &aqs=chrome.0.69i59j69i57j35i39j0i433i512l2j69i60l3.1126j0j7
    // &sourceid=chrome
    // &ie=UTF-8
    // ?key=value&key2=value2
    // http://localhost:9090/api/get/query-param?user=robert&email=robert@gmail.com&age=26
    @GetMapping(path = "/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();

        queryParam.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
            System.out.println();

            sb.append(key).append(" = ").append(value).append("\n");
        });

        return sb.toString();
    }

    @GetMapping("/query-params")
    public String queryParams(@RequestParam String name,
                              @RequestParam String email,
                              @RequestParam int age) {

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name + " " + email + " " +  age;
    }

    // queryParameter를 받을 때 가장 좋은 방법
    // http://localhost:9090/api/get/query-param?user=robert&email=robert@gmail.com&age=26
    @GetMapping("/query-params-dto")
    public String queryParamsWithDto(UserRequest userRequest) {
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString();
    }

}
