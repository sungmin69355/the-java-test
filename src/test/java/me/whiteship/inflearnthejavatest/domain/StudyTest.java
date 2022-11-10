package me.whiteship.inflearnthejavatest.domain;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

class StudyTest {

    @Test
    void create() {
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create test")
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