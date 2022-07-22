package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		
		driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
		logger.info("Switching to Ad frame 1");
		driver.switchTo().frame("ad_iframe");
		logger.info("Switching to Ad frame 2");
		driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();

		driver.switchTo().defaultContent();
		
		addcust.custName("Naina");
		addcust.custgender();
		addcust.custdob("01","01","1985");
		Thread.sleep(5000);
		addcust.custaddress("India");
		addcust.custcity("Bangalore");
		addcust.custstate("Karnataka");
		addcust.custpinno("560100");
		addcust.custtelephoneno("8074212835");
		
		String email = randomestring() +"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("test case passed");
		}
		else {
				logger.info("test case failed");
				captureScreen(driver, "addNewCustomer");
				Assert.assertTrue(false);
		}
		
	}

}
