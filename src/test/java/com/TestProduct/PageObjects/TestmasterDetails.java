package com.TestProduct.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.ScreenshotUtils;

public class TestmasterDetails extends BaseClass{

	WebDriver driver;
	WebDriverWait wait;
	ScreenshotUtils screenshot;

	public TestmasterDetails(WebDriver Idriver) {
		this.driver = Idriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Masters')]")
	@CacheLookup
	private WebElement Masters;
	
	@FindBy(xpath = "//li[contains(text(),'Test Master')]")
	@CacheLookup
	private WebElement TestMaster;
	
	@FindBy(xpath = "//input[@name='TabContainer1$TabTestMaster$TM$txtTestCodeScheme']")
	@CacheLookup
	public WebElement SearchInvName;

//-- Use select		

	@FindBy(xpath = "//input[@name='TabContainer1$TabTestMaster$TM$btnLoadTestDetails']")
	@CacheLookup
	public WebElement Load;

	@FindBy(xpath = "//select[@name='TabContainer1$TabTestMaster$TM$ddlDept']")
	@CacheLookup
	public WebElement Department;

//-- Use select		

	@FindBy(xpath = "//select[@name='TabContainer1$TabTestMaster$TM$ddlHeader']")
	@CacheLookup
	public WebElement DepartmentHeader;

//-- Use select		

	@FindBy(xpath = "//select[@name='TabContainer1$TabTestMaster$TM$ddlResultValue']")
	@CacheLookup
	public WebElement ResultValue;

//-- Use select		

	@FindBy(xpath = "//select[@name='TabContainer1$TabTestMaster$TM$ddlSample']")
	@CacheLookup
	public WebElement Sample;

//-- Use select		

	@FindBy(xpath = "//select[@name='TabContainer1$TabTestMaster$TM$ddlAdditive']")
	@CacheLookup
	public WebElement Additive;

//-- Use select		

	@FindBy(xpath = "//input[@name='TabContainer1$TabTestMaster$TM$TabContainer1$TabGeneral$txtCOTValue']")
	@CacheLookup
	public WebElement ProcessingTime;

	@FindBy(xpath = "//select[@name='TabContainer1$TabTestMaster$TM$ddlReasonn']")
	@CacheLookup
	public WebElement Reason;

	@FindBy(xpath = "//option[contains(text(),'TestMaster Updation')]")
	@CacheLookup
	public WebElement TestMasterUpdation;

	@FindBy(xpath = "//input[@name='TabContainer1$TabTestMaster$TM$btnSave']")
	@CacheLookup
	public WebElement Save;

	@FindBy(xpath = "//button[@id='okbtnid']")
	@CacheLookup
	public WebElement popupOk;

	@FindBy(xpath = "(//span[@class='ajax__tab_tab'])[8]")
	@CacheLookup
	public WebElement RangeMapping;

	@FindBy(xpath = "//input[@value='Change']")
	@CacheLookup
	public WebElement Change;

	@FindBy(xpath = "//select[@name='TabContainer1$TabTestMaster$TM$ddlRefRangeType']")
	@CacheLookup
	public WebElement RangeType;

//-- Use select	

	@FindBy(xpath = "//select[@name='TabContainer1$TabTestMaster$TM$ddlCategory']")
	@CacheLookup
	public WebElement Gender;
	
//-- Use select		

	@FindBy(xpath = "//select[@name='TabContainer1$TabTestMaster$TM$ddlRRSubCategory']")
	@CacheLookup
	public WebElement Category;

	@FindBy(xpath = "//option[contains(text(),'Common')]")
	@CacheLookup
	public WebElement Selectcategory;

	@FindBy(xpath = "//select[@name='TabContainer1$TabTestMaster$TM$ddlGenderValueOpt']")
	@CacheLookup
	public WebElement Value;

	@FindBy(xpath = "//select[@name='TabContainer1$TabTestMaster$TM$ddlGenderValueOpt']//option[contains(text(),'Between')]")
	@CacheLookup
	public WebElement Between;

	@FindBy(xpath = "//input[@name='TabContainer1$TabTestMaster$TM$txtGenderValueStart']")
	@CacheLookup
	public WebElement FirstValueBox;

	@FindBy(xpath = "//input[@name='TabContainer1$TabTestMaster$TM$txtGenderValueEnd']")
	@CacheLookup
	public WebElement SecondvalueBox;

	@FindBy(xpath = "(//input[@value='Add'])[3]")
	@CacheLookup
	public WebElement Addvalue;

	@FindBy(xpath = "//input[@value='Save Changes']")
	@CacheLookup
	public WebElement SaveChanges;

	@FindBy(xpath = "//input[@name='TabContainer1$TabTestMaster$TM$TabContainer1$TabRangeMapping$btnAddRefMapping']")
	@CacheLookup
	public WebElement AddRange;

	public void findINV(String invname) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(Masters)).click();
		wait.until(ExpectedConditions.elementToBeClickable(TestMaster)).click();
		wait.until(ExpectedConditions.elementToBeClickable(SearchInvName)).sendKeys(invname);
		
