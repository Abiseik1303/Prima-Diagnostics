package com.TestProduct.PageObjects;

import java.io.IOException;
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

//import com.TestProduct.Utility.Readconfig;

public class BillingPage extends BaseClass {

	WebDriver driver;
	 WebDriverWait wait;
	 ScreenshotUtils screenshot;

	public BillingPage(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);

	}

	@FindBy(className = "dropmenutxt")
	@CacheLookup
	WebElement billing;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Common Tasks')]")
	@CacheLookup
	WebElement Commonsearch;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Bill Search')]")
	@CacheLookup
	public WebElement Billsearch;

	@FindBy(xpath = "//li[contains(text(),'Lab Quick Billing')]")
	@CacheLookup
	WebElement lbilling;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Registration Billing')]")
	@CacheLookup
	WebElement Rbilling;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Patient Due Details')]")
	@CacheLookup
	WebElement Patientduedetails;
	
	@FindBy(how = How.XPATH, using = "(//input[@type='radio'])[9]")
	@CacheLookup
	public WebElement DoFromVisit;
	
	@FindBy(how = How.XPATH, using = "(//input[@type='radio'])[5]")
	@CacheLookup
	public WebElement PID;
	
	@FindBy(how = How.XPATH, using = "//input[@name='txtDoFrmVisitNumber1']")
	@CacheLookup
	public WebElement CommonsearchDofrom;
	
	@FindBy(how = How.XPATH, using = "(//input[@placeholder='Name/Mobile/PID'])[1]")
	@CacheLookup
	public WebElement CommonsearchNamePid;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Visit Search')]")
	@CacheLookup
	WebElement VisitSearch;

	@FindBy(how = How.XPATH, using = "//input[@name='txtPname']")
	@CacheLookup
	WebElement Visitname;

	@FindBy(how = How.XPATH, using = "//input[@name='btnSearch']")
	@CacheLookup
	WebElement Visitsrch;

	@FindBy(how = How.XPATH, using = "//input[@id='rblSearchType_0']")
	@CacheLookup
	WebElement None;

	@FindBy(how = How.XPATH, using = "//input[@name='txtEmail']")
	@CacheLookup
	WebElement Email;

	@FindBy(how = How.XPATH, using = "//input[@name='txtInternalExternalPhysician']")
	@CacheLookup
	WebElement RefDr;

	@FindBy(how = How.XPATH, using = "//input[@name='ChkTRFImage']")
	@CacheLookup
	WebElement TRF;

	@FindBy(how = How.NAME, using = "ddSalutation")
	@CacheLookup
	WebElement PatientSalutation;

	@FindBy(how = How.NAME, using = "txtName")
	@CacheLookup
	WebElement PatientName;

	@FindBy(how = How.ID, using = "txtDOBNos")
	@CacheLookup
	WebElement PatientAge;

	@FindBy(how = How.ID, using = "txtMobileNumber")
	@CacheLookup
	WebElement PatientMobileNo;

	@FindBy(how = How.XPATH, using = "//input[@name='billPart$txtTestName']")
	@CacheLookup
	WebElement TestName;

	@FindBy(how = How.XPATH, using = "//button[@id='billPart_btnAdd']")
	@CacheLookup
	WebElement Addbtn;

	@FindBy(how = How.XPATH, using = "//input[@id='addNewPayment']")
	@CacheLookup
	WebElement AddPayment;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Package ')]")
	@CacheLookup
	WebElement package1;

	@FindBy(how = How.XPATH, using = "(//input[@value='Back'])[3]")
	@CacheLookup
	WebElement Back;

	@FindBy(how = How.ID_OR_NAME, using = "btnGenerate")
	@CacheLookup
	WebElement Generatebill;
	
	@FindBy(how = How.XPATH, using = "//input[@name='chkAlls']")
	@CacheLookup
	WebElement IsStat;
	
	@FindBy(how = How.XPATH, using = "//select[@name='billPart$ddDiscountPercent']")
	@CacheLookup
	WebElement DiscountDropDown;
	
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'10% - DISCOUNT - 10.00')]")
	@CacheLookup
	WebElement Discount;
	
	@FindBy(how = How.XPATH, using = "//select[@id='ddldiscountreasonj']")
	@CacheLookup
	WebElement DiscountReason;
	
	@FindBy(how = How.XPATH, using = "(//option[contains(text(),'Management Approval')])[2]")
	@CacheLookup
	WebElement DiscountReasonby;
	
	@FindBy(how = How.XPATH, using = "//input[@id='txtDiscAuthorizedby']")
	@CacheLookup
	WebElement AuthrizedBy;
	
	@FindBy(how = How.XPATH, using = "//textarea[@id='txtDiscRemarks']")
	@CacheLookup
	WebElement Remarks;
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='btnDiscSave']")
	@CacheLookup
	WebElement save;
	
	@FindBy(how = How.XPATH, using = "//select[@id='ddlduereasonj']")
	@CacheLookup
	WebElement DueReason;
	
	@FindBy(how = How.XPATH, using = "//input[@id='txtDueAuthorizedby']")
	@CacheLookup
	WebElement DueAuthrizedBy;
	
	@FindBy(how = How.XPATH, using = "//input[@name='billPart$PaymentType$txtAmount']")
	@CacheLookup
	WebElement AmountField;
	

	@FindBy(how = How.XPATH, using = "//input[@id='btndueSave']")
	@CacheLookup
	WebElement SaveDue;
	
	@FindBy(how = How.XPATH, using = "//input[@name='txtPatientName']")
	@CacheLookup
	WebElement DuePatientName;
	
	@FindBy(how = How.XPATH, using = "//select[@name='ucDateCtrl$ddlRegisterDate']")
	@CacheLookup
	WebElement DateRange;
	
	@FindBy(how = How.XPATH, using = "//input[@name='btnSearch']")
	@CacheLookup
	WebElement DueSearch;
	
	@FindBy(how = How.XPATH, using = "(//input[@value='rdoSelect'])[1]")
	@CacheLookup
	WebElement DueRadioButton;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Collect Due Amount']")
	@CacheLookup
	WebElement CollectDueAmount;
	
	@FindBy(how = How.XPATH, using = "//input[@name='PaymentType$txtAmount']")
	@CacheLookup
	WebElement DueAmount;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Generate Bill']")
	@CacheLookup
	WebElement DueGenerate;
	
	@FindBy(how = How.XPATH, using = "(//input[@value='Upload'])[2]")
	@CacheLookup
	WebElement uploadfile;
	
	@FindBy(how = How.XPATH, using = "//input[@name='txtClient']")
	@CacheLookup
	WebElement ClientName;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Generate Work Order']")
	@CacheLookup
	WebElement Workorder;
	
	
	
