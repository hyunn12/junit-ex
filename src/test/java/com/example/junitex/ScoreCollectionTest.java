package com.example.junitex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ScoreCollectionTest {

    @Test
    @DisplayName("fail 을 이용한 의도적인 테스트 실패")
    void testFail() {
        fail("Not yet implemented");
    }

    @Test
    @DisplayName("arithmeticMean 2개 숫자메소드 테스트")
    void testArithmeticMean() {
        // 준비
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 5);
        collection.add(() -> 7);

        // 실행
        int actualResult = collection.arithmeticMean();

        // 단언
        assertThat(actualResult).isEqualTo(6);
        // 책에서는 Hamcrest.CoreMatchers.assertThat 을 사용했지만 나는 주로 Springboot를 사용하고 그에 포함된 spring-boot-starter-test 를 사용할 것이기 때문에 거기에 포함된 AssertJ를 사용해봄
        // AssertJ vs Hamcrest
    }

}