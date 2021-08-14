# JUnit

## JUnit으로 테스트 하기

  * TDD (Test-driven Development)
    - 테스트 주도 개발에서 사용하지만, 코드의 유지보수 및 운영 환경에서의 에러를 미리 방지하기 위해서 단위 별 검증하는 테스트 프레임워크
  * 단위 테스트
    - 작성한 코드가 기대하는 대로 동작을 하는지 검증하는 절차
  * JUnit
    - Java기반의 단위테스트를 위한 프레임워크
    - Annotation 기반으로 테스트를 지원하며, Assert를 통하여 (예상, 실제)를 통해 검증
  * Jacoco
    - Java 코드의 코드 커버리지를 체크하는 라이브러리
    - 결과를 html, xml, csv로 확인이 가능하다.

# Jacoco

> 테스트 코드를 작성하는 것은 정말 중요한 일이다.
> 하지만 내 테스트 코드가 완벽히 잘 짰는지는 의문점이 들기도 한다.
> 그리고 기존 코드를 전부 테스트를 하였는지 코드가 많아지면 측정하기 힘들다.
> 그래서 나의 테스트 커버리지 측정을 위해 나온 것이 Jacoco다.

## Jacoco 설정방법

* build.gradle에 plugins 부분에 id : "jacoco"를 넣어준다.
``` gradle
plugins {
    id 'org.springframework.boot' version '2.5.3'
    id 'io.spring.dependency-management' version '1.0.11.RELEASE'
    id 'java'
    id 'jacoco'
}

group = 'me.sungbin'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '11'

configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web:2.5.3'
    compileOnly 'org.projectlombok:lombok:1.18.20'
    annotationProcessor 'org.projectlombok:lombok:1.18.20'
    testImplementation 'org.springframework.boot:spring-boot-starter-test:2.5.3'
}

test {
    useJUnitPlatform()
}

```

* 그리고 gradle 탭을 눌러서 Task에 verification을 클릭하여 test를 클릭한다.
![](https://images.velog.io/images/ysb05222/post/bc003283-b45e-4e92-a647-c6d4b79baa3a/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-08-14%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%206.34.12.png)

* 그리고 build에 reports에 tests에 test에 index.html을 클릭하면 다음과 같이 테스트 케이스에 실패한 것이 있는 지 나올것이다.
![](https://images.velog.io/images/ysb05222/post/6dd5cb9f-1f97-4b16-880e-53c050a7a76a/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-08-14%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%206.28.52.png)

* 다음으로 jacocoTestReports를 누른다.
![](https://images.velog.io/images/ysb05222/post/52429ec2-f77a-4ffc-a71a-deb3a1179bc7/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-08-14%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%206.37.18.png)

* 마지막으로 build에 reports에 jacoco에 test에 html에 index.html을 클릭하면 다음과 같이 나온다.

![](https://images.velog.io/images/ysb05222/post/0cf923da-44d1-4718-b748-9dc7a0521fd5/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-08-14%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%206.30.02.png)

> 이렇게 내가 어느정도 테스트를 했는지 확인을 할 수 있다.