/*	@FindBy(how = How.XPATH, using = "")
	@CacheLookup
	WebElement ; */
	
	public void BillSearch() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(Commonsearch)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Billsearch)).click();

	}

	public void LabQuickBilling() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(Commonsearch)).click();
        wait.until(ExpectedConditions.elementToBeClickable(lbilling)).click();

	}

	public void RegistrationBilling() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(Commonsearch)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Rbilling)).click();
	}
	
	public void PatientDueDetails() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(Commonsearch)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Patientduedetails)).click();
	}

	public void None() {
		wait.until(ExpectedConditions.elementToBeClickable(None)).click();
	}
	
	public void Discount( String b, String c, String d, String e) throws InterruptedException, IOException {
		 JavascriptExecutor js = (JavascriptExecutor) driver;

	        // PERFORMANCE: scroll then wait for element - no arbitrary sleep needed
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        wait.until(ExpectedConditions.elementToBeClickable(DiscountDropDown)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(Discount)).click();

	        wait.until(ExpectedConditions.elementToBeClickable(DiscountReason)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(DiscountReasonby)).click();

	        wait.until(ExpectedConditions.elementToBeClickable(AuthrizedBy)).sendKeys(c);
	        // PERFORMANCE: wait for autocomplete suggestions to appear, then select
	        List<WebElement> list1 = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
	            By.xpath("//div[@class='ui-menu-item-wrapper']"), 0));
	        for (WebElement item : list1) {
	            if (item.getText().contains(d)) {
	                wait.until(ExpectedConditions.elementToBeClickable(item)).click();
	                break;
	            }
	        }

	        wait.until(ExpectedConditions.elementToBeClickable(Remarks)).sendKeys(e);
	        wait.until(ExpectedConditions.elementToBeClickable(save)).click();
		
	}
	
	public void Due(double a, String b, String c) throws InterruptedException {
	
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		wait.until(ExpectedConditions.elementToBeClickable(AmountField)).clear();
		
		wait.until(ExpectedConditions.elementToBeClickable(AmountField)).sendKeys(String.valueOf(a));;
		
		wait.until(ExpectedConditions.elementToBeClickable(AddPayment)).click();
		
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		wait.until(ExpectedConditions.elementToBeClickable(Generatebill)).click();

		driver.switchTo().alert().accept();
		
		wait.until(ExpectedConditions.elementToBeClickable(DueReason)).click();
		wait.until(ExpectedConditions.elementToBeClickable(DiscountReasonby)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(DueAuthrizedBy)).sendKeys(b);
		
		List<WebElement> list1 = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
	            By.xpath("(//li[@class='ui-menu-item'])[1]"), 0));
	        for (WebElement item : list1) {
	            if (item.getText().contains(c)) {
	                wait.until(ExpectedConditions.elementToBeClickable(item)).click();
	                break;
	            }
	        }
		
	    wait.until(ExpectedConditions.elementToBeClickable(SaveDue)).click();

		driver.switchTo().alert().accept();
	}

	public void DueCollection(String a, String b, Double c) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(DuePatientName)).sendKeys(a);
		
		Thread.sleep(1000);
		Select s = new Select(wait.until(ExpectedConditions.elementToBeClickable(DateRange)));
		s.selectByVisibleText(b);
		
		wait.until(ExpectedConditions.elementToBeClickable(DueSearch)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(DueRadioButton)).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		wait.until(ExpectedConditions.elementToBeClickable(CollectDueAmount)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(DueAmount)).sendKeys(String.valueOf(c));;
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		wait.until(ExpectedConditions.elementToBeClickable(DueGenerate)).click();
	}
	
	
	public void VisitSearch() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(Commonsearch)).click();
		wait.until(ExpectedConditions.elementToBeClickable(VisitSearch)).click();
	}

	public void PatientSalutation(String Salutation) {
		wait.until(ExpectedConditions.elementToBeClickable(PatientSalutation)).sendKeys(Salutation);
		wait.until(ExpectedConditions.elementToBeClickable(PatientSalutation)).click();
	}

	public void PatientName(String Name) throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(PatientName)).sendKeys(Name);
	}

	public void PatientAge(String Age) {
		wait.until(ExpectedConditions.elementToBeClickable(PatientAge)).sendKeys(Age);
	}

	public void PatientMobile(String MobileNo) {
		wait.until(ExpectedConditions.elementToBeClickable(PatientMobileNo)).sendKeys(MobileNo);
	}

	public void PatientEmail(String Mail1) {
		wait.until(ExpectedConditions.elementToBeClickable(Email)).sendKeys(Mail1);
	}

	public void ReferringDR(String Dr) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(RefDr)).sendKeys(Dr);
	
		 List<WebElement> drList = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
		            By.xpath("//div[@id='ReferingHospitalTypwidtheauto']"), 0));
		        if (!drList.isEmpty()) drList.get(0).click();
	}

