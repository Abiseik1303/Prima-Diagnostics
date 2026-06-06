package com.TestProduct.PageObjects;

import java.time.Duration;
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
import com.TestProduct.Utility.Closebill;


public class LabTechnicianPage extends BaseClass{

	WebDriver driver;
	WebDriverWait wait;
	
	Closebill cb=new Closebill();

	public LabTechnicianPage(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.NAME, using = "txtPatientSearch")
	@CacheLookup
	WebElement PatientNamebox;
	
	@FindBy(how=How.NAME, using="txtvisitno")
	@CacheLookup
	WebElement Patientvisitnumber;

	@FindBy(how = How.XPATH, using = "//input[@name='txtinvname']")
	@CacheLookup
	WebElement testname;

	@FindBy(how = How.XPATH, using = "//input[@id='btnSearch']")
	@CacheLookup
	WebElement Searchbtn;

	@FindBy(how = How.XPATH, using = "//span[@id='GridView1_ctl02_lblTaskDescription']")
	@CacheLookup
	WebElement Grid;
	
	@FindBy(how = How.XPATH, using = "(//textarea[@class='form-control element-with-border Details_SubHeading small InputRange'])[1]")
	@CacheLookup
	WebElement ValueBox1;
	
	@FindBy(how = How.XPATH, using = "//td[@class='w-14p v-middle csstxtName']//child::textarea")
	@CacheLookup
	WebElement selectpatient;

	@FindBy(how = How.XPATH, using = "//input[@name='btnApproval']")
	@CacheLookup
	WebElement save;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ImgBntCalcFrom']")
	@CacheLookup
	WebElement From;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ImgBntCalcTo']")
	@CacheLookup
	WebElement To;
	
	@FindBy(how = How.XPATH, using = "//div[@id='CalendarExtender1_today']")
	@CacheLookup
	WebElement SelectFrom;
	
	@FindBy(how = How.XPATH, using = "//div[@id='CalendarExtender2_today']")
	@CacheLookup
	WebElement SelectTo;
	
	@FindBy(how = How.XPATH, using = "//input[@name='uctlTaskList$txttext']")
	@CacheLookup
	WebElement patientname;
	
	@FindBy(how = How.XPATH, using = "//input[@name='uctlTaskList$btn_Go']")
	@CacheLookup
	WebElement go;
	
	@FindBy(how = How.XPATH, using = "//input[@name='btnSaveToDispatch']")
	@CacheLookup
	WebElement SaveandHome;
	
	@FindBy(how=How.XPATH,using="//select[@bulkapp='ddl']")
	@CacheLookup
	WebElement Status;
	
	@FindBy(how = How.XPATH, using = "(//input[@type='checkbox'])[3]")
	@CacheLookup
	WebElement CheckBox;
	
	@FindBy(how = How.XPATH, using = "(//input[@type='checkbox'])[4]")
	@CacheLookup
	WebElement CheckBox2;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Enter Result']")
	@CacheLookup
	WebElement EnterResult;
	
	
/*	@FindBy(how = How.XPATH, using = "")
	@CacheLookup
	WebElement ; */
	
	
	

	public void TestDetails(String pname, String value,String visitno) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(PatientNamebox)).sendKeys(pname);
		wait.until(ExpectedConditions.elementToBeClickable(Patientvisitnumber)).sendKeys(visitno);
		
		
		From.click();
		SelectFrom.click();
		To.click();
		SelectTo.click();
		
		Searchbtn.click();
		Thread.sleep(15000);
		Grid.click();
		Thread.sleep(2000);
		selectpatient.sendKeys(value);
		Thread.sleep(2000);
		save.click();
//		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
		

	}
	
	public void enterresult(String pname, String a) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(PatientNamebox)).sendKeys(pname);
		wait.until(ExpectedConditions.elementToBeClickable(Searchbtn)).click();

//sleep
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(Grid)).click();
		
		scrollAndSendKeys(ValueBox1, a);
		
		
