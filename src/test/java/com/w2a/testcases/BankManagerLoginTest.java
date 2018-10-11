package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase {
	
	@Test
	public void LoginAsBankManager() throws InterruptedException {
		log.debug("Inside LoginTest");
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();;
		Thread.sleep(3500);
		
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))),
				"Element: " + OR.getProperty("addCustBtn") + " is not displayed on the page");
		
		log.debug("Successfully executed");
	}

}
