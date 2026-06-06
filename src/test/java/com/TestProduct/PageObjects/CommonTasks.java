package com.TestProduct.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestProduct.Utility.BaseClass;

public class CommonTasks extends BaseClass{

	WebDriver driver;
	WebDriverWait wait;
	public CommonTasks(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Common Tasks')]")
	@CacheLookup
	WebElement CommonTask;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Registration Billing')]")
	@CacheLookup
	WebElement Rbilling;
	
	public void RegistrationBilling() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(CommonTask)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Rbilling)).click();
	}
	
	
}
