package me.whiteship.inflearnthejavatest.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) // _를 공백으로 치환해주는 설정 잘 사용x
class StudyTest {

    @DisplayName("스터디 만들기") //테스트이름설정 이모지도 가능
    @Test
    void create_study() {
        Study study = new Study();
        assertNotNull(study);
        assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT여야 합니다.");
    }

    @DisplayName("로컬인 경우만 테스트") //테스트이름설정 이모지도 가능
    @Test
    @EnabledOnOs({OS.MAC, OS.LINUX}) // 특정 OS설정가능
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_11}) // 특정 자바버젼도 가능
    @SlowTest
    void 로컬_테스트() {
        assumeTrue("LOCAL".equalsIgnoreCase(System.getenv("TEST_ENV"))); //TEST_ENV 환경변수가 LOCAL일 경우 만 True
        // false이면 여기 실행 x
        assumingThat("LOCAL".equalsIgnoreCase(System.getenv("TEST_ENV")), () -> {
            Study actual = new Study(100);
            assertEquals(actual.getLimitCount(), 100);
        });
    }

    @DisplayName("스터디 인원테스트")
    @Test
    @FastTest
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