# Spring 프레임워크
 IoC 와 AOP를 지원하는 경량의 프레임워크 ( POJO를 의미 ) == 낮은 결합도, 높은 응집도 == 유지보수 용이
1. 개요
프레임 워크 == 골격 

-> 예시 ) 리모콘 : 리모콘을 만드는 메뉴얼 같은것을 정한다. 그러면 다음 개발자가 오더라도 메뉴 버튼을  어떻게 만드는지 메뉴얼이 있을 것이다.

2. 장점
(1). 유지보수 용이

(2). 개발자들의 기준이 정해짐 → 개발 시간단축, 비용절감 

(3). 개발자들의 가이드 라인으로 이정도는 해야된다라는 기준이 생김→ 개발자의 역량이 획일화 & 실력 상향 평준화

(4).  코드 재사용이 용이 (역량이 획일화 되기 때문)


# AOP 
AOP(Aspect Oriented Programming) 란 '관점 지향 프로그래밍'으로서 

개발 로직과 비즈니스 로직을 분리하여 관리하는 Spring 개념이다. 

즉, 공통 관심 사항과 핵심 관심 사항(코어 코드)을 분리하여 반복된 작업을 줄이는 Spring 개념입니다.

쉽게 설명하자면, 100개 함수가 처리해야 할 공통 기능 코드(예: 로깅) 들을 분리해 별도 Bean으로 관리하는 컨셉이다.
