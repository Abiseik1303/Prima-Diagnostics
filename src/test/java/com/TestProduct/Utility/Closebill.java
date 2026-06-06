package com.TestProduct.Utility;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;



public class Closebill extends BaseClass {
	
	String visitnumber;

	public void closebill() throws Exception {
		
		String Parent = driver.getWindowHandle();
		System.out.println("The Parent Window ID is : " + Parent);
		Set<String> Allwindows = driver.getWindowHandles();
		int Count = Allwindows.size();
		System.out.println("Total Window :" + Count);
		for (String child : Allwindows) {
			if (child != Parent) {
				driver.switchTo().window(child);
				Thread.sleep(2000);
				driver.close();
			}
		}
		driver.switchTo().window(Parent);
		System.out.println("Parent window title is:" + driver.getTitle());
		/*
		 * ArrayList<String> tabs= new ArrayList<String>(Allwindows);
		 * driver.switchTo().window(tabs.get(2)); driver.close();
		 * driver.switchTo().window(tabs.get(1)); driver.close();
		 * driver.switchTo().window(tabs.get(0));
		 * System.out.println("Parent window title is:" + driver.getTitle());
		 */
		// driver.findElement(By.xpath("//input[@name='btnDisableIframSRC']"));
	}

	public void pdfclosebill() throws Throwable {
		driver.findElement(By.xpath("//div[@id='Panel5']")).click();
		driver.findElement(By.xpath("//input[@id='btnDisableIframSRC']")).click();

	}

	public void closeprintpopup()  {
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		WebElement webElement = driver.findElement(By.tagName("body"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.print=function(){};");
		webElement.sendKeys(Keys.TAB);
		webElement.sendKeys(Keys.ENTER);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		visitnumber=driver.findElement(By.xpath("//span[@id='advBillPrint_lblVisitNumber']")).getText();
		System.out.println("visit number is :" + visitnumber);
		driver.close();
		driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

	}

	public void printpopup() throws InterruptedException {
		Set<String> popup = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(popup);
		driver.switchTo().window(list.get(2));
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.switchTo().window(list.get(1));
		driver.close();
		System.out.println(driver.getCurrentUrl());
		Set<String> popup1 = driver.getWindowHandles();
		list.clear();
		list.addAll(popup1);
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getCurrentUrl());

	}
	
	public String Patientvisitnumber() {
		System.out.println("visit number is :" + visitnumber);
		return visitnumber;
		
	}
	
	public static String visit() {
		String visit = driver.findElement(By.xpath("//table[@id='grdResult']/tbody/tr[2]/td[4]")).getText();
	    System.out.println(visit);
		return visit;
	}
	
	public static void CloseBill() {
		WebElement Close = driver.findElement(By.xpath("//input[@name='btnDisableIframSRC']"));
		Close.click();
	}
	
	public void escape() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}
	
	public void CloseWindow() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_F4);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_F4);
	}
	
	public void blockpopup() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.print = function(){};");

	}
	
	public void winhan() {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {
		    if (!window.equals(parentWindow)) {
		        driver.switchTo().window(window);
		        driver.close(); // close the print window
		    }
		}
		driver.switchTo().window(parentWindow);
	}
	
	public void handleSRSPrintPopup() throws InterruptedException, AWTException {
	    Thread.sleep(1500);
	    String parentWindow = driver.getWindowHandle();
	    Set<String> allWindows = driver.getWindowHandles();

	    for (String window : allWindows) {
	        if (!window.equals(parentWindow)) {
	            driver.switchTo().window(window);

	            // 1. Block the print dialog from appearing
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("window.print = function(){};");

	            Thread.sleep(500);

	            // 2. Close the SRS popup window
	            driver.close();
	        }
	    }
	    // 3. Return to parent
	    driver.switchTo().window(parentWindow);
	}
	
	}
