package com.TestProduct.PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
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

public class VisitSearch extends BaseClass{

	WebDriver driver;
	WebDriverWait wait;
	ScreenshotUtils screenshot;
	public VisitSearch(WebDriver ldriver) {
		
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
	
	@FindBy(how = How.XPATH, using = "//input[@name='txtPatientNumber']")
	@CacheLookup
	public WebElement PatientVID;
	
	@FindBy(how = How.XPATH, using = "(//input[@value='Search'])[1]")
	@CacheLookup
	public WebElement Search;
	
	@FindBy(how = How.XPATH, using = "//table[@class='table table-striped grdrslt table-sm']//tbody/tr[1]")
	@CacheLookup
	public WebElement grid;
	
	@FindBy(how = How.XPATH, using = "//table[@class='table table-striped grdrslt table-sm']//tbody/tr[2]/td[1]")
	@CacheLookup
	public WebElement radio;
	
	@FindBy(how = How.XPATH, using = "//select[@name='ddlVisitActionName']")
	@CacheLookup
	public WebElement dropdown;
	
	@FindBy(how = How.XPATH, using = "(//input[@value='Go'])[2]")
	@CacheLookup
	public WebElement Go;
	
	@FindBy(how = How.XPATH, using = "//select[@name='ddSalutation']")
	@CacheLookup
	public WebElement Salutation;
	
	@FindBy(how = How.XPATH, using = "//input[@name='txtName']")
	@CacheLookup
	public WebElement PName;
	
	@FindBy(how = How.XPATH, using = "//input[@name='txtDOBNos']")
	@CacheLookup
	public WebElement Age;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Update']")
	@CacheLookup
	public WebElement Update;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Ok')]")
	@CacheLookup
	public WebElement Okpopup;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Back']")
	@CacheLookup
	public WebElement Back;
	
	@FindBy(how = How.XPATH, using = "//table[@class='table table-striped grdrslt table-sm']//tbody/tr[2]/td[16]")
	@CacheLookup
	public WebElement ViewBill;
	
	@FindBy(how = How.XPATH, using = "(//input[@value='Close'])[1]")
	@CacheLookup
	public WebElement closeBill;
	
/*	@FindBy(how = How.XPATH, using = "")
	@CacheLookup
	public WebElement ; */
	
	@SuppressWarnings("static-access")
	public void visit(String a) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(CommonSearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(VisitSearch)).click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(Patientname)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(Search)).click();
		
		Thread.sleep(3000);
		scrollAndClick(radio);
		screenshot.captureBeforeClick(driver, radio);
		
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	@SuppressWarnings("static-access")
	public void viewbill() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(ViewBill)).click();
		Thread.sleep(3000);
		screenshot.captureScreenshot(driver);
		wait.until(ExpectedConditions.elementToBeClickable(closeBill)).click();
	}
	
	public void scrolldown2() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void patientdemography(String a, String b, String c, String d) throws InterruptedException {
		
		scrollAndClick(radio);
		
		Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(dropdown)));
		select.selectByVisibleText(a);
		
		wait.until(ExpectedConditions.elementToBeClickable(Go)).click();
		
		Select select1 = new Select(wait.until(ExpectedConditions.elementToBeClickable(Salutation)));
		select1.selectByVisibleText(b);
		
		wait.until(ExpectedConditions.elementToBeClickable(PName)).click();
		wait.until(ExpectedConditions.elementToBeClickable(PName)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(PName)).sendKeys(c);
		
		wait.until(ExpectedConditions.elementToBeClickable(Age)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Age)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(Age)).sendKeys(d);
		
		wait.until(ExpectedConditions.elementToBeClickable(Update)).click();
		
		driver.switchTo().alert().accept();
		
		wait.until(ExpectedConditions.elementToBeClickable(Okpopup)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Back)).click();
	}
	
}
