package cn.tuyucheng.taketoday.testng.dependent;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class InheritedDependencyUnitTest extends SuperUnitTest {

    @Test(dependsOnMethods = "openBrowser")
    public void login() {
        log.info("Logged In");
    }
}