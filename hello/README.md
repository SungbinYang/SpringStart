# Spring Boot 시작하기

## Spring Boot

  <img width="1197" alt="스크린샷 2021-08-08 오전 8 09 59" src="https://user-images.githubusercontent.com/18282470/128615992-602985ae-bdc1-4b68-9f43-fc35b52c7657.png">
  - https://docs.spring.io/spring-boot/docs/2.1.x/reference/html/getting-started-introducing-spring-boot.html
  - Spring Boot는 단순히 실행되며, **프로덕션 제품 수준의 스프링 기반 어플리케이션을 쉽게 만들수 있다.**
  - Spring Boot 어플리케이션에는 **Spring 구성**이 거의 필욧하지 않다.
  - Spring Boot **java -jar로 실행하는 Java Application**을 만들 수 있다.
  
  - 주요 목표
    * **Spring 개발에 대해 빠르고,** 광범위하게 적용할 수 있는 환경
    * **기본값 설정**이 있지만 설정을 바꿀수 있다.
    * **대규모 프로젝트**에 공통적인 비 기능 제공 (보안, 모니터링 등등)
    * **XML 구성 요구사항**이 전형 없음
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
