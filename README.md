# 자바와 JUnit을 활용한 실용주의 단위 테스트 연습코드

### 사용 기술
- Java 17
- JUnit5


## 1. JUnit 테스트 만들기
[ScoreCollectionTest](./src/test/java/com/example/junitex/ScoreCollectionTest.java)

### `Assertions.fail()`
강제로 테스트를 실패시킴

#### 사용하는 이유?

참고: https://www.baeldung.com/junit-fail

 1. 아직 테스트코드가 덜짜여진 경우
 2. 테스트가 실패할 것 같을 때 예외가 발생할 것 같은 부분에서 바로 실패시키려는 경우
 3. 결과값이 원하는 값이 아닌 경우

----

### Hamcrest vs AssertJ
- Hamcrest : `assertThat(T actual, Matcher<? super T> matcher)`
- AssertJ : `assertThat(T actual)`

#### AssertJ를 더 권장하는 이유?
- Hamcrest 는 사용할 Matcher 를 외워서 맞춰서 사용해야함 
- AssertJ 는 체이닝 방식을 사용해서 `asserThat().isEqualTo()` 처럼 사용해 좀 더 작관적으로 표현가능
- SpringBoot 사용 시 `spring-boot-starter-test` 를 주로 사용하는데 여기에 AssertJ가 포함되어있어 따로 라이브러리를 포함할 필요가 없음

