# Web 개론

## Web이란 무엇인가?
  - (World Wide Web, WWW, W3)은 인터넷에 연결된 컴퓨터를 통해 사람들이 정보를 공유할 수 있는 전 세계적인 정보공간을 말한다.
  - Web의 용도는 다양하게 나눌수 있다.
  - Web Site
    * google, naver, daum, facebook등 HTML로 구성된 여러 사이트들
  - API (Application Programming Interface) * Web Service
    * Kakao Open API, Google Open API, Naver Open API
  - User Interface
    * Chrome, Safari, Explorer, Edge, Smart Watch, IP TV등
  
## Web의 기본 3가지 요소

  <img width="1218" alt="스크린샷 2021-08-04 오후 9 49 43" src="https://user-images.githubusercontent.com/18282470/128183505-221fbf30-1df5-4c2f-ae37-c9e0977fc61c.png">

## REST
  - REST (Representational State Transfer: 자원의 상태 전달) - 네트워크 아키텍쳐
    1. Client, Server : 클라이언트와 서버가 독립적으로 분리되어 있어야 한다.
    2. Stateless : 요청에 대해서 클라이언트의 상태를 저장하지 않는다.
    3. Cache : 클라이언트는 서버의 응답을 Cache(임시저장) 할 수 있어야한다. <br /> 클라이언트가 Cache를 통해서 응답을 재사용할 수 있어야 하며, 이를 통해서 서버의 부하를 낮춘다.
    4. 계층화(Layered System) : 서버와 클라이언트 사이에, 방화벽, 게이트웨이, Proxy등 다양한 계층형태로 구성이 가능해야 하며, 이를 확장할 수 있어야한다.
    5. 인터페이스 일관성 : 인터페이스의 일관성을 지키고, 아키텍처를 단순화시켜 작은 단위로 분리하여, 클라이언트, 서버가 독립적으로 개선 될 수 있어야한다.
    6. Code on Demand(Optional) : 자바 애플릿, 자바스크립트, 플래시등 특정한 기능을 서버로부터 클라이언트가 전달받아 코드를 실행할 수 있어야한다.
  - 다음의 인터페이스 일관성이 잘 지켜졌는지에 따라, REST를 잘 사용했는지 판단을 할 수 있다.
    1. 자원의 식별
    2. 메시지를 통한 리소스 조작
    3. 자기 서술적 메세지
    4. 애플리케이션 상태에 대한 엔진으로써 하이퍼미디어

  - 자원의 식별
    * 웹 기반의 REST에서는 리소스 접근을 할때 URI를 사용합니다.
    * https://foo.co.kr/user/100
    * Resource : user
    * 식별자: 100
  - 메세지를 통한 리소스 조작
    * Web에서는 다양한 방식으로 데이터를 전달할 수 있습니다.
    * 그 중에서 가장 많이 사용하는 방식은 HTML, XML, JSON, TEXT등이 있습니다.
    * 이 중에서 어떠한 타입의 데이터인지를 알려주기 위해서 HTTP Header부분에 <br /> content-type을 통해서 데이터의 타입을 지정해 줄 수 있습니다.
    * 또한 리소스 조작을 위해서 데이터 전체를 전달하지 않고, 이를 메세지로 전달합니다.
    
    * Ex) 서버의 user라는 정보의 전화번호를 처음에는 number라고 결정했고, 이 정보를 Client와 주고 받을 때, 그대로 사용하고 있었다면, 후에 서버의 resource 변경으로 phone-number로 바뀌게 된다면 Client는 처리를 하지 못 하고 에러가 납니다.
    * 이러한 부분을 방지하기 위하여, 별도의 메세지의 형태로 데이터를 주고 받으며, client-server가 독립적으로 확장 가능하도록 합니다. 
  - 자기서술적 메세지
    * 요청하는 데이터가 어떻게 처리되어져야 하는지 충분한 데이터를 포함할 수 있어야한다.
    * HTTP기반의 REST에서는 HTTP Method와 Header정보, 그리고 URI의 포함되는 정보로 표현할 수 있습니다.
      * GET: https://foo.co.kr/user/100, 사용자의 정보 요청
      * POST: https://foo.co.kr/user, 사용자 정보 생성
      * PUT: https://foo.co.kr/user, 사용자 정보 생성 및 수정
      * DELETE: https://foo.co.kr/user/100, 사용자 정보 삭제
    * 그 외에 담지 못한 정보들은 URI의 메세지를 통하여, 표현한다.
  - Application 상태에 대한 엔진으로써 하이퍼미디어
    * REST API를 개발할때 단순히 Client요청에 대한 데이터만 응답해주는 것이 아닌 관련된 리소스에 대한 Link정보까지 같이 포함되어져야 한다.
    * 이러한 조건들을 잘 갖춘 경우 **RESTFUL**하다고 표현하고, 이를 REST API라고 부릅니다.

