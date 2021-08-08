## DELETE API

  <img width="1149" alt="스크린샷 2021-08-08 오전 9 11 20" src="https://user-images.githubusercontent.com/18282470/128617428-a5596c99-84f6-49a6-8196-bee3561de195.png">

|                 |                                   |
| --------------- | --------------------------------- |
| @RestController | Rest API 설정                     |
| @RequestMapping | 리소스를 설정 (method로 구분가능) |

|                |                              |
| -------------- | ---------------------------- |
| @DeleteMapping | Delete Resource 설정         |
| @RequestParam  | URL Query Param Parsing      |
| @PathVariable  | URL Path Variable Parsing    |
| Object         | Query Param Object로 Parsing |

``` java
package me.sungbin.delete.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteApiController {

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable String userId, @RequestParam String account) {

        System.out.println(userId);
        System.out.println(account);

        // delete -> 리소스 삭제 200OK (리소스가 없어도 200 OK)
    }
}

```

![스크린샷 2021-08-08 오전 11 50 21](https://user-images.githubusercontent.com/18282470/128619179-a0d99551-93be-4058-bdba-ffa16059f2ac.png)

