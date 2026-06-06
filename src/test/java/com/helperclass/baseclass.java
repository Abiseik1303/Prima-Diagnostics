package com.helperclass;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {

	readconfig read = new readconfig();

	public String url = read.appurl();
	public String ume = read.username();
	public String pwd = read.password();
//	public String rle = read.role1();
//	public String lcn = read.loc1();

	public static WebDriver dri;

	@BeforeClass
	public void beforeclass() {
		WebDriverManager.chromedriver().setup();
    //    ChromeOptions option=new ChromeOptions();
       // option.setExperimentalOption("excludeSwitches",Arrays.asList("enable-automation"));
		dri = new ChromeDriver();
		dri.get(url);
		dri.manage().window().maximize();
		dri.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		

		
		
	}

	@AfterClass
	public static void Afterclass() throws InterruptedException {

		Thread.sleep(5000);
		dri.close();


	}

}
