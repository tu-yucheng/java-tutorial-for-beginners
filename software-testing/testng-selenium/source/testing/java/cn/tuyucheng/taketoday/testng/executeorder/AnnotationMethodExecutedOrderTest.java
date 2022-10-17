package cn.tuyucheng.taketoday.testng.executeorder;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.*;

@Slf4j
public class AnnotationMethodExecutedOrderTest {

    @Test
    public void simple_testng_testcase_1() {
        log.info("5. test method 1");
    }

    @BeforeMethod
    public void beforeMethod() {
        log.info("4. beforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        log.info("6. afterMethod");
    }

    @BeforeClass
    public void beforeClass() {
        log.info("3. beforeClass");
    }

    @AfterClass
    public void afterClass() {
        log.info("7. afterClass");
    }

    @BeforeTest
    public void beforeTest() {
        log.info("2. beforeTest");
    }

    @AfterTest
    public void afterTest() {
        log.info("8. afterTest");
    }

    @BeforeSuite
    public void beforeSuite() {
        log.info("1. beforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        log.info("9. afterSuite");
    }
}