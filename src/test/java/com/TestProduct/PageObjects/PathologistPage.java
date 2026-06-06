package com.TestProduct.PageObjects;

import java.time.Duration;
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
import com.TestProduct.Utility.ScreenshotUtils;

public class PathologistPage extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;
	ScreenshotUtils screenshot;

	public PathologistPage(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Common Tasks')]")
	@CacheLookup
	public WebElement CommonSearch;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'InvStatusChange')]")
	@CacheLookup
	public WebElement StatusChange;

	@FindBy(how = How.ID_OR_NAME, using = "uctlTaskList_txttext")
	@CacheLookup
	WebElement textbox;

	@FindBy(how = How.ID_OR_NAME, using = "uctlTaskList$btn_Go")
	@CacheLookup
	WebElement go;

	@FindBy(how = How.XPATH, using = "//a[contains (text(),'Show Report Preview')]")
	@CacheLookup
	WebElement reportpreview;

	@FindBy(how = How.XPATH, using = "//div[@id='viewerContainer']")
	@CacheLookup
	WebElement scroll;

	@FindBy(how = How.ID, using = "imgPDFReportPreview")
	@CacheLookup
	WebElement previewclose;

	@FindBy(how = How.ID_OR_NAME, using = "btnSaveToDispatch")
	@CacheLookup
	WebElement save;

	@FindBy(how = How.XPATH, using = "//div[@class='dropmenutxt']")
	@CacheLookup
	WebElement commonTask;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Investigation Report')]")
	@CacheLookup
	WebElement Invreport;

	@FindBy(how = How.NAME, using = "txtName")
	@CacheLookup
	WebElement name;

	@FindBy(how = How.ID_OR_NAME, using = "btnSearch")
	@CacheLookup
	WebElement search;

	@FindBy(how = How.XPATH, using = "//input[@value='rdSel']//parent::span")
	@CacheLookup
	WebElement radio;

	@FindBy(how = How.XPATH, using = "//input[@id='btnGo']")
	@CacheLookup
	WebElement goreport;

	@FindBy(how = How.XPATH, using = "//input[@name='grdResultTemp$ctl00$chkEnableAll']")
	@CacheLookup
	WebElement reprint;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'ShowReport ')]")
	@CacheLookup
	WebElement show;

	@FindBy(how = How.XPATH, using = "//td[@class='a-right']//child::img[@id='imgCloseReport']")
	@CacheLookup
	WebElement close;

	@FindBy(how = How.NAME, using = "grdResult$ctl02$Image1")
	@CacheLookup
	WebElement withsationery;

	@FindBy(how = How.XPATH, using = "//img[@onclick='ClosePopUp()']")
	@CacheLookup
    WebElement closewithsationery;

	@FindBy(how = How.NAME, using = "grdResult$ctl02$ImageButton1")
	@CacheLookup
	WebElement withoutstationery;

	@FindBy(how = How.XPATH, using = "//img[@onclick='ClosePopUp()']")
	@CacheLookup
   	WebElement closewithoutstationery;
	
	@FindBy(how=How.XPATH,using="//div[@id='rReportViewer_ctl10']")
	@CacheLookup
	WebElement scrolldown;
	
	@FindBy(how=How.XPATH,using="//select[@bulkapp='ddl']")
	@CacheLookup
	WebElement Status;
	
	@FindBy(how=How.XPATH,using="//input[@name='txtvisitno']")
	@CacheLookup
	WebElement Visitnumber;
	
	@FindBy(how=How.XPATH,using="//input[@value='Search']")
	@CacheLookup
	WebElement Search;
	
	@FindBy(how=How.XPATH,using="(//input[@type='checkbox'])[2]")
	@CacheLookup
	WebElement Radio;
	
	@FindBy(how=How.XPATH,using="//input[@name='txtAuthorised']")
	@CacheLookup
	WebElement AuthorizedBy;
	
	@FindBy(how=How.XPATH,using="//input[@value='Save']")
	@CacheLookup
	WebElement Save;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Ok')]")
	@CacheLookup
	WebElement Okpopup;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Investigation Report')]")
	@CacheLookup
	WebElement Investigationsearch;
	
	@FindBy(how = How.XPATH, using = "//input[@name='txtName']")
	@CacheLookup
	WebElement ViewPatientname;
	
	@FindBy(how = How.XPATH, using = "//select[@name='ddlRegisterDate']")
	@CacheLookup
	WebElement RegDate;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Search']")
	@CacheLookup
	WebElement SearchReport;
	
	@FindBy(how = How.XPATH, using = "//input[@name='grdResult$ctl02$Image1']")
	@CacheLookup
	WebElement WithStationary;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Close ')]")
	@CacheLookup
	WebElement CloseStationary;
	
	@FindBy(how = How.XPATH, using = "//input[@name='grdResult$ctl02$ImageButton1']")
	@CacheLookup
	WebElement WithoutStationary;
	
	@FindBy(how = How.XPATH, using = "//input[@name='txtPatientName']")
	@CacheLookup
	WebElement SelPatientName;
	
	@FindBy(how = How.XPATH, using = "//input[@name='btnSearch']")
	@CacheLookup
	WebElement SelSearch;
	
	@FindBy(how = How.XPATH, using = "(//table[@class='table table-striped grdrslt'])[2]//tbody/tr[2]/td[1]")
	@CacheLookup
	WebElement Selgrid;
	
	
	public void Approval(String pname) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(textbox)).sendKeys(pname);
		wait.until(ExpectedConditions.elementToBeClickable(go)).click();
		wait.until(ExpectedConditions.elementToBeClickable(reportpreview)).click();
		

