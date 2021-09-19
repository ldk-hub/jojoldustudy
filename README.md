# jojoldustudy
코스콤 공부스터디





## 교육시작 파트


### 실습 개발 환경(윈도우 10 환경 기반)   
👉 Java 8: https://url.kr/cwye6a  
👉 Git: https://url.kr/mcid4e  
👉 SourceTree: https://url.kr/x86k4e  
👉 IntelliJ Ultimate: https://url.kr/kboymj  
     Ultimate 은 유료버전이지만, 처음 사용할 경우 한달간 무료가 지원되니 유료 버전을 설치하면 됩니다.  
     만약 유료 버전 설치가 잘 안된다면 무료 버전인 Community를 설치하면 됩니다.  
👉 putty: https://url.kr/azowp7  
     원격 리눅스 서버로 SSH 접근이 가능한 방법은 아무것이나 가능합니다.  

네이버 로그인 기능이 추가되면
네이버에서는 로긍니 요청이 온 서비스가 미리 쓰겠다고 등록한 사이트인지검증


   

1. 인텔리제이 사용계기
msa, 멀티모듈 레포, 독립된 nosql, 넷플릭스 api 들은 별개문제

 - 스프링부트 팁
그레이들 추천 공부, 코틀린추천  
jar로 배포추천 -> java -jar jar명 내장톰캣사용  추천 war보다 좋음  
클라우드 네이티브 -> 도커때문에 이와같이쓴다함.  
마리아db 드라이버 -> 기능상같음  

aws에서는  mysql -> azure는 postgresql  
aws 오로라 -> 위DB만 지원  

@Transctional(readOnly = )


세션 : 서버영역에서 저장
쿠키 : 클라이언트 영역에서 저장

쿠키가 저장되지 않는 특별한 브라우저에서 접속하면 세션은 사용할 수 있을까요?
- > NO (JWT는 다른얘기)
쿠키 & 세션 로그인 방식에서는 특별한 브라우저에서는 로그인 X

사용자가 HTTP Request => Body & Param & Header
Request Header (쿠키: (세션Key))

쿠키로 넘어온 세션 Key(key: JESSIONID / value : 78123kadzxca)
HttpSession에서는 ("user", "JESSIONID") / (78123kadzxcz, 세션정보)

쿠키에 있는 세션 Key가 무엇인지 세션에서는 "user"에 매칭되는 세션키 이름이 무엇인지 

** 그레이들
```
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'com.h2database:h2'
	runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
```


### tdd먼저 작성
내사이트
=>(내사이트가 리다이렉트) 네이버사이트로 이동
=>네이버 로그인이 성공하면
=>(네이버가 리다이렉트시켜줌) 내사이트의 어느 주소???

OAuth Token / 



1. 한서비스 죽으면 처리 -> 비즈니스 오류발생 -> 특정모듈만에러발생
2. 오류 처리발생-> 서비스오류 우회로직 서비스 ->

책 추천
마이크로서비스 도입 이렇게 한다.


2. 프론트서버의 사실과 오해
tps - 15000 -> 웹플럭스 구조 

2챕터 - TDD 

3챕터 - jpa


8장 시큐리티 부터
