package com.TestProduct.PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class Batchsheet extends BaseClass{

	WebDriver driver;
	WebDriverWait wait;

	public Batchsheet(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Common Tasks')]")
	@CacheLookup
	public WebElement CommonSearch;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'BatchSheet')]")
	@CacheLookup
	public WebElement Batchsheet;

	@FindBy(how = How.XPATH, using = "//select[@name='ddlocation']")
	@CacheLookup
	public WebElement Designation;

	@FindBy(how = How.XPATH, using = "//input[@value='Show BatchSheet']")
	@CacheLookup
	public WebElement ShowBatchsheet;

	@FindBy(how = How.XPATH, using = "//input[@value='Generate New BatchSheet']")
	@CacheLookup
	public WebElement Generatebatch;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Ok')]")
	@CacheLookup
	public WebElement Okopopup;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'ReceiveBatch')]")
	@CacheLookup
	public WebElement ReceiveBatch;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Receive Batch')])[2]")
	@CacheLookup
	public WebElement ReceiveBatchtab;

	@FindBy(how = How.XPATH, using = "//input[@name='txtBatchNo']")
	@CacheLookup
	public WebElement BatchNo;

	@FindBy(how = How.XPATH, using = "//input[@value='submit']")
	@CacheLookup
	public WebElement submit;

	@FindBy(how = How.XPATH, using = "(//input[@type='checkbox'])[2]")
	@CacheLookup
	public WebElement Checkbox;

	@FindBy(how = How.XPATH, using = "//input[@value='Receive Batch']")
	@CacheLookup
	public WebElement ReceiveBatchbutton;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Visit Search')]")
	@CacheLookup
	public WebElement VisitSearch;

	@FindBy(how = How.XPATH, using = "//input[@name='txtFromVisit']")
	@CacheLookup
	public WebElement Fromvisit;

	@FindBy(how = How.XPATH, using = "//input[@name='txtToVisit']")
	@CacheLookup
	public WebElement Tovisit;

	@FindBy(how = How.XPATH, using = "//input[@name='txtPname']")
	@CacheLookup
	public WebElement Patientname;

	@FindBy(how = How.XPATH, using = "//input[@name='btnSearch']")
	@CacheLookup
	public WebElement Search;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Batch wise Enterresult')]")
	@CacheLookup
	public WebElement enterResult;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Batch wise Result Validation')]")
	@CacheLookup
	public WebElement resultValidation;

	@FindBy(how = How.XPATH, using = "//input[@name='txtFromVisitID']")
	@CacheLookup
	public WebElement batchfrom;

	@FindBy(how = How.XPATH, using = "//input[@name='txtToVisitID']")
	@CacheLookup
	public WebElement batchto;

	@FindBy(how = How.XPATH, using = "(//input[@value='Save'])[2]")
	@CacheLookup
	public WebElement save;

	@FindBy(how = How.XPATH, using = "//input[@value='Search']")
	@CacheLookup
	public WebElement SearchResult;

	@FindBy(how = How.XPATH, using = "(//textarea[@class='form-control element-with-border Details_SubHeading '])[1]")
	@CacheLookup
	WebElement ValueBox1;
	
	/*
	  @FindBy(how = How.XPATH, using = "")
	  @CacheLookup
	  public WebElement ;
	 */

	public void batch(String a, String b, String c) throws AWTException, InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(CommonSearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Batchsheet)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Fromvisit)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(Tovisit)).sendKeys(b);
		
		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(Designation)));
		s.selectByVisibleText(c);
		
//Sleep		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(ShowBatchsheet)).click();
		
		scrollAndClick(Generatebatch);
		
//		wait.until(ExpectedConditions.elementToBeClickable(Generatebatch)).click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo({top: 0, behavior: 'smooth'});");

	}

	public void receivebatch(String a) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(CommonSearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(ReceiveBatch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(ReceiveBatchtab)).click();
		wait.until(ExpectedConditions.elementToBeClickable(BatchNo)).click();
		wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Checkbox)).click();
		
		scrollAndClick(ReceiveBatchbutton);
		
		wait.until(ExpectedConditions.elementToBeClickable(Okopopup)).click();
	
	}

	public void batchwiseEnterResult(String a, String b, String c) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(CommonSearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(enterResult)).click();
		wait.until(ExpectedConditions.elementToBeClickable(batchfrom)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(batchto)).sendKeys(b);
		wait.until(ExpectedConditions.elementToBeClickable(SearchResult)).click();
		
		scrollAndSendKeys(ValueBox1, c);
		
		wait.until(ExpectedConditions.elementToBeClickable(save)).click();
		
	}

	public void batchwiseResultValidation(String a, String b) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(CommonSearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(resultValidation)).click();
		wait.until(ExpectedConditions.elementToBeClickable(batchfrom)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(batchto)).sendKeys(b);
		wait.until(ExpectedConditions.elementToBeClickable(SearchResult)).click();
		
		scrollAndClick(save);
		
	}
	
}
