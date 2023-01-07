package com.example.junitex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProfileTest {

    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    // 모든 테스트마다 중복해서 들어가는 설정을 @BeforeEach를 이용해 한번에 적용할 수 있도록 함
    // 책에서는 JUnit4를 이용했기때문에 @BeforeEach가 아닌 @Before 가 사용되어 JUnit5로 변경해 테스트함
    @BeforeEach
    void create() {
        profile = new Profile("TESTER");
        question = new BooleanQuestion(1, "Got bonuses?");
        criteria = new Criteria();
    }
    // @BeforeEach vs @BeforeAll
    // @BeforeAll: 한 테스트클래스 자체를 실행 시에 처음 딱 한번만 실행
    //      비용이 많이 드는 초기 설정에 이용하면 좋음
    //      초기 한번만 실행되므로 static 메소드여야함
    // @BeforeEach: 한 테스트 클래스 내의 각 메소드가 실행될 때마다 매번 먼저 실행됨


    @Test
    @DisplayName("matches 메소드 동작 검증 테스트")
    void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
        profile.add(new Answer(question, Bool.FALSE));

        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));

        boolean matches = profile.matches(criteria);

        assertThat(matches).isFalse();
    }

    @Test
    @DisplayName("matches 메소드 테스트 Criteria 상관X")
    void matchAnswersTrueForAnyDontCareCriteria() {
        profile.add(new Answer(question, Bool.FALSE));

        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));

        boolean matches = profile.matches(criteria);

        assertThat(matches).isTrue();
    }

}