		List<WebElement> list = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
				By.xpath("//ul[@class='wordWheel listMain .box mediumList']"), 0));
		
		if(!list.isEmpty()) list.get(0).click();
		
		
//		Thread.sleep(1000);
//		List<WebElement> list1 = driver.findElements(By.xpath(""));
//		System.out.println("The total no. of Suggestion in Search box:" + list1.size());
//		for (int i = 0; i < list1.size(); i++) {
//			System.out.println(list1.get(i).getText());
//			if (list1.get(i).getText().contains(invname)) {
//				Thread.sleep(4000);
//				list1.get(i).click();
//				break;
//			}
//		}
	
//Sleep		
		
		wait.until(ExpectedConditions.elementToBeClickable(Load)).click();
		Thread.sleep(3000);
	}
	

	public void Selectdept(String a,String b,String c, String d, String e) throws InterruptedException {
		
		Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(Department)));
		select.selectByVisibleText(a);
		
		Select select1 = new Select(wait.until(ExpectedConditions.elementToBeClickable(DepartmentHeader)));
		select1.selectByVisibleText(b);
		
		Select select2 = new Select(wait.until(ExpectedConditions.elementToBeClickable(ResultValue)));
		select2.selectByVisibleText(c);
		
		Select select3 = new Select(wait.until(ExpectedConditions.elementToBeClickable(Sample)));
		select3.selectByVisibleText(d);
		
		Select select4 = new Select(wait.until(ExpectedConditions.elementToBeClickable(Additive)));
		select4.selectByVisibleText(e);
		
		wait.until(ExpectedConditions.elementToBeClickable(ProcessingTime)).sendKeys("1");
		
	}
	
	public void rangemapping(String a, String b, String c , String d, String value1, String value2) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(RangeMapping)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Change)).click();
		
		Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(RangeType)));
		select.selectByVisibleText(a);
		
		Select select1 = new Select(wait.until(ExpectedConditions.elementToBeClickable(Gender)));
		select1.selectByVisibleText(b);
		
		Select select2 = new Select(wait.until(ExpectedConditions.elementToBeClickable(Category)));
		select2.selectByVisibleText(c);
		
		Select select3 = new Select(wait.until(ExpectedConditions.elementToBeClickable(Value)));
		select3.selectByVisibleText(d);
		
		wait.until(ExpectedConditions.elementToBeClickable(FirstValueBox)).sendKeys(value1);
		wait.until(ExpectedConditions.elementToBeClickable(SecondvalueBox)).sendKeys(value2);
		wait.until(ExpectedConditions.elementToBeClickable(Addvalue)).click();
		wait.until(ExpectedConditions.elementToBeClickable(SaveChanges)).click();
		
		scrollAndClick(AddRange);
		screenshot.capturePageLoad(driver);
		
	}
	
	public void Testmasterupdation(String a) throws InterruptedException {
//		Reason.click();
//		Thread.sleep(1000);
		Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(Reason)));
		select.selectByVisibleText(a);
		
        scrollAndClick(Save);
        
        handleAlertIfPresent();
		
	}
	
}
