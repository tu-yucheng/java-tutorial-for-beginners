package cn.tuyucheng.taketoday.junit5vstestng;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SummationServiceUnitTest {
    private static List<Integer> numbers;

    @BeforeAll
    static void initialize() {
        numbers = new ArrayList<>();
    }

    @AfterAll
    static void tearDown() {
        numbers = null;
    }

    @BeforeEach
    void runBeforeEachTest() {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @AfterEach
    void runAfterEachTest() {
        numbers.clear();
    }

    @Test
    void givenNumbers_sumEquals_thenCorrect() {
        int sum = numbers.stream().reduce(0, Integer::sum);
        assertEquals(6, sum);
    }

    @Disabled
    @Test
    void givenEmptyList_sumEqualsZero_thenCorrect() {
        int sum = numbers.stream().reduce(0, Integer::sum);
        assertEquals(6, sum);
    }
}