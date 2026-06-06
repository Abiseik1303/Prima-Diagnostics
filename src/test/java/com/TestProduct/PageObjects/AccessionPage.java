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
import com.TestProduct.Utility.ScreenshotUtils;


public class AccessionPage extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	public AccessionPage(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "uctlTaskList_txttext")
	@CacheLookup
	WebElement Name;

	@FindBy(name = "uctlTaskList$btn_Go")
	@CacheLookup
	WebElement go;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Common Tasks')]")
	@CacheLookup
	public WebElement CommonSearch;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'ReceiveSample')]")
	@CacheLookup
	public WebElement ReceiveSample;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Sample Search')]")
	@CacheLookup
	WebElement Samplesearch;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Sample Transfer')]")
	@CacheLookup
	public WebElement SampleTransfer;
	
	@FindBy(how = How.XPATH, using = "//input[@name='txtPatientName']")
	@CacheLookup
	public WebElement patientname;
	
	@FindBy(how = How.XPATH, using = "//input[@name='btnFinish']")
	@CacheLookup
	public WebElement Search;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Search']")
	@CacheLookup
	public WebElement SearchTrans;
	
	@FindBy(how = How.XPATH, using = "//input[@name='btnSubmit']")
	@CacheLookup
	public WebElement Save;

	@FindBy(how = How.ID, using = "btnFinish")
	@CacheLookup
	WebElement Gworkorder;
	
	@FindBy(xpath = "//input[@name='BtnClosePkgItemDetail']")
	@CacheLookup
	WebElement Barcodeclose;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	@CacheLookup
	WebElement Checkbox;
	
	@FindBy(xpath = "//select[@name='ddltransferloc']")
	@CacheLookup
	WebElement locationTransfer;
	
	@FindBy(xpath = "//input[@value='Transfer Sample']")
	@CacheLookup
	WebElement TransferSample;
	
	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	@CacheLookup
	WebElement Okpopup;
	
	
	
/*	@FindBy(xpath = "")
	@CacheLookup
	WebElement ;    */
	
	

	public void samplesearch() {
		wait.until(ExpectedConditions.elementToBeClickable(CommonSearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Samplesearch)).click();
	}

	public void receicesample(String a) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(CommonSearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(ReceiveSample)).click();
		wait.until(ExpectedConditions.elementToBeClickable(patientname)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(Search)).click();
		
		
		scrollAndClick(Save);
		
//Sleep		
		
//		Thread.sleep(2000);	
//		wait.until(ExpectedConditions.elementToBeClickable(Barcodeclose)).click();
//		Thread.sleep(2000);	
	}
	
	public void receicesamplewhitefield(String a) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(CommonSearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(ReceiveSample)).click();
		wait.until(ExpectedConditions.elementToBeClickable(patientname)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(Search)).click();
		
		scrollAndClick(Save);
	}
	
	public void transfer(String a, String b) throws InterruptedException, AWTException {
	
		wait.until(ExpectedConditions.elementToBeClickable(CommonSearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(SampleTransfer)).click();
		wait.until(ExpectedConditions.elementToBeClickable(patientname)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(SearchTrans)).click();
		
		Thread.sleep(2000);
		scrollAndClick(Checkbox);
		
		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(locationTransfer)));
		s.selectByVisibleText(b);
		
		scrollAndClick(TransferSample);
//		wait.until(ExpectedConditions.elementToBeClickable(TransferSample)).click();
		
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
}
