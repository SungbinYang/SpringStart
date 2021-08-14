# Spring Boot Filter and Interceptor

## Filter
  * Filter란 Web Application에서 관리되는 영역으로써 Spring Boot Framework에서 Client로부터 오는 요청 / 응답에 대해서 최초 / 최종단계의 위치에 존재하며, 이를 통해서 요청 / 응답의 정보를 변경하거나, Spring에 의해서 데이터가 변환되기 전의 순수한 Client의 요청/응답값을 확인 할 수 있다.
  * **유일하게 ServletRequest, ServletResponse의 객체를 변환** 할 수있다.
  * 주로 Spring Framework에서는 request / response의 Logging용도로 활용하거나, <br /> 인증과 관련돤 Logic들을 해당 Filter에서 처리한다.
  * 이를 선/후 처리함으로써, Service business logic과 분리시킨다.
  
  <img width="782" alt="스크린샷 2021-08-14 오전 10 22 05" src="https://user-images.githubusercontent.com/18282470/129430339-61453cf1-fbb9-4f9d-b855-72faec9693f3.png">
 