//Sleep		
		
        Thread.sleep(5000);
        screenshot.captureScreenshot(driver);
		wait.until(ExpectedConditions.elementToBeClickable(previewclose)).click();
		
		scrollAndClick(save);
		
	}

	public void InvestigationReport(String pname) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(commonTask)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Invreport)).click();
		wait.until(ExpectedConditions.elementToBeClickable(name)).sendKeys(pname);
		wait.until(ExpectedConditions.elementToBeClickable(search)).click();
		wait.until(ExpectedConditions.elementToBeClickable(radio)).click();
		wait.until(ExpectedConditions.elementToBeClickable(goreport)).click();
		wait.until(ExpectedConditions.elementToBeClickable(reprint)).click();
		wait.until(ExpectedConditions.elementToBeClickable(show)).click();
		wait.until(ExpectedConditions.elementToBeClickable(close)).click();
		
	}

	public  void pdfs() throws InterruptedException {
		withsationery.click();
		Thread.sleep(30000);
		screenshot.captureScreenshot(driver);
		closewithsationery.click();
		Thread.sleep(2000);
		withoutstationery.click();
		Thread.sleep(2000);
		screenshot.captureScreenshot(driver);
		closewithoutstationery.click();

	}

	public  void scroll() throws InterruptedException {
		driver.switchTo().frame("iframeplaceholder");
		Thread.sleep(2000);
		driver.switchTo().frame("//iframe[@id='myiframe']");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		driver.switchTo().parentFrame();	
		
	}
	
	public void rerun(String pname, String a) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(textbox)).sendKeys(pname);
		wait.until(ExpectedConditions.elementToBeClickable(go)).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		Select s = new Select(wait.until(ExpectedConditions.visibilityOf(Status)));
		s.selectByVisibleText(a);
		
		wait.until(ExpectedConditions.elementToBeClickable(save)).click();
		
	}
	
	public void INVstatushange(String a, String b, String c) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(commonTask)).click();
		wait.until(ExpectedConditions.elementToBeClickable(StatusChange)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Visitnumber)).sendKeys(a);
		wait.until(ExpectedConditions.elementToBeClickable(Search)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Radio)).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		wait.until(ExpectedConditions.elementToBeClickable(AuthorizedBy)).sendKeys(b);
		
		List<WebElement> admin = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
				By.xpath("//ul[@id='AutoAuthorizer_completionListElem']"), 0));
		if(!admin.isEmpty()) admin.get(0).click();
		
//		List<WebElement> list1 = driver.findElements(By.xpath("//ul[@id='AutoAuthorizer_completionListElem']"));
//		System.out.println("The total no. of Suggestion in Search box:" + list1.size());
//		for (int i = 0; i < list1.size(); i++) {
//			System.out.println(list1.get(i).getText());
//			if (list1.get(i).getText().contains(c)) {
//				Thread.sleep(4000);
//				list1.get(i).click();
//				break;
//			}
//		}
		
		wait.until(ExpectedConditions.elementToBeClickable(Save)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Okpopup)).click();
		
	}

	public void InvestigationReport(String a, String b) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(commonTask)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Investigationsearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(ViewPatientname)).sendKeys(a);
		
		Select s = new Select(wait.until(ExpectedConditions.visibilityOf(RegDate)));
		s.selectByVisibleText(b);
		
		wait.until(ExpectedConditions.elementToBeClickable(SearchReport)).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(20000);
		withoutstationery.click();
		Thread.sleep(3000);
		screenshot.captureScreenshot(driver);
		CloseStationary.click();
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		withsationery.click();
		screenshot.captureScreenshot(driver);
		Thread.sleep(3000);
		
	}
	
	public void selectiveauth(String a) throws InterruptedException {
	
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		wait.until(ExpectedConditions.elementToBeClickable(SelPatientName)).sendKeys(a);
		
		scrollAndSendKeys(SelPatientName, a);
		wait.until(ExpectedConditions.elementToBeClickable(SelSearch)).click();
		
//Sleep		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(Selgrid)).click();
		wait.until(ExpectedConditions.elementToBeClickable(reportpreview)).click();
		
//sleep		
			
		Thread.sleep(7000);
		wait.until(ExpectedConditions.elementToBeClickable(previewclose)).click();
		
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//		js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");		
//		wait.until(ExpectedConditions.elementToBeClickable(save)).click();
		
		scrollAndClick(save);
		
	}
	
}
