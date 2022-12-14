package cn.tuyucheng.taketoday;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LiveTest {

    private final List<String> in = new ArrayList<>(Arrays.asList("Hello", "Yes", "No"));
    private final List<String> out = new ArrayList<>(Arrays.asList("你好", "是", "否"));

    @TestFactory
    Stream<DynamicTest> translateDynamicTestsFromStream() {

        return in.stream()
                .map(word -> DynamicTest.dynamicTest("Test translate " + word, () -> {
                    int id = in.indexOf(word);
                    assertEquals(out.get(id), translate(word));
                }));
    }

    private String translate(String word) {
        if ("Hello".equalsIgnoreCase(word)) {
            return "你好";
        } else if ("Yes".equalsIgnoreCase(word)) {
            return "是";
        } else if ("No".equalsIgnoreCase(word)) {
            return "否";
        }
        return "Error";
    }
}