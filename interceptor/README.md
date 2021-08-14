## Interceptor
  * Interceptor란 Filter와 매우 유사한 형태로 존재하지만, 차이점은 Spring Context에 등록된다.
  * AOP와 유사한 기능을 제공할 수 있으며, 주로 **인증 단계**를 처리하거나, Logging를 하는데에 사용한다.
  * 이를 선/후 처리 함으로써, Service business logic과 분리시킨다.
  <img width="926" alt="스크린샷 2021-08-14 오전 11 22 42" src="https://user-images.githubusercontent.com/18282470/129431601-839766be-a46f-4c0e-8e37-21e9d4884353.png">
