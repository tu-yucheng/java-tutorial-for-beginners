package cn.tuyucheng.taketoday.testng.dependent;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class MultipleDependentUnitTest {

    @Test
    public void openBrowser() {
        log.info("Opening The Browser");
    }

    @Test(dependsOnMethods = {"signIn", "openBrowser"})
    public void logout() {
        log.info("Logging Out");
    }

    @Test
    public void signIn() {
        log.info("Signing In");
    }
}