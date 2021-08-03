# 디자인 패턴

## 디자인 패턴이란?
  - 디자인 패턴
    * 자주 사용하는 설계패턴을 정형화해서 이를 유형별로 가장 최적의 방법으로 개발을 할 수 있도록 정해둔 설계 <br /> 알고리즘과 유사하지만 명확하게 정답이 있는 형태는 아니며, 프로젝트의 상황에 맞추어 적용이 가능하다. 
  - Gof 디자인 패턴
    * 소프트웨어를 설계를 할 때는 기존에 경험이 매우 중요하다. 그러나 모든 사람들이 다양한 경험을 가지고 있을수 없다.
    * 이러한 지식을 공유하기 위해서 나온 것이 GOF (Gang of Four)의 디자인 패턴이다. 객체지행 개념에 따른 설계 중 재사용할 경우 유용한 설계를 디자인 패턴으로 정리해둔 것이다.
    * Gof의 디자인 패턴은 총 23개이며, 이를 잘 이해하고 활용한다면 경험이 부족하더라도 좋은 소프트웨어 설계가 가능하다.
  - 디자인 패턴의 장점
    * 개발자(설계자) 간의 원활한 소통
    * 소프트웨어 구조 파악 용이
    * 재사용을 통한 개발시간 단축
    * 설계변경 요청에 대한 유연한 대처
  - 디자인 패턴의 단점
    * 객체지향 설계 / 구현
    * 초기투자비용 부담
  - 생성 패턴
    * 객체를 생성하는 것과 관련된 패턴으로, 객체의 생성과 변경이 전체 시스템에 미치는 영향을 최소화하고, <br /> 코드의 유연성을 높여준다.

    > Factory Method <br />
    > **Singletone** <br />
    > Prototype <br />
    > **Builder** <br />
    > Abstract Factory <br />
    > **Chaining**

  - 구조 패턴
    * 프로그램 내의 자료구조나 인터페이스 구조 등 프로그램 구조를 설계하는데 활용 될 수 있는 패턴 <br />
    클래스, 객체들의 구성을 통해서 더 큰 구조를 만들수 있게 해준다. <br />
    큰 규모의 시스템에서는 많은 클래스들이 서로 의존성을 가지게 되는데, 이런 복잡한 구조를 개발하기 쉽게 만들어주고, 유지보수 하기 쉽게 만들어준다.

    > **Adapter** <br />
    > Composite <br />
    > Bridge <br />
    > **Decorator** <br />
    > **Facade** <br />
    > Flyweight <br />
    > **Proxy**

  - 행위 패턴
    * 반복적으로 사용되는 객체들의 상호작용을 패턴화한것으로, 클래스나 객체들이 상호작용하는 방법과 책임을 분산하는 방법을 제공한다. 행위 패턴은 행위관련 패턴을 사용하여 독립적으로 일을 처리하고자 할 때 사용

    > Template Method <br />
    > Interpreter <br />
    > Iterator <br />
    > **Observer** <br />
    > **Strategy** <br />
    > Visitor <br />
    > Chain of responsibility <br />
    > Command <br />
    > Mediator <br />
    > State <br />
    > Memento

## Singleton Pattern
  - Singleton Pattern
    * Singleton 패턴은 어떠한 클래스(객체)가 유일하게 1개만 존재 할 때 사용한다.
    * 이를 주로 사용하는 곳은 서로 자원을 공유할 때 사용하는데, 실물 세계에서는 프린터가 해당되며, <br /> 실제 프로그래밍에서는 TCP Soket통신에서 서버와 연결된 connect 객체에 주로 사용한다.
    <img width="395" alt="스크린샷 2021-08-03 오후 8 49 31" src="https://user-images.githubusercontent.com/18282470/128012622-f6f36413-88b7-4c14-9408-bde7cf1f9089.png">

## Adapter Pattern
  - Adapter Pattern
    * Adapter는 실생활에서는 100V를 220V로 변경해주거나, 그 반대로 해주는 흔히 돼지코라고 불리는 변환기를 예로 들수 있다.
    * 호환성이 없는 기존 클래스의 인터페이스를 변환하여 재사용 할 수 있도록한다.
    * SOLID중에서 개방폐쇄원칙(OCP)를 따른다.
    <img width="1097" alt="스크린샷 2021-08-03 오후 9 11 11" src="https://user-images.githubusercontent.com/18282470/128013138-a1bcb849-4cca-4a78-8193-0aae22cbbbb9.png">

## Proxy Pattern
  - Proxy Pattern
    * Proxy는 대리인이라는 뜻으로, 뭔가를 대신해서 처리하는 것
    * Proxy Class를 통해서 대신 전달하는 형태로 설계되며, 실제 Client는 Proxy로부터 결과를 받는다. <br> Cache의 기능으로도 활용이 가능하다.
    * SOLID중에서 개방폐쇄 원칙(OCP)과 의존 역전 원칙(DIP)를 따른다.
    <img width="1046" alt="스크린샷 2021-08-03 오후 9 54 03" src="https://user-images.githubusercontent.com/18282470/128018878-018435c0-86bd-4bfe-a576-7fd2e8863b2e.png">

## Decorator Pattern
  - Decorator Pattern
    * 데코레이터 패턴은 기존 뼈대(클래스)는 유지하되, 이후 필요한 형태로 꾸밀때 사용한다. 확장이 필요한 경우 상속의 대안으로도 활용한다. SOLID중에서 개방폐쇄원칙(OCP)과 의존역전원칙(DIP)를 따른다.
    <img width="1088" alt="스크린샷 2021-08-03 오후 10 26 31" src="https://user-images.githubusercontent.com/18282470/128023295-b5ae377c-782b-4ce0-b61e-5d950bdb08b4.png">



    
