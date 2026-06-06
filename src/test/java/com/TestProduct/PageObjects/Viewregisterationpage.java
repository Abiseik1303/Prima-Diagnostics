package com.TestProduct.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.ScreenshotUtils;



public class Viewregisterationpage extends BaseClass {
	
	WebDriver driver;
	WebDriverWait wait;
	ScreenshotUtils screenshot;
	
	public Viewregisterationpage(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Common Tasks')]")
	@CacheLookup
	public WebElement CommonSearch;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Visit Search')]")
	@CacheLookup
	public WebElement VisitSearch;
	
	@FindBy(how = How.XPATH, using = "//input[@name='txtPname']")
	@CacheLookup
	public WebElement Patientname;
	
	@FindBy(how= How.XPATH, using="//li[contains(text(),'View Registration')]")
	@CacheLookup
	WebElement view;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Visit Number']")
	@CacheLookup
	WebElement visitnumberfield;
	
	@FindBy(how = How.XPATH, using = "//table[@class='table table-striped grdrslt table-sm']//tbody/tr[2]/td[4]")
	@CacheLookup
	public WebElement VisitNumber;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Search']")
	@CacheLookup
	WebElement Search;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Audit History')]")
	@CacheLookup
	WebElement AuditTab;
	
	@FindBy(how = How.XPATH, using = "(//input[@value='Go'])[2]")
	@CacheLookup
	WebElement Go;
	
	
	
/*	@FindBy(how = How.XPATH, using = "")
	@CacheLookup
	WebElement ;  */
	
	public String visitnumber() {
		String Batch = driver.findElement(By.xpath("//table[@class='table table-striped grdrslt table-sm']//tbody/tr[2]/td[4]")).getText();
	    System.out.println(Batch);
		return Batch;	
	}
	
	public void ViewRegistration(String no) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(CommonSearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(view)).click();
		wait.until(ExpectedConditions.elementToBeClickable(visitnumberfield)).sendKeys(no);
		wait.until(ExpectedConditions.elementToBeClickable(Search)).click();
		wait.until(ExpectedConditions.elementToBeClickable(AuditTab)).click();
		screenshot.capturePageLoad(driver);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}
	
	public void scrolldown2() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
}
