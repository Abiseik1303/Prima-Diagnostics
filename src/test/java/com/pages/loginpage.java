package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helperclass.baseclass;

public class loginpage extends baseclass {

	WebDriver dri;
	WebDriverWait wait;
	
	
	
	public loginpage(WebDriver localdriver) {
		this.dri=localdriver;
		PageFactory.initElements(dri, this);
	}

	@FindBy(id = "txtUserName")
	@CacheLookup
	public WebElement UserName1;
	
	@FindBy(id = "txtPassword")
	@CacheLookup
	public WebElement password1;
	
	@FindBy(id = "imgGo")
	@CacheLookup
	public WebElement go;
	
	@FindBy(xpath = "//option[contains(text(),'LabReception')]")
	@CacheLookup
	public WebElement recep;
	
	@FindBy(xpath = "//option[contains(text(),'Credit Controller')]")
	@CacheLookup
	public WebElement creditcontroller;
	
	@FindBy(id = "ddlLocation")
	@CacheLookup
	public WebElement Location;
	
	@FindBy(id = "imgGo")
	@CacheLookup
	public WebElement go2;
	
	@FindBy(xpath = "//option[contains(text(),'Administrator')]")
	@CacheLookup
	private WebElement admin;
	
	
	public void login(String name,String pass) {
		UserName1.sendKeys(name);
		password1.sendKeys(pass);
		go.click();
	}
	public void selectRole(String Role01) throws InterruptedException {
//		WebDriverWait wait=new WebDriverWait(dri, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(recep));
//		Select rle=new Select(recep);
//		rle.selectByVisibleText(Role01);	
		recep.click();
	}
	public void selectloc(String loc01) {
		Select loc=new Select(Location);
		loc.selectByVisibleText(loc01);	
		go2.click();
	}
	public void Selectcredit(String cl1) {
//		Select rl2=new Select(creditcontroller);
//		rl2.selectByVisibleText(cl1);
		creditcontroller.click();
		
	}
	
	public void SelectAdmin(String cl1) {
		admin.click();
	}
	
}
