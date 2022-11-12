package me.whiteship.inflearnthejavatest.domain;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) // _를 공백으로 치환해주는 설정 잘 사용x
class StudyTest {

    @DisplayName("생성") //테스트이름설정 이모지도 가능
    @Test
    void create_study() {
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create test");
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