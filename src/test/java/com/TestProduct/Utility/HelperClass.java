package com.TestProduct.Utility;

import java.text.SimpleDateFormat;
import java.time.Duration;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HelperClass extends BaseClass {
	
	WebDriver Idriver;
	WebDriverWait wait;

	public String generatedname() {
		String name = RandomStringUtils.randomAlphabetic(6);
		return name;
	}

	public String generatedage() {
		String age = RandomStringUtils.randomNumeric(2);
		return age;
	}

	public String generatedmobno() {
		String mobno = RandomStringUtils.randomNumeric(10);
		return mobno;
	}

	public String generateinvname() {
		String inv = RandomStringUtils.randomAlphabetic(4);
		return inv;
	}

	public String generateinvcode() {
		String code = RandomStringUtils.randomAlphabetic(3);
		return code;
	}

	public static void selectValueFromList(WebDriver driver, By locator, String value) {
		List<WebElement> allElements = driver.findElements(locator);

		for (WebElement ele : allElements) {
			System.out.println("Values from calendar is " + ele.getText());

			if (ele.getText().contains(value)) {
				ele.click();
				break;
			}
		}
	}

	public static String getCurrrentDateTime() {
		return new SimpleDateFormat("HH_mm_ss_dd_MMM_yyyy").format(new Date());
		/*
		 * Date currentDate=new Date(); SimpleDateFormat myDateFormat=new
		 * SimpleDateFormat("HH_mm_ss_dd_MMM_yyyy");
		 * System.out.println(myDateFormat.format(currentDate));
		 */

	}

	public static String BatchNumber() {
		String Batch = driver.findElement(By.xpath("//table[@id='tblSampleDtl']//tbody/tr[2]/td/span[2]")).getText();
	    System.out.println(Batch);
		return Batch;
	}

	public static String visit() {
		String visit = driver.findElement(By.xpath("/html/body/form/div[3]/div[17]/div[1]/table/tbody/tr[4]/td/div/div[1]/div/table/tbody/tr[2]/td[4]/a")).getText();
		System.out.println(visit);
		return visit;
	}
	
	public static String pid() {
		String pid = driver.findElement(By.xpath("//*[@id=\"grdResult\"]/tbody/tr[2]/td[3]")).getText();
		System.out.println(pid);
		return pid;
	}
	
	public static double HalfAmount() {
		String Amount = driver.findElement(By.xpath("(//div[@id='billPart_divItemTable'])[1]//tbody/tr[2]/td[13]")).getText();
	    System.out.println(Amount);
	    String Amt = Amount;
	   	double number = Double.parseDouble(Amt);
		double num = (number) * 0.5;
		System.out.println(num);
		return num;
		
	}
	
	public static double QuatraAmount() {
		String Amount = driver.findElement(By.xpath("(//div[@id='billPart_divItemTable'])[1]//tbody/tr[2]/td[13]")).getText();
	    System.out.println(Amount);
	    String Amt = Amount;
	   	double number = Double.parseDouble(Amt);
		double num = (number) * 0.25;
		System.out.println(num);
		return num;
		
	}
	
	public static String DueAmount() {
		String Due = driver.findElement(By.xpath("//table[@id='gvDueDetails']//tbody/tr[2]/td[9]")).getText();
	    System.out.println(Due);
		return Due;
	}
	
	public void impwait(int a) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(a));
	}
	
}
