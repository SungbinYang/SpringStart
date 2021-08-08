## Response 내려주기

|                |                                                                |
| -------------- | -------------------------------------------------------------- |
| String         | 일반 Text Type 응답                                            |
| Object         | 자동으로 Json 변환되어 응답 상태값은 항상 200OK                |
| ResponseEntity | Body의 내용을 Object로 설정상황에 따라서 Http Status Code 설정 |
| @ResponseBody  | RestController가 아닌 곳 (Controller)에서 Json 웅답 내릴 때    |

- ApiController.java

```java
package me.sungbin.response.controller;

import me.sungbin.response.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    // TEXT
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

    // JSON
    // req -> Object mapper -> object :: object mapper를 통해서 object로 바뀐다.
    // method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user; // 200 OK
    }

    // ResponseEntity
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}

```

> 기본적으로 rest ai 설계시 text, json, object, ResponseEntity로 내려줄수 있다.

- PageController

```java
package me.sungbin.response.controller;

import me.sungbin.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    // ResponseEntity

    @ResponseBody
    @GetMapping("/user")
    public User user() {
        var user = new User();
        user.setName("robert");
        user.setAddress("경기도 시흥시");
        return user;
    }
}

```

- main.html

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Title</title>
  </head>
  <body>
    Main Html Spring Boot
  </body>
</html>
```

> rest방식 말고 일반 페이지를 내려줄 때는 @Controller로 사용하여 페이지파일명을 리턴한다. <br />
> 또한 주의해야 할 사항은 rest, page 컨트롤러는 서로 분리를 해주어야 한다.

- User.java

```java
package me.sungbin.response.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private String name;
    private Integer age;
    private String phoneNumber;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

```

> 여기서 속성 값이 null인 경우 제외시켜주는 @JsonInclude(JsonInclude.Include.NON_NULL)을 사용할 수 있다.
> 또한 그 외에 여러 가지 에노테이션이 있으니 확인 하면 좋을것 같다.
> 참고로 앞으로 코드 작성시 var이라는 타입추론을 사용할 예정이다.
> 타입추론은 jdk 9버전 이상부터 사용가능하니 유의 부탁드립니다.
