## PUT API

  <img width="1149" alt="스크린샷 2021-08-08 오전 9 11 20" src="https://user-images.githubusercontent.com/18282470/128617428-a5596c99-84f6-49a6-8196-bee3561de195.png">

|                 |                                   |
| --------------- | --------------------------------- |
| @RestController | Rest API 설정                     |
| @RequestMapping | 리소스를 설정 (method로 구분가능) |

|               |                           |
| ------------- | ------------------------- |
| @PutMapping   | Put Resource 설정         |
| @RequestBody  | Request Body부분 Parsing  |
| @PathVariable | URL Path Variable Parsing |

* PutApiController.java
``` java
package me.sungbin.put;

import me.sungbin.put.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{userId}")
    public PutRequestDto put(@RequestBody PutRequestDto requestDto, @PathVariable(name = "userId") String id) {
        System.out.println(requestDto);
        System.out.println(id);
        return requestDto;
    }
}

```

* PutRequestDto.java
``` java
package me.sungbin.put.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PutRequestDto {

    private String name;
    private int age;
    private List<Car> carList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public String toString() {
        return "PutRequestDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", carList=" + carList +
                '}';
    }
}

```

* Car.java
``` java
package me.sungbin.put.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Car {

    private String name;

    private String carNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }
}

```

* 실행화면
![스크린샷 2021-08-08 오전 11 35 21](https://user-images.githubusercontent.com/18282470/128618927-4c0b9887-e270-4388-8df7-65777e7c3f06.png)

> post와 마찬가지로 http는 put으로 url입력후 send를 한다.