## URI 설계 패턴
  - URI(Uniform Resource Identifier)
    * 인터넷에서 특정자원을 나타내는 주소 값. 해당 값은 유일하다. (응답은 달라질 수 있다.)
    * 요청: https://github.com/SungbinYang/SpringStart/blob/main/web/
    * 응답: README.md, README.pdf
  - URL(Uniform Resource Locator)
    * 인터넷에서의 자원, 특정 파일이 어디에 위치하는지 식별하는 주소
    * 요청: https://github.com/SungbinYang/SpringStart/blob/main/web/README.md
    * **URL은 URI**의 하위 개념입니다.

  - URL 설계원칙 (RFC-3986)
    * 슬래시 구분자(/)는 계층관계를 나타내는데 사용한다.
      * https://github.com/SungbinYang/SpringStart/tree/main/web
    * URI 마지막 문자로 (/)는 포함하지 않는다.
      * https://github.com/SungbinYang/SpringStart/tree/main/web/
    * 하이픈(-)은 URI 가독성을 높이는데 사용한다.
      * https://github.com/SungbinYang/SpringStart/tree/main/web-master
    * 밑줄(_)은 사용하지 않는다.
      * https://github.com/SungbinYang/SpringStart/tree/main/web_master
    * URI경로에는 소문자가 적합하다.
      * https://github.com/SungbinYang/SpringStart/tree/main/WEB (X)
      * https://github.com/SungbinYang/SpringStart/tree/main/web (O)
    * 파일확장자는 URI에 포함하지 않는다.
      * https://github.com/SungbinYang/SpringStart/tree/main/web/README.md
    * 프로그래밍 언어에 의존적인 확장자를 사용하자 않는다.
      * https://github.com/SungbinYang/SpringStart/tree/main/web.do
    * 구현에 의존적인 경로를 사용하지 않는다.
      * https://github.com/servlet/classes/java/web-master
    * 세션ID를 포함하지 않는다.
      * https://github.com/SungbinYang/SpringStart/tree/main/web?session-id=abcdef
    * 프로그래밍 언어의 Method명을 이용하지 않는다.
      * https://github.com/SungbinYang/SpringStart/tree/main/web?action=intro
    * 명사에 단수형보다는 복수형을 사용해야 한다. 컬렉션에 대한 표현은 복수로 사용
      * https://github.com/SungbinYang/SpringStart/trees/main/web
    * 컨트롤러 이름으로는 동사나 동사구를 사용한다.
      * https://github.com/SungbinYang/SpringStart/tree/main/web/re-order
    * 경로 부분 중 변하는 부분은 유일한 값으로 대체한다.
      * https://github.com/SungbinYang/SpringStart/tree/main/web/lessons/{lesson-id}/users/{user-id}
      * https://github.com/SungbinYang/SpringStart/tree/main/web/2/users/100
    * CRUD 기능을 나태내는 것은 URI에 사용하지 않는다.
      * GET: https://github.com/SungbinYang/SpringStart/tree/main/web/lessons/2/users/100/READ (x)
      * DELETE: https://github.com/SungbinYang/SpringStart/tree/main/web/lessons/2/users/100 (O)
    * URI Query Parameter 디자인
      * URI 쿼리 부분으로 컬렉션 결과에 대해서 필터링 할 수 있다.
      * https://github.com/SungbinYang/SpringStart/tree/main/web?chapter=2
    * URI 쿼리는 컬렉션의 결과를 페이지로 구분하여 나타내는데 사용한다.
      * https://github.com/SungbinYang/SpringStart/tree/main/web?chapter=2&page=0&size=10&sort=asc
    * API에 있어서 서브 도메인은 일관성 있게 사용해야 한다.
      * https://github.com
      * https://api.github.com
      * https://api-github.com
    * 클라이언트 개발자 포탕 서브 도메인은 일관성 있게 만든다.
      * https://dev-github.com
      * https://developer-github.com

## HTTP Protocol
  - HTTP (Hyper Text Transfer Protocol)로 RFC 2616에서 규정된 web에서 데이터를 주고 받는 프로토콜
  - 이름에는 하이퍼텍스트 전송용 프로토콜로 정의되어 있지만 실제로는 HTML, XML, JSON, Image, Voice, Video, Javascript, PDF등 다양한 컴퓨터에서 다룰 수 있는것은 모두 전송할 수 있습니다.
  - HTTP는 TCP를 기반으로 한 REST의 특징을 모두 구현하고 있는 Web기반의 프로토콜
  - HTTP는 메시지를 주고 (Request) 받는 (Response) 형태의 통신 방법입니다.
  <img width="1171" alt="스크린샷 2021-08-08 오전 7 26 18" src="https://user-images.githubusercontent.com/18282470/128615273-a3a0cad8-ef01-4942-a751-7a488cb95805.png">
  - HTTP의 요청을 특정하는 Method는 8가지가 있습니다.
  - REST를 구현하기 위한 인터페이스니 알아둬야 합니다.
|종류|의미|CRUD|멱등성|안정성|Path Variable|Query Parameter|DataBody|
|---|---|---|---|---|---|---|---|
|GET|리소스 취득|R|O|O|O|O|X|
|POST|리소스 생성, 추가|C|X|X|O|△|O|
|PUT|리소스 갱신, 생성|C/U|O|X|O|△|O|
|DELETE|리소스 삭제|D|O|X|O|O|X|
|HEAD|헤더 데이터 취득|-|O|O|-|-|-|
|OPTIONS|지원하는 메소드 취득|-|O|-|-|-|-|
|TRACE|요청메시지 반환|-|O|-|-|-|-|
|CONNECT|프록시 동작의 터널 접속으로 변경|-|X|-|-|-|-|