//		scrollAndClick(save);
		wait.until(ExpectedConditions.elementToBeClickable(save)).click();
		wait.until(ExpectedConditions.elementToBeClickable(save)).click();
		
		handleAlertIfPresent();
		
	}
	
	public void validation(String a) throws InterruptedException {
//		JavascriptExecutor j =(JavascriptExecutor)driver;
//		j.executeScript("window.scrollTo({top: 0, behavior: 'smooth'});");
		
		scrollAndSendKeys(patientname, a);
		
//		wait.until(ExpectedConditions.elementToBeClickable(patientname)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(go)).click();
		
		scrollAndClick(SaveandHome);
		
	}
	
	public void recollect(String pname, String a, String b) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(PatientNamebox)).sendKeys(pname);;
		wait.until(ExpectedConditions.elementToBeClickable(Searchbtn)).click();

//sleep
				
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(Grid)).click();
		
		
		scrollAndSendKeys(ValueBox1, a);

		Select s = new Select(wait.until(ExpectedConditions.visibilityOf(Status)));
		s.selectByVisibleText(b);
		
//		scrollAndClick(save);
		wait.until(ExpectedConditions.elementToBeClickable(save)).click();
		wait.until(ExpectedConditions.elementToBeClickable(save)).click();
	}
	
	public void enterresultRecollect(String pname, String a) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(PatientNamebox)).sendKeys(pname);
		wait.until(ExpectedConditions.elementToBeClickable(Searchbtn)).click();
		
	//Sleep
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(Grid)).click();
		wait.until(ExpectedConditions.elementToBeClickable(CheckBox)).click();
		
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
//		wait.until(ExpectedConditions.elementToBeClickable(EnterResult)).click();
		
		scrollAndClick(EnterResult);
		
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//		js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		scrollAndClick(ValueBox1);
		wait.until(ExpectedConditions.elementToBeClickable(ValueBox1)).sendKeys(a);
	
		wait.until(ExpectedConditions.elementToBeClickable(save)).click();
//		scrollAndClick(save);
		wait.until(ExpectedConditions.elementToBeClickable(save)).click();
		
		handleAlertIfPresent();
	}
	
	public void StatusChangeresultEntry(String pname, String a) throws InterruptedException {
	
		wait.until(ExpectedConditions.elementToBeClickable(PatientNamebox)).sendKeys(pname);
		wait.until(ExpectedConditions.elementToBeClickable(Searchbtn)).click();
	
	//Sleep
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(Grid)).click();
		
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
//		wait.until(ExpectedConditions.elementToBeClickable(ValueBox1)).click();
		
		scrollAndClick(ValueBox1);
		wait.until(ExpectedConditions.elementToBeClickable(ValueBox1)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(ValueBox1)).sendKeys(a);
//		wait.until(ExpectedConditions.elementToBeClickable(save)).click();
		scrollAndClick(save);
		wait.until(ExpectedConditions.elementToBeClickable(save)).click();
		
	}
	
	public void selectivetestResultentry(String pname, String a) throws InterruptedException {
	
		wait.until(ExpectedConditions.elementToBeClickable(PatientNamebox)).sendKeys(pname);
		wait.until(ExpectedConditions.elementToBeClickable(Searchbtn)).click();
		
//Sleep
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(Grid)).click();
			
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		scrollAndClick(CheckBox2);
//		wait.until(ExpectedConditions.elementToBeClickable(CheckBox2)).click();
		wait.until(ExpectedConditions.elementToBeClickable(EnterResult)).click();
		
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//		js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		scrollAndClick(ValueBox1);
		wait.until(ExpectedConditions.elementToBeClickable(ValueBox1)).sendKeys(a);
//		wait.until(ExpectedConditions.elementToBeClickable(save)).click();
		scrollAndClick(save);
		wait.until(ExpectedConditions.elementToBeClickable(save)).click();
		
		handleAlertIfPresent();
		
	}
	

}

