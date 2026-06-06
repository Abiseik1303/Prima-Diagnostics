package com.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helperclass.baseclass;

public class labtechnican extends baseclass{
	
	WebDriver dri;
	WebDriverWait wait;
	
	public labtechnican(WebDriver localdriver) {
		
	this.dri=localdriver;
	PageFactory.initElements(dri, this);
	WebDriverWait wait= new WebDriverWait(dri, Duration.ofSeconds(10));
	}
	
	@FindBy(id="Attuneheader_lblRoleDes")
	@CacheLookup
	public WebElement header2;
	
	@FindBy(id="ddlRole")
	@CacheLookup
	public WebElement roleselectclick2;
		
	@FindBy(id="Attuneheader_btnRoleOK")
	@CacheLookup
	public WebElement okbtn2;
	
	@FindBy(id="txtPatientSearch")
	@CacheLookup
	public WebElement namesearch;
	
	@FindBy(id="txtvisitno")
	@CacheLookup
	public WebElement vidsearch;
			
	
	@FindBy(id="btnSearch")
	@CacheLookup
	public WebElement srch;
	
	@FindBy(id="GridView1_ctl02_lblTaskDescription")
	@CacheLookup
	public WebElement tskcli;
	
	@FindBy(xpath="//td[@class='w-14p v-middle csstxtName']//textarea")
	@CacheLookup
	public WebElement valueenter;
	
	@FindBy(id="btnApproval")
	@CacheLookup
	public WebElement save1;
	
	
	public void rolechge2() throws InterruptedException {
		header2.click();
		roleselectclick2.click();
	}
	public void selection(String rol2) throws InterruptedException {
     Select s=new Select(roleselectclick2);
     s.selectByVisibleText(rol2);
     WebDriverWait wait=new WebDriverWait(dri, Duration.ofSeconds(10));
     wait.until(ExpectedConditions.visibilityOf(roleselectclick2));
     Thread.sleep(3000);
     okbtn2.click();
	}

	public void name(String Name) throws InterruptedException {
		namesearch.sendKeys(Name);
//		vidsearch.sendKeys(v2);
		srch.click();
		Thread.sleep(5000);
		tskcli.click();
	}
	
    public void valueent(String age1) {
    	valueenter.sendKeys(age1);
    	save1.click();    	
    	Alert alert = dri.switchTo().alert();
    	alert.accept();
    	
    	
    }
}
