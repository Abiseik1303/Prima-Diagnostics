package com.TestProduct.PageObjects;


import java.time.Duration;

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

public class ClientMasterPage extends BaseClass {

	WebDriver driver;

	public ClientMasterPage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Masters')]")
	@CacheLookup
	WebElement Masters;

	By clientmaster = By.xpath(
			"//li[contains(text(),'Client')]");

	@FindBy(how = How.ID, using = "ddlClientType")
	@CacheLookup
	WebElement clienttype1;

	By clientname = By.xpath("//input[@name='txtClientName']");
	By clientcode = By.xpath("//input[@name='txtClientCode']");
	By bussinesstype = By.xpath("//select[@name='drpBusinessType']");
	By remotelogin = By.xpath("(//input[@type='checkbox'])[5]");
	By commercial = By.xpath("//li[@id='li1']");
	By invoice = By.xpath("//input[@id='chkClientAttributes_0']");
	By Invoicetext = By.xpath("//input[@name='txtThreadshold']");

	@FindBy(name = "ddlInvoiceCycle")
	WebElement invoicecycle;

	By Notification = By.xpath("//span[@id='lblNotification']");
	By Registersms = By.xpath("(//input[@type='checkbox'])[44]");
	By Registeremail = By.xpath("(//input[@type='checkbox'])[45]");
	By Reportsms = By.xpath("(//input[@type='checkbox'])[46]");
	By Reportemail = By.xpath("(//input[@type='checkbox'])[47]");
	By shipinfo = By.xpath("//span[@id='lblShippingInformation']");

	@FindBy(name = "drpaddresstype")
	WebElement addresstype;

	By address = By.xpath("//textarea[@name='txtaddres1']");
	By city = By.xpath("//input[@name='txtciti']");
	By mobile = By.xpath("//input[@name='txtmobileno']");
	By invoiceemail = By.xpath("//input[@name='txtInvoiceEmail']");
	By primary1 = By.xpath("//input[@onclick='chectisprimary();']");
	By add = By.xpath("//input[@value='Add']");
	By contactinfo = By.xpath("//span[@id='lblContactInformtion']");

	@FindBy(name = "drplstPerson")
	WebElement contacttype;

	By contactname = By.xpath("//input[@name='txtPersonName']");
	By primary2 = By.xpath("//input[@onclick='chckPrsnPrimary();']");
	By adddetails = By.xpath("//input[@value='Add Details']");

	@FindBy(name = "ddlReason")
	WebElement reason;
	By save = By.xpath("//input[@value='Save']");
	By ok = By.xpath("");

	public void clientidentity(String type, String cname, String ccode, String bstype) {
		Masters.click();
		driver.findElement(clientmaster).click();
		Select select = new Select(clienttype1);
		select.selectByVisibleText(type);
		driver.findElement(clientname).sendKeys(cname);
		driver.findElement(clientcode).sendKeys(ccode);
		driver.findElement(bussinesstype).sendKeys(bstype);

	}

	public void clientcommercial(String cycle) throws Exception {
		
		driver.findElement(invoice).click();
		Select select = new Select(invoicecycle);
		select.selectByVisibleText(cycle);
	}

	public void clientNotification() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, window.innerHeight / 2);");
		driver.findElement(Notification).click();
		driver.findElement(Registersms).click();
		driver.findElement(Registeremail).click();
		driver.findElement(Reportsms).click();
		driver.findElement(Reportemail).click();

	}

	public void clientshipinfo(String adtype, String addres, String citi, String mob, String mail) throws Exception {
		driver.findElement(shipinfo).click();
		Select select = new Select(addresstype);
		select.selectByVisibleText(adtype);
		driver.findElement(address).sendKeys(addres);
		driver.findElement(city).sendKeys(citi);
		driver.findElement(mobile).sendKeys(mob);
		driver.findElement(invoiceemail).sendKeys(mail);
		Thread.sleep(1000);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true)", add);
		driver.findElement(primary1).click();
		driver.findElement(add).click();

	}

	public void clientcontactinfo(String ctype, String name) {
		driver.findElement(contactinfo).click();
		Select select = new Select(contacttype);
		select.selectByVisibleText(ctype);
		driver.findElement(contactname).sendKeys(name);
		driver.findElement(primary2).click();
		driver.findElement(adddetails).click();
	}

	public void saveclient() {
		Select select = new Select(reason);
		select.selectByIndex(1);
		driver.findElement(save).click();
		driver.findElement(ok).click();

	}

	public void javascriptexe(WebDriver ldriver, By Locator) {
		this.driver = ldriver;
		new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.elementToBeClickable(Locator));
		WebElement ele = driver.findElement(Locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);

	}

	public void scrolldown2() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, window.innerHeight * 0.75);");

	}
	
	public void scrollup() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
	}
	
}
