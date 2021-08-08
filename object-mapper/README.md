## Object Mapper

- User.java

```java
package me.sungbin.objectmapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;

    public User() {
        this.name = null;
        this.age = 0;
        this.phoneNumber = null;
    }

    public User(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User defaultUser() {
        return new User("default", 0, null);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

```

- ObjectMapperApplicationTests.java

```java
package me.sungbin.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("-------------------");

        // Text Json -> Object
        // Object -> Text Json

        // controller req json(text) -> object
        // response object -> json(text)

        var objectMapper = new ObjectMapper();

        // object -> text
        // object mapper가 get method를 사용한다.
        var user = new User("rovbert", 26, "010-1111-2222");
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text -> object
        // 이 경우 object mapper는 기본 생성자가 필요하다.
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
    }

}
```

> 간단하게 ObjectMapper 동작원리를 테스트 코드를 통하여 확인해보았다.
> 일반적으로 json -> object로 바꿔줄수 있고 그 역도 성립이 가능하며
> snake_case형식으로 설정을 해주면 자동 매핑을 해줄 수 있다.
