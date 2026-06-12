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
import com.TestProduct.Utility.Readconfig;
import com.TestProduct.Utility.ScreenshotUtils;

public class BulkInvoiceGeneration extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;
	ScreenshotUtils screenshot;
	Readconfig readconfig = new Readconfig();
	
	public BulkInvoiceGeneration(WebDriver ldriver) {

		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='RdoClient']")
	@CacheLookup
	public WebElement BulkRadio;

	@FindBy(how = How.XPATH, using = "//input[@value='Generate Invoice']")
	@CacheLookup
	public WebElement GenerateInvoice;

	@FindBy(how = How.XPATH, using = "//input[@name='CSchedule$txtClientName']")
	@CacheLookup
	public WebElement Clientname;

	@FindBy(how = How.XPATH, using = "//select[@name='CSchedule$drpCustomerType']")
	@CacheLookup
	public WebElement BussinessType;

	@FindBy(how = How.XPATH, using = "//input[@name='CSchedule$ImgBntCalcFrom']")
	@CacheLookup
	public WebElement From;

	@FindBy(how = How.XPATH, using = "//input[@name='CSchedule$ImgBntCalcTo']")
	@CacheLookup
	public WebElement To;

	@FindBy(how = How.XPATH, using = "(//div[contains(text(),'3')])[2]")
	@CacheLookup
	public WebElement Fromdate;

	@FindBy(how = How.XPATH, using = "(//div[@class='ajax__calendar_footer ajax__calendar_today'])[2]")
	@CacheLookup
	public WebElement Todate;

	@FindBy(how = How.XPATH, using = "//input[@value='Search']")
	@CacheLookup
	public WebElement Search;

	@FindBy(how = How.XPATH, using = "(//button[@type='button'])[3]")
	@CacheLookup
	public WebElement Okpopup;
	
	@FindBy(how = How.XPATH, using = "//div[@id='CSchedule_CalendarExtender1_popupDiv']")
	@CacheLookup
	public WebElement fromDateGrid;

	@FindBy(how = How.XPATH, using = "//div[@id='CSchedule_CalendarExtender1_header']")
	@CacheLookup
	public WebElement fromMonthGrid;

	@FindBy(how = How.XPATH, using = "//div[@id='CSchedule_CalendarExtender1_body']")
	@CacheLookup
	public WebElement dateGrid;

	@FindBy(how = How.XPATH, using = "//div[@id='CSchedule_CalendarExtender1_nextArrow']")
	@CacheLookup
	public WebElement next;

	@SuppressWarnings("static-access")
	public void bulkinvoice(String a, String b) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(BulkRadio)).click();
		
		Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(BussinessType)));
		select.selectByVisibleText(a);
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(Clientname)).sendKeys(b);
		
		wait.until(ExpectedConditions.elementToBeClickable(From)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Fromdate)).click();
		wait.until(ExpectedConditions.elementToBeClickable(To)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Todate)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Search)).click();
		wait.until(ExpectedConditions.elementToBeClickable(GenerateInvoice));
		screenshot.captureBeforeClick(driver, GenerateInvoice);
		GenerateInvoice.click();
		
	}
	
	String YYYY = readconfig.getyear();
	String MMMM = readconfig.getmonth();
	String DDDD = readconfig.getdate();

	@SuppressWarnings("static-access")
	public void bulkinvoice1(String a, String b) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(BulkRadio)).click();
		
		Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(BussinessType)));
		select.selectByVisibleText(a);

		// Sleep

		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(Clientname)).sendKeys(b);

		wait.until(ExpectedConditions.elementToBeClickable(From)).click();

		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOf(fromDateGrid));

		while (true) {
			String MonthYear = fromMonthGrid.getText();
			String[] arr = MonthYear.split(" ");
			String month = arr[0];
			String year = arr[1];

			if (month.equalsIgnoreCase(MMMM) && year.equals(YYYY))
				break;

			else
				next.click();

		}
		
		List<WebElement> allelements = driver.findElements(By.xpath(
				"//div[@id='CSchedule_CalendarExtender1_body']//div[contains(@class,'ajax__calendar_day')]"));

		for (WebElement ele : allelements) {
			String dt = ele.getText();
			if (dt.equals(DDDD)) {
				ele.click();
				break;

			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(To)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Todate)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Search)).click();
		wait.until(ExpectedConditions.elementToBeClickable(GenerateInvoice));
		screenshot.captureBeforeClick(driver, GenerateInvoice);
		GenerateInvoice.click();
		wait.until(ExpectedConditions.elementToBeClickable(Okpopup)).click();
	}

}
