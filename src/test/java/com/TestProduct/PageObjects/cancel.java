package com.TestProduct.PageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.ScreenshotUtils;

public class cancel extends BaseClass{

	WebDriver driver;
	WebDriverWait wait;
	ScreenshotUtils screenshot;
	
	public cancel(WebDriver ldriver) {
		
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Common Tasks')]")
	@CacheLookup
	public WebElement CommonSearch;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Bill Search')]")
	@CacheLookup
	public WebElement Billsearch;
	
	@FindBy(how = How.XPATH, using = "//input[@name='uctrlBillSearch$txtPatientName']")
	@CacheLookup
	public WebElement Patientname;
	
	@FindBy(how = How.XPATH, using = "//input[@name='uctrlBillSearch$btnSearch']")
	@CacheLookup
	public WebElement Search;
	
	@FindBy(how = How.XPATH, using = "//select[@name='dList']")
	@CacheLookup
	public WebElement dropdown;
	
	@FindBy(how = How.XPATH, using = "//input[@name='bGo']")
	@CacheLookup
	public WebElement Go;
	
	@FindBy(how = How.XPATH, using = "(//input[@type='checkbox'])[2]")
	@CacheLookup
	public WebElement checkBox;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	@CacheLookup
	public WebElement submit;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Close']")
	@CacheLookup
	public WebElement Close;
	
	@FindBy(how = How.XPATH, using = "//button[@id='okbtnid']")
	@CacheLookup
	public WebElement Ok;
	
    @FindBy(how = How.XPATH, using = "(//input[@type='radio'])[3]")
	@CacheLookup
	public WebElement Radio; 
    
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Amount Details')]")
	@CacheLookup
	public WebElement AmountDetails; 
    
  
    
    public void billsearch() throws InterruptedException {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(CommonSearch)).click();
    	wait.until(ExpectedConditions.elementToBeClickable(Billsearch)).click();
    		
    }
	
	@SuppressWarnings("static-access")
	public void cancel1(String a, String b) throws InterruptedException {
		
		scrollAndClick(Patientname);
		
		wait.until(ExpectedConditions.elementToBeClickable(Patientname)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(Search)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Radio)).click();
		
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(dropdown)));
		select.selectByVisibleText(b);
		
		wait.until(ExpectedConditions.elementToBeClickable(Go)).click();
		
		scrollAndClick(checkBox);
		scrollAndClick(submit);
		
//		driver.switchTo().alert().accept();
		handleAlertIfPresent();
		
		screenshot.capturePageLoad(driver);
	}
	
}
