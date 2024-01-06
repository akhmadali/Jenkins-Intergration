package com.inetbanking.testCases;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_AddCustomer_003 extends BaseClass{

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {

        LoginPage lp = new LoginPage(driver);
        lp.setUsername(username);
        lp.setPassword(password);
        lp.clickSubmit();

        Thread.sleep(3000);

        AddCustomerPage addcust = new AddCustomerPage(driver);
        addcust.clickAddNewCustomer();
        logger.info("Providing customer details...");

        addcust.custName("Ali");
        logger.info("Providing customer name...");
        addcust.custgender("male");
        logger.info("Providing customer gender...");
        addcust.custdob("10", "10", "2000");
        Thread.sleep(3000);
        addcust.custaddress("USA");
        addcust.custcity("Austin");
        addcust.custstate("TX");
        addcust.custpinno("78717");
        addcust.custtelephoneno("1233456677");
        String email = randomString()+"@gmail.com";
        addcust.custemailid(email);
        addcust.custpassword("abcdef");
        addcust.custsubmit();

        Thread.sleep(3000);

        boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

        if(res==true){
            Assert.assertTrue(true);
        } else {
            captureScreen(driver, "addNewCustomer");
            Assert.assertTrue(false);
        }

    }

}
