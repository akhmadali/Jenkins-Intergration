package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {


    @Test
    public void loginTest() throws IOException {

        logger.info("Url is opened");

        LoginPage lp = new LoginPage(driver);
        lp.setUsername(username);
        logger.info("Entered username");
        lp.setPassword(password);
        logger.info("Entered password");
        lp.clickSubmit();
        if(driver.getTitle().equals("Guru99 Bank Manager HomePage123")){
            Assert.assertTrue(true);
            logger.info("Login test passed");
        }else{
            captureScreen(driver, "loginTest");
            Assert.assertTrue(false);
            logger.info("Login test failed");
        }


    }
}
