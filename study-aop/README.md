# AOP (작성중)

## 실행
```
mvn test
```

#### 결과
```
INFO [main] kr.geun.o.hwp.app.config.ExecTimeAspect  : void kr.geun.o.hwp.app.service.RunCheckService.check() executed in 1009ms
```

## 사용될만한 곳
- 성능측정
- 트랜잭션 처리 관련
- 로그처리
- ....

## lib 
#### pom.xml
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

## 용어
#### 구성요소
- JoinPoint: 모듈의 기능이 삽입되어 동작할 수 있는 실행 가능한 특정 위치
- PointCut: 어떤 클래스의 어느 JoinPoint를 사용할 것인지를 결정
- Advice: 각 JoinPoint에 삽입되어져 동작할 수 있는 코드
- Interceptor: InterceptorChain 방식의 AOP 툴에서 사용하는 용어로 주로 한개의 호출 메소드를 가지는 Advice
- Weaving: PointCut에 의해서 결정된 JoinPoint에 지정된 Advice를 삽입하는 과정(CrossCutting)
- Introduction: 정적인 방식의 AOP 기술
- Aspect: PointCut + Advice + (Introduction)

#### Target 관련 용어
###### @Before : 이전
- 메소드가 호출되기 전에 수행

###### @Around
- **타깃메소드가 호출되기 위해서는 proceed() 메소드가 호출해야 합니다.**
```
proceedingJoinPoint.proceed();
```


## 참고링크
- https://heowc.github.io/2018/02/07/spring-boot-aop/
- https://yookeun.github.io/java/2014/10/01/spring-aop/
- https://jojoldu.tistory.com/71
- http://addio3305.tistory.com/86
- https://www.journaldev.com/2583/spring-aop-example-tutorial-aspect-advice-pointcut-joinpoint-annotations
- https://www.baeldung.com/spring-aop-annotation
