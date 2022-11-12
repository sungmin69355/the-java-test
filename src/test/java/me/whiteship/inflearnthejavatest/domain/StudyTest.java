package me.whiteship.inflearnthejavatest.domain;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) // _를 공백으로 치환해주는 설정 잘 사용x
class StudyTest {

    @DisplayName("스터디 만들기") //테스트이름설정 이모지도 가능
    @Test
    void create_study() {
        Study study = new Study();
        assertNotNull(study);
        assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT여야 합니다.");
    }
    @DisplayName("스터디 인원테스트")
    @Test
    void 스터디의_limit는_0보다_커야한다() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        assertEquals("limit은 0보다 커야 한다.", exception.getMessage());
    }

    //static으로 만들자! 리턴타입이있으면안되고, private도 안된다.
    @BeforeAll
    static void beforeAll(){
        System.out.println("before all");
    }

    //static으로 만들자! 리턴타입이있으면안되고, private도 안된다.
    @AfterAll
    static void afterAll(){
        System.out.println("after all");
    }

    // static일 필요 x
    @BeforeEach
    void beforeEach(){
        System.out.println("before each");
    }

    // static일 필요 x
    @AfterEach
    void afterEach(){
        System.out.println("after each");
    }
}