//	public void FileUpload() throws InterruptedException {
//		wait.until(ExpectedConditions.elementToBeClickable(TRF)).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement Chse = driver.findElement(By.id("FileUpload1"));
//		WebElement fileUploadInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("FileUpload1")));
//		fileUploadInput.sendKeys("C:\\Users\\Abiseik C\\OneDrive\\Pictures\\OIP.jpg");
//	}

	public void scrolldown() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true)", package1);
	}

	public void scrolldown1() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true)", Generatebill);
	}

	public void AddTest(String Test) throws Exception {
		scrollAndSendKeys(TestName, Test);
//		wait.until(ExpectedConditions.elementToBeClickable(TestName)).sendKeys(Test);
		
		List<WebElement> testList = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
	            By.xpath("//ul[@id='billPart_AutoCompleteExtender3_completionListElem']"), 0));
	        if (!testList.isEmpty()) testList.get(0).click();
	}

	public void isStat() {
		wait.until(ExpectedConditions.elementToBeClickable(IsStat)).click();
	}
	
	public void Addbtn() {
		wait.until(ExpectedConditions.elementToBeClickable(Addbtn)).click();
	}

	public void AddPayment() {
		scrollAndClick(AddPayment);
	}

	public void Generatebill() {
		scrollAndClick(Generatebill);
	}
	
	public void Generateworkorder() {
		scrollAndClick(Workorder);
	}
	
	public void client(String a) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(ClientName)).sendKeys(a);
		
		List<WebElement> clientlst = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
	            By.xpath("//ul[@id='AutoCompleteExtenderClientCorp_completionListElem']"), 0));
	        if (!clientlst.isEmpty()) clientlst.get(0).click();
		
	}

	public void Visitsearch(String Name) throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(Visitname)).sendKeys(Name);
		wait.until(ExpectedConditions.elementToBeClickable(Visitsrch)).click();
	}

	@SuppressWarnings("static-access")
	public void back() {
		wait.until(ExpectedConditions.elementToBeClickable(Back));
		screenshot.captureBeforeClick(driver, Back);
		Back.click();
	}

	public void scrolldown2() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollup() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo({top: 0, behavior: 'smooth'});");
	}
	
	public void dofromvisit(String a, String b) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(DoFromVisit)).click();
		wait.until(ExpectedConditions.elementToBeClickable(CommonsearchDofrom)).sendKeys(a);

		List<WebElement> doList = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
	            By.xpath("(//ul[@class='wordWheel listMain .box'])[4]"), 0));
	        if (!doList.isEmpty()) doList.get(0).click();
		
		
	}
	
	@SuppressWarnings("static-access")
	public void pidRevist(String a) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(PID)).click();
		wait.until(ExpectedConditions.elementToBeClickable(CommonsearchNamePid)).sendKeys(a);

		List<WebElement> pidnum = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
	            By.xpath("/html/body/ul[23]/li[1]"), 0)); 
	    if(!pidnum.isEmpty()) pidnum.get(0).click();
		
	}
	
	
	public void FileUpload2() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement fileUploadInput = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='FileUploadTrf1']")));
		fileUploadInput.sendKeys("C:\\Users\\dell\\eclipse-workspace\\Prima-Diagnostics\\Images\\Img1.png");
		scrollAndClick(uploadfile);
	}
	
	public void FileUpload() throws InterruptedException {
	    wait.until(ExpectedConditions.elementToBeClickable(TRF)).click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement fileUploadInput = wait.until(
	        ExpectedConditions.elementToBeClickable(By.id("FileUpload1")));
	    fileUploadInput.sendKeys("C:\\Users\\dell\\eclipse-workspace\\Prima-Diagnostics\\Images\\Img1.png");
	}
	
	@SuppressWarnings("static-access")
	public void screenShot() {
		screenshot.captureScreenshot(driver);
	}
}
