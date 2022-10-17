package cn.tuyucheng.taketoday.testng.suite;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class SecondTestNGUnitTest {

    @BeforeMethod
    public void setUp() {
        log.info("before test case executing...");
    }

    @Test
    public void simple_testng_case() {
        log.info("executing the testng test case");
    }

    @AfterMethod
    public void tearDown() {
        log.info("after test case executing...");
    }
}