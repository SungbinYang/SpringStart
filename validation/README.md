# Spring Boot Validation

## Validation

- Validation
  * Validation이란 프로그래밍에 있어서 가장 필요한 부분입니다. 특히 Java에서는 null값에 대해서 접근하려 할때, null pointer exception이 발생함으로, 이러한 부분을 방지하기 위해서 미리 검증을 하는 과정을 validation이라고 합니다.
  * 단순하게는 아래와 같은 코드들입니다.
  ``` java
    public void run(String account, Spring pw, int age){
      if(account == null || pw == null){
        return; 
      }
      if(age == 0){
        return; 
      }
      // Logic 
    }
  ```
