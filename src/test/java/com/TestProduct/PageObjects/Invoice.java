package com.TestProduct.PageObjects;

import java.time.Duration;
import java.time.Year;
import java.util.List;

import org.openqa.selenium.By;
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
import com.TestProduct.Utility.Readconfig;
import com.TestProduct.Utility.ScreenshotUtils;

public class Invoice extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;
	ScreenshotUtils screenshot;
	Readconfig readconfig = new Readconfig();

	public Invoice(WebDriver ldriver) {

		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='rdoSchedules']")
	@CacheLookup
	public WebElement RadioSchedules;

	@FindBy(how = How.XPATH, using = "//input[@name='CSchedule$txtClientName']")
	@CacheLookup
	public WebElement Clientname;

	@FindBy(how = How.XPATH, using = "//select[@name='CSchedule$drpCustomerType']")
	@CacheLookup
	public WebElement BussinessType;

	@FindBy(how = How.XPATH, using = "//input[@name='CSchedule$ImgBntCalcFrom']")
	@CacheLookup
	public WebElement From;

	@FindBy(how = How.XPATH, using = "//input[@name='CSchedule$ImgBntCalcFrom']")
	@CacheLookup
	public By From1;

	@FindBy(how = How.XPATH, using = "//input[@name='CSchedule$ImgBntCalcTo']")
	@CacheLookup
	public WebElement To;

	@FindBy(how = How.XPATH, using = "(//div[contains(text(),'5')])[1]")
	@CacheLookup
	public WebElement Fromdate;

	@FindBy(how = How.XPATH, using = "(//div[@class='ajax__calendar_footer ajax__calendar_today'])[2]")
	@CacheLookup
	public WebElement Todate;

	@FindBy(how = How.XPATH, using = "//input[@value='Search']")
	@CacheLookup
	public WebElement Search;

	@FindBy(how = How.XPATH, using = "//table[@id='CSchedule_GridView1']//tbody/tr[2]/td[3]")
	@CacheLookup
	public WebElement ClickClient;

	@FindBy(how = How.XPATH, using = "//select[@name='ddlInvoiceType']")
	@CacheLookup
	public WebElement InvoiceType;

	@FindBy(how = How.XPATH, using = "//input[@value='Generate Invoice']")
	@CacheLookup
	public WebElement GenerateInvoice;

	@FindBy(how = How.XPATH, using = "//input[@value='Close']")
	@CacheLookup
	public WebElement Close;

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

	public void schedules() {
		wait.until(ExpectedConditions.elementToBeClickable(RadioSchedules)).click();
		RadioSchedules.click();
	}

	public void invoice(String a, String b) throws InterruptedException {

		Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(BussinessType)));
		select.selectByVisibleText(a);

		// Sleep

		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(Clientname)).sendKeys(b);

//		if(!name.isEmpty()) name.get(0).click();

//		Thread.sleep(1000);
//		List<WebElement> list1 = driver.findElements(By.xpath("(//ul[@id='AutoCompleteExLstGrp_completionListElem'])[4]"));
//		System.out.println("The total no. of Suggestion in Search box:" + list1.size());
//		for (int i = 0; i < list1.size(); i++) {
//			System.out.println(list1.get(i).getText());
//			if (list1.get(i).getText().contains(b)) {
//				Thread.sleep(2000);
//				list1.get(i).click();
//				break;
//			}
//		}

		wait.until(ExpectedConditions.elementToBeClickable(From)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Fromdate)).click();
		wait.until(ExpectedConditions.elementToBeClickable(To)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Todate)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Search)).click();

	}

	@SuppressWarnings("static-access")
	public void selectclient() {
		wait.until(ExpectedConditions.elementToBeClickable(ClickClient));
		screenshot.captureBeforeClick(driver, ClickClient);
		ClickClient.click();
	}

	@SuppressWarnings("static-access")
	public void generateInvoice(String a) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(InvoiceType)));
		select.selectByVisibleText(a);

		scrollAndClick(GenerateInvoice);

//Sleep		

		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(Close));
		screenshot.captureBeforeClick(driver, Close);
		Close.click();
	}

	public void scrolldown2() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	String YYYY = readconfig.getyear();
	String MMMM = readconfig.getmonth();
	String DDDD = readconfig.getdate();

	public void invoice1(String a, String b) throws InterruptedException {

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

	}

}
