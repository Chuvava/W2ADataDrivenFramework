package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class LoginTest extends TestBase {
	
	@Test
	public void LoginAsBankManager() throws InterruptedException {
		log.debug("Inside LoginTest");
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();;
		Thread.sleep(3500);
		
		log.debug("Successfully executed");
	}

}
