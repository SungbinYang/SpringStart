# Spring Boot 시작하기

## Spring Boot

  <img width="1197" alt="스크린샷 2021-08-08 오전 8 09 59" src="https://user-images.githubusercontent.com/18282470/128615992-602985ae-bdc1-4b68-9f43-fc35b52c7657.png">
  
  - https://docs.spring.io/spring-boot/docs/2.1.x/reference/html/getting-started-introducing-spring-boot.html
  - Spring Boot는 단순히 실행되며, 프로덕션 제품 수준의 스프링 기반 어플리케이션을 쉽게 만들수 있다.
  - Spring Boot 어플리케이션에는 Spring 구성이 거의 필욧하지 않다.
  - Spring Boot java -jar로 실행하는 Java Application을 만들 수 있다.
  
  - 주요 목표
    * Spring 개발에 대해 빠르고,광범위하게 적용할 수 있는 환경
    * 기본값 설정이 있지만 설정을 바꿀수 있다.
    * 대규모 프로젝트에 공통적인 비 기능 제공 (보안, 모니터링 등등)
    * XML 구성 요구사항이 전형 없음
  - Build Tool
     |Name|Version|
     |---|---|
     |Maven|3.3+|
     |Gradle|4.x(4.4 and later) and 5.x|
  - Servlet Containers
     |Name|Servlet Version|
     |---|---|
     |Tomcat 9.x|3.3|
     |Jetty 9.4|3.1|
     |Undertow 2.0|4.0|
     |Netty|-|
  - https://start.spring.io
    ![스크린샷 2021-08-08 오전 8 22 42](https://user-images.githubusercontent.com/18282470/128616157-7c24d523-9d76-4c9f-8892-4ebc76cb75d7.png)
  - Spring Boot 특징
    * 어플리케이션 개발에 필수 요소들만 모아두었다.
    * 간단한 설정으로 개발 및 커스텀이 가능하다.
    * 간단하고, 빠르게 어플리케이션 실행 및 배포가 가능하다.
    * 대규모 프로젝트(운영환경)에 필요한 비 기능적 기능도 제공한다.
    * 오랜 경험에서 나오는 안정적인 운영이 가능하다.
    * Spring에서 불편한 설정이 없어졌다. (XML 설정등등)

## REST Client 설치하기

- https://chrome.google.com/webstore/category/extensions?utm_source=chrome-ntp-icon
- https://chrome.google.com/webstore/detail/talend-api-tester-free-ed/aejoelaoggembcahagimdiliamlcdmfm?utm_source=chrome-ntp-icon

## Hello Spring Boot

* ApiController.java
```java
package me.sungbin.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 class는 REST API 처리하는 Controller
@RequestMapping("/api") // RequestMapping URI를 지정해주는 Annotation
public class ApiController {

    @GetMapping("/hello") // 해장주소가 http://localhost:9090/api/hello
    public String hello() {
        return "hello Spring Boot!";
    }
}

```

* HelloApplication
```java
package me.sungbin.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

}

```

* application.properties
```properties
    server.port=9090
```

* 실행화면
  ![스크린샷 2021-08-08 오전 8 55 51](https://user-images.githubusercontent.com/18282470/128616539-96d2d368-09a8-49f3-80ea-491139b63bf1.png)
  ![스크린샷 2021-08-08 오전 8 56 02](https://user-images.githubusercontent.com/18282470/128616545-44b4a756-091c-4f8c-83dc-f9362693cd05.png)


## GET API
<img width="1149" alt="스크린샷 2021-08-08 오전 9 11 20" src="https://user-images.githubusercontent.com/18282470/128616744-1f4d7185-8904-449c-8b56-b1479be632aa.png">

|                 |                                   |
| --------------- | --------------------------------- |
| @GetMapping | Get Resource 설정                     |
| @RequestParam | URL Query Param Parsing |
| @PathVariable | URL Query Variable Parsing |
| Object | Query Param Object로 Parsing |

|               |                           |
| ------------- | ------------------------- |
| @RestController  | Rest API 설정        |
| @RequestMapping  | 리소스를 설정 (method로 구분가능)  |

* GetApiController.java
``` java
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

  ```
  * UserRequest.java
``` java
package me.sungbin.hello.dto;

public class UserRequest {

    private String name;

    private String email;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}

  ```
* 실행화면
![](https://images.velog.io/images/ysb05222/post/19836c63-5c16-473d-a21c-6a7c7e50e533/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-08-08%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%2010.37.02.png)

> 다음과 같은 구글 웹스토어에 rest client 프로그램에 http방식과 url을 적어서 테스트를 해볼수 있다.
방식은 get인 경우 url을 적고 쿼리스트링이 있는경우 적고 send버튼을 보내면 끝이다.


