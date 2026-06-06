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
import com.TestProduct.Utility.HelperClass;
import com.TestProduct.Utility.Readconfig;

public class ClientRateMappingPage extends BaseClass {

	WebDriver driver;
	HelperClass helper = new HelperClass();
	Readconfig readconfig=new Readconfig();

	public ClientRateMappingPage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Masters')]")
	@CacheLookup
	WebElement Masters;

	By RateMapping = By.xpath("//a[@onclick='navigateURL(\"457\",\"../Admin/ClientRateMapping.aspx\",\"Rate Mapping\",\"\",\"\");']");

	@FindBy(name = "ddlClientType")
	WebElement bussinesstype;

	By Clientname = By.id("txtClientName");
	By clientnameautosuggestion = By.xpath("//ul[@id='AutoCompleteExLstGrp_completionListElem']");

	@FindBy(name = "ddlratetype")
	WebElement Ratetype;

	By Ratecard = By.id("txtRateCard");

	By Ratecardautosuggestion = By.xpath("//ul[@id='AutoCompleteExLstGrp1_completionListElem']");
	By BaseRate = By.id("ChkBaserate");
	By ValidFrom = By.xpath("//input[@name='txtValidFrom']");
	By ValidFromTodaydate = By.xpath("//div[@id='CalendarExtender2_today']");
	By ValidTo = By.name("txtValidTo");
	By ValidToCalender = By.xpath("//div[@id='CalendarExtender1_container']");
	By getcurrentmontheyear = By.xpath("//div[@id='CalendarExtender1_header']");
	By ExpectedDate = By.xpath("//div[@class='ajax__calendar_day']");
	By next = By.xpath("//div[@id='CalendarExtender1_nextArrow']");
	@FindBy(name = "ddlReason")
	WebElement Reason;

	By save = By.name("btnAdd");

	public void clientratemap(String btype, String name, String rname, String rate) throws Exception {
		Masters.click();
		driver.findElement(RateMapping).click();
		Select select = new Select(bussinesstype);
		select.selectByVisibleText(btype);
		Thread.sleep(1000);
		selectfromlist(Clientname, clientnameautosuggestion, name);
		Thread.sleep(1000);
		Select select1 = new Select(Ratetype);
		select1.selectByVisibleText(rname);
		Thread.sleep(1000);
		selectfromlist(Ratecard, Ratecardautosuggestion, rate);
		Thread.sleep(1000);
		driver.findElement(BaseRate).click();

	}

	String YYYY = readconfig.getyear();
	String MMMM = readconfig.getmonth();
	String DDDD = readconfig.getdate();

	public void selectcalender() throws Exception {
		driver.findElement(ValidFrom).click();
		driver.findElement(ValidFromTodaydate).click();
		driver.findElement(ValidTo).click();// opens the calendar
		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ValidToCalender));
		while (true) {
			String MonthYear = driver.findElement(getcurrentmontheyear).getText();
			String arr[] = MonthYear.split(" ");
			String mm = arr[0];
			String yr = arr[1];

			if (mm.equalsIgnoreCase(MMMM) && yr.equals(YYYY))
				break;
			else
				driver.findElement(next).click();

		}

		List<WebElement> allelements = driver.findElements(ExpectedDate);

		for (WebElement ele : allelements) {
			String dt = ele.getText();
			if (dt.equals(DDDD)) {
				ele.click();
				break;
			}
		}

		Select select2 = new Select(Reason);
		select2.selectByIndex(1);
		driver.findElement(save).click();

	}

	public void selectfromlist(By Locator, By listlocator, String value) throws Exception {
		driver.findElement(Locator).sendKeys(value);
		Thread.sleep(3000);
		List<WebElement> list1 = driver.findElements(listlocator);
		System.out.println("The total no. of Suggestion in Search box:" + list1.size());
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i).getText());
			if (list1.get(i).getText().contains(value)) {
				Thread.sleep(3000);
				// new WebDriverWait(driver,
				// Duration.ofSeconds(40)).until(ExpectedConditions.elementToBeClickable(listlocator));
				list1.get(i).click();
				break;
			}

		}
	}
	

}
