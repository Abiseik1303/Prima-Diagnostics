package com.TestProduct.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.TestProduct.Utility.BaseClass;



public class LoginPage extends BaseClass{
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "txtUserName")
	@CacheLookup
	WebElement UserName;

	@FindBy(name = "txtPassword")
	@CacheLookup
	WebElement Password;

	@FindBy(id = "imgGo1")
	@CacheLookup
	WebElement loginbutton;

	@FindBy(id = "Image2")
	@CacheLookup
	WebElement captcha;

	@FindBy
	@CacheLookup
	WebElement captchabox;

	public void login(String name, String password) {
		
		wait.until(ExpectedConditions.elementToBeClickable(UserName)).sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(Password)).sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(loginbutton)).click();
		
		
	}
	

//	public void captcha(String capimg) throws TesseractException {
//		captchabox.click();
//		captchabox.sendKeys(capimg);
//        loginbutton.click();
//	}

}
