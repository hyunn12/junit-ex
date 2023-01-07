package com.example.junitex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ScoreCollectionTest {

    // JUnit5 부터는 메소드의 앞에 접근제한자를 꼭 명시하지 않아도됨

    // 테스트 메소드를 명명할 땐 정확히 어떤 테스트인지 명시하는 것이 중요함
    // 하지만 영어로 지으면 바로 내용을 이해하기 어렵기 때문에 아래처럼 @DisplayName 을 이용해 한 눈에 어떤 테스트인지 알아보기 쉽게 할 수 있음

    @Test
    @DisplayName("fail 을 이용한 의도적인 테스트 실패")
    void testFail() {
        fail("Not yet implemented");
        // fail을 사용하면 무조건 테스트가 실패하는데 어떨 때 쓰는건데?
        // 참고: https://www.baeldung.com/junit-fail
        // 1. 아직 테스트코드가 덜짜여진 경우
        // 2. 테스트가 실패할 것 같을 때 예외가 발생할 것 같은 부분에서 바로 실패시키려는 경우
        // 3. 결과값이 원하는 값이 아닌 경우
    }

    @Test
    @DisplayName("arithmeticMean 2개 숫자메소드 테스트")
    void testArithmeticMean() {
        // 준비 Arrange
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 5);
        collection.add(() -> 7);

        // 실행 Act
        int actualResult = collection.arithmeticMean();

        // 단언 Assert
        assertThat(actualResult).isEqualTo(6);
        // 책에서는 Hamcrest.CoreMatchers.assertThat 을 사용했지만 나는 주로 Springboot를 사용하고 그에 포함된 spring-boot-starter-test 를 사용할 것이기 때문에 거기에 포함된 AssertJ를 사용해봄
        // AssertJ vs Hamcrest
    }

}