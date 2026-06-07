package com.TestProduct.PageObjects;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;
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

public class PhelebotomistPage extends BaseClass{
	WebDriver driver;
	WebDriverWait wait;
	ScreenshotUtils screenshot;

	public PhelebotomistPage(WebDriver ldriver) {
		this.driver = ldriver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Common Tasks')]")
	@CacheLookup
	WebElement Commonsearch;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Investigation Search')]")
	@CacheLookup
	public WebElement Investigationsearch;

	@FindBy(id = "uctlTaskList_txttext")
	@CacheLookup
	WebElement Name;

	@FindBy(name = "uctlTaskList$btn_Go")
	@CacheLookup
	WebElement go;

	@FindBy(how = How.XPATH, using = "//div[@headerindex='0h']")
	@CacheLookup
	WebElement common;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Sample Search ')]")
	@CacheLookup
	WebElement Samplesearch;

	@FindBy(how = How.ID, using = "btnFinish")
	@CacheLookup
	WebElement Gworkorder;

	@FindBy(how = How.XPATH, using = "(//select[@title='Select Sample Status'])[2]")
	@CacheLookup
	WebElement SampleStatus;

	@FindBy(xpath = "(//input[@value='Close'])[6]")
	@CacheLookup
	WebElement Barcodeclose;
	
	@FindBy(how = How.XPATH, using = "(//select[@title='Select Reason'])[2]")
	@CacheLookup
	WebElement SampleReason;
	
	@FindBy(how = How.XPATH, using = "//input[@name='txtPatientName']")
	@CacheLookup
	WebElement PatientName;
	
	@FindBy(how = How.XPATH, using = "//input[@name='btnSearch']")
	@CacheLookup
	WebElement search;
	
	@FindBy(how = How.XPATH, using = "(//input[@type='radio'])[3]")
	@CacheLookup
	WebElement radio;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Go']")
	@CacheLookup
	WebElement ClickGo;
	
	@FindBy(how = How.XPATH, using = "//input[@name='txtPatientName']")
	@CacheLookup
	WebElement PatientNameSampleSearch;
	
	@FindBy(how = How.XPATH, using = "//input[@id='chkAberrant']")
	@CacheLookup
	WebElement AbberentCheckBox;
	
	@FindBy(how = How.XPATH, using = "//select[@name='ddlSampleStatus']")
	@CacheLookup
	WebElement AbberentStatus;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Search']")
	@CacheLookup
	WebElement AbberentSearch;
	
	@FindBy(how = How.XPATH, using = "(//input[@type='checkbox'])[5]")
	@CacheLookup
	WebElement CheckboxNot;
	
	@FindBy(how = How.XPATH, using = "//select[@name='ddlAction']")
	@CacheLookup
	WebElement AbberentsampleCollection;
	
	@FindBy(how = How.XPATH, using = "(//input[@value='OK'])[4]")
	@CacheLookup
	WebElement AbberentOk;
	
	@FindBy(how = How.XPATH, using = "//input[@id='chkAberrant']")
	@CacheLookup
	WebElement CheckBox;
	
	
	public void Investigationsearch() {
		
		wait.until(ExpectedConditions.elementToBeClickable(Commonsearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Investigationsearch)).click();
		
	}

	public void patientname(String name) throws Exception {
		
		wait.until(ExpectedConditions.elementToBeClickable(Name)).sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(go)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Gworkorder)).click();
		
		// Thread.sleep(3000);
		// Barcodeclose.click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);

		Thread.sleep(5000);
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window ID: " + parentWindow);
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("Allwindow ID: " + allWindows);
		int size = allWindows.size();
		System.out.println("Total window count: " + size);

		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				Thread.sleep(2000);
				driver.close(); // close the print window
			}
		}
		Thread.sleep(2000);
		driver.switchTo().window(parentWindow);
		System.out.println(" parent window switched successfully");
		Thread.sleep(5000);
	}

	public void samplesearch() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(Commonsearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Samplesearch)).click();
	}

	public void samplecollect(String name, String a) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(Name)).sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(go)).click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Select select1 = new Select(SampleStatus);
		select1.selectByVisibleText(a);
		
		scrollAndClick(Gworkorder);
	
//Sleep		
		Thread.sleep(2000);
		screenshot.captureBeforeClick(driver, Barcodeclose);
		wait.until(ExpectedConditions.elementToBeClickable(Barcodeclose)).click();
		Thread.sleep(2000);
	}
	
	public void sampleReceive(String name) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(Name)).sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(go)).click();
		
		scrollAndClick(Gworkorder);
		
		Thread.sleep(2000);
		screenshot.captureBeforeClick(driver, Barcodeclose);
		wait.until(ExpectedConditions.elementToBeClickable(Barcodeclose)).click();
		Thread.sleep(2000);

	}
	
	public void sampleNotgiven(String name, String a) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(Name)).sendKeys(name);;
		wait.until(ExpectedConditions.elementToBeClickable(go)).click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Select select1 = new Select(SampleStatus);
		select1.selectByVisibleText(a);
		
		scrollAndClick(Gworkorder);
		screenshot.captureBeforeClick(driver, Barcodeclose);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(Barcodeclose)).click();
		Thread.sleep(2000);
	}

	
	
	public void recollect(String a) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(PatientName)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(search)).click();
		
//Sleep
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(radio)).click();
		wait.until(ExpectedConditions.elementToBeClickable(ClickGo)).click();
		
		scrollAndClick(Gworkorder);
		
//Sleep		
		
		Thread.sleep(2000);
		screenshot.captureBeforeClick(driver, Barcodeclose);
		wait.until(ExpectedConditions.elementToBeClickable(Barcodeclose)).click();
		Thread.sleep(2000);
	}
	
	public void NotGivenAbberent(String a, String b, String c) throws InterruptedException {
	
		wait.until(ExpectedConditions.elementToBeClickable(PatientNameSampleSearch)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(AbberentCheckBox)).click();
		
		Select select1 = new Select(AbberentStatus);
		select1.selectByVisibleText(b);
		
		wait.until(ExpectedConditions.elementToBeClickable(AbberentSearch)).click();
	
//Sleep		
		
		Thread.sleep(2000);
		scrollAndClick(CheckboxNot);
		
		Select select2 = new Select(AbberentsampleCollection);
		select2.selectByVisibleText(c);
		
		scrollAndClick(AbberentOk);
		
		scrollAndClick(Gworkorder);
		
//Sleep		
		
		Thread.sleep(2000);
		screenshot.captureBeforeClick(driver, Barcodeclose);
		wait.until(ExpectedConditions.elementToBeClickable(Barcodeclose)).click();
		Thread.sleep(2000);
	}
	
	public void statusselection(String a) throws InterruptedException {
		Select select1 = new Select(SampleStatus);
		select1.selectByVisibleText(a);
	}
	
	public void ReasonSelection(String a, String b) throws InterruptedException {
		Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(SampleStatus)));
		select.selectByVisibleText(a);
		
		Select select1 = new Select(wait.until(ExpectedConditions.elementToBeClickable(SampleReason)));
		select1.selectByVisibleText(b);
	}
	
}
