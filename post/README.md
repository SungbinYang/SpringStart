## POST API

  <img width="1149" alt="스크린샷 2021-08-08 오전 9 11 20" src="https://user-images.githubusercontent.com/18282470/128617428-a5596c99-84f6-49a6-8196-bee3561de195.png">

|                 |                                   |
| --------------- | --------------------------------- |
| @RestController | Rest API 설정                     |
| @RequestMapping | 리소스를 설정 (method로 구분가능) |

|               |                           |
| ------------- | ------------------------- |
| @PostMapping  | Post Resource 설정        |
| @RequestBody  | Request Body부분 Parsing  |
| @PathVariable | URL Path Variable Parsing |
| @JsonProperty | json naming               |
| @JsonNaming   | class json naming         |

* PostApiController.java
``` java
package me.sungbin.post.controller;

import me.sungbin.post.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData) {

        requestData.forEach((key, value) -> {
            System.out.println("key: " + key);
            System.out.println("value: " + value);
        });
    }

    @PostMapping("/posts")
    public void posts(@RequestBody PostRequestDto requestDto) {
        System.out.println(requestDto);
    }
}

```

* PostRequestDto.java
``` java
package me.sungbin.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequestDto {

    private String account;
    private String email;
    private String address;
    private String password;

    @JsonProperty("phone_number")
    private String phoneNumber; // phone_number

    @JsonProperty("OTP")
    private String OTP;

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PostRequestDto{" +
                "account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", OTP='" + OTP + '\'' +
                '}';
    }
}

```
* PostApplication.java

``` java
package me.sungbin.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostApplication.class, args);
	}

}

```

![스크린샷 2021-08-08 오전 11 07 30](https://user-images.githubusercontent.com/18282470/128618418-413f3360-ec08-4b96-b125-373dbce74631.png)

> http 타입을 POST로 url을 입력하고 HEADERS부분에 json형태의 값을 입력하고 send를 누른다.
