package com.TestProduct.Testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.Utility.BaseClass;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws Exception {

		LoginPage lp = new LoginPage(driver);
		lp.login(Username, Password);
		
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.titleContains("Roles"));
		/*
		 * String newimg=BaseClass.Readcaptcha(); lp.captcha(newimg);
		 */

		System.out.println(driver.getTitle());

		if (driver.getTitle().contains("Roles")) {
			Assert.assertTrue(true);
			
		}

		else {
			screenshot(driver, "TC_LoginTest_001");
			Assert.assertTrue(false);
			

		}
	}

}
