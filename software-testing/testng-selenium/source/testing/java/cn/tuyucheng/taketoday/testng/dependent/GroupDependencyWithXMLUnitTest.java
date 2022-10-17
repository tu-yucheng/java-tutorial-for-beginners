package cn.tuyucheng.taketoday.testng.dependent;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class GroupDependencyWithXMLUnitTest {

    @Test(groups = {"viewacc"})
    public void viewAcc() {
        log.info("View Your Dashboard");
    }

    @Test(groups = {"openbrowser"})
    public void openBrowser() {
        log.info("Browser Opened Successfully");
    }

    @Test(groups = {"login"})
    public void login() {
        log.info("Login Into The Account");
    }

    @Test(groups = {"logout"})
    public void closeAccount() {
        log.info("Closing The Account");
    }
}