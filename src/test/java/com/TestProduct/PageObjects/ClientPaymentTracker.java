package com.TestProduct.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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

public class ClientPaymentTracker extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;
	ScreenshotUtils screenshot;
	
	public ClientPaymentTracker(WebDriver ldriver) {

		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Common Tasks')]")
	@CacheLookup
	WebElement Commonsearch;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Client Payment Tracker ')]")
	@CacheLookup
	public WebElement PaymentTracker;

	@FindBy(how = How.XPATH, using = "//input[@name='txtclient']")
	@CacheLookup
	public WebElement clientName;

	@FindBy(how = How.XPATH, using = "//input[@name='ImgBntCalcFrom']")
	@CacheLookup
	public WebElement From;

	@FindBy(how = How.XPATH, using = "//input[@name='ImgBntCalcTo']")
	@CacheLookup
	public WebElement To;

	@FindBy(how = How.XPATH, using = "(//div[@class='ajax__calendar_footer ajax__calendar_today'])[1]")
	@CacheLookup
	public WebElement Fromdate;

	@FindBy(how = How.XPATH, using = "(//div[@class='ajax__calendar_footer ajax__calendar_today'])[2]")
	@CacheLookup
	public WebElement Todate;

	@FindBy(how = How.XPATH, using = "(//input[@type='checkbox'])[2]")
	@CacheLookup
	public WebElement isDraft;

	@FindBy(how = How.XPATH, using = "//input[@value='Search']")
	@CacheLookup
	public WebElement Search;

	@FindBy(how = How.XPATH, using = "(//input[@type='checkbox'])[4]")
	@CacheLookup
	public WebElement ClientCheckBox;

	@FindBy(how = How.XPATH, using = "//select[@name='ddlOption']")
	@CacheLookup
	public WebElement SelectAction;
	
	@FindBy(how = How.XPATH, using = "//input[@value='GO']")
	@CacheLookup
	public WebElement Go;

	@FindBy(how = How.XPATH, using = "(//input[@value='Close'])[3]")
	@CacheLookup
	public WebElement Close;
	
	@FindBy(how = How.XPATH, using = "//img[@id='imgPDFReportPreview']")
	@CacheLookup
	public WebElement Close2;
	
	

	public void tracker() {
		wait.until(ExpectedConditions.elementToBeClickable(Commonsearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(PaymentTracker)).click();
	}

	public void trackerInvoice(String a, String b) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(clientName)).sendKeys(a);
		
		List<WebElement> name = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
				By.xpath("(//div[@class='wordWheel listMain .box'])[1]"), 0));
		if(!name.isEmpty()) name.get(0).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(From)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Fromdate)).click();
		wait.until(ExpectedConditions.elementToBeClickable(To)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Todate)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Search)).click();
		
		scrollAndClick(ClientCheckBox);
		
		Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(SelectAction)));
		select.selectByVisibleText(b);
		
		scrollAndClick(Go);
		
		wait.until(ExpectedConditions.elementToBeClickable(Close)).click();
	}
	
	@SuppressWarnings("static-access")
	public void trackerinvoiceDraft(String a, String b) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(clientName)).sendKeys(a);
		
		List<WebElement> name = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
				By.xpath("(//div[@class='wordWheel listMain .box'])[1]"), 0));
		if(!name.isEmpty()) name.get(0).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(From)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Fromdate)).click();
		wait.until(ExpectedConditions.elementToBeClickable(To)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Todate)).click();
		wait.until(ExpectedConditions.elementToBeClickable(isDraft)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Search)).click();
		
		scrollAndClick(ClientCheckBox);
		
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(SelectAction)));
		select.selectByVisibleText(b);
		
		scrollAndClick(Go);
//		wait.until(ExpectedConditions.elementToBeClickable(Go)).click();
//SLeep		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(Close));
		screenshot.captureBeforeClick(driver, Close);
		Close.click();
	}
	
	@SuppressWarnings("static-access")
	public void bulk(String a, String b) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(clientName)).sendKeys(a);
		
		List<WebElement> name = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
				By.xpath("(//div[@class='wordWheel listMain .box'])[1]"), 0));
		if(!name.isEmpty()) name.get(0).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(From)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Fromdate)).click();
		wait.until(ExpectedConditions.elementToBeClickable(To)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Todate)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Search)).click();
		
		scrollAndClick(ClientCheckBox);
		
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(SelectAction)));
		select.selectByVisibleText(b);
		
		wait.until(ExpectedConditions.elementToBeClickable(Go)).click();
		
		screenshot.capturePageLoad(driver);
		
	}
	
}
