package cn.tuyucheng.taketoday.testng.dependent;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class GroupDependentUnitTest {

    @Test(dependsOnGroups = "signIn")
    public void viewAcc() {
        log.info("View Your Dashboard");
    }

    @Test(groups = "signIn")
    public void openBrowser() {
        log.info("Browser Opened Successfully");
    }

    @Test(groups = "signIn")
    public void test_login() {
        log.info("Login Into The Account");
    }
}