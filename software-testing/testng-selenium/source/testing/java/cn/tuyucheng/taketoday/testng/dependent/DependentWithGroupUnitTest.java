package cn.tuyucheng.taketoday.testng.dependent;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class DependentWithGroupUnitTest {

    @Test(dependsOnGroups = {"SignIn"})
    public void viewAcc() {
        log.info("SignIn Successful");
    }

    @Test(groups = {"SignIn"})
    public void login() {
        log.info("Logging In Success");
    }
}