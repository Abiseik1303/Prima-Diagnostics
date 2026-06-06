package com.TestProduct.Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class BaseClass {

	static Readconfig readconfig = new Readconfig();

	public String baseURL = readconfig.getApplicationURL();

	@SuppressWarnings("unused")
	private String currentTestClass;
	public static String Username = readconfig.getUsername();
	public static String Password = readconfig.getPassword();
	public static WebDriver driver;
	
	 public static String currentStep = "Not started";

	 public static String currentStepName;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));

		option.addArguments("chrome.switches", "--disable-extensions", "--disable-extensions-file-access-check",
				"--disable-extensions-http-throttling", " --disable-infobars", "--enable-automation",
				"--start-maximized", "--disable-save-password-bubble", "--disable-notifications", "--no-first-run",
				"--disable-popup-blocking");

		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Close Window");
		driver.quit();

	}
	
	public void fluentWait(int a, WebElement element) {
	    new FluentWait<>(driver)
	        .withTimeout(Duration.ofSeconds(a))
	        .pollingEvery(Duration.ofMillis(1000))
	        .ignoring(NoSuchElementException.class)
	        .ignoring(StaleElementReferenceException.class)
	        .until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForPageLoad(int a) {
	    new FluentWait<>(driver)
	        .withTimeout(Duration.ofSeconds(a))
	        .pollingEvery(Duration.ofMillis(1000))
	        .ignoring(Exception.class)
	        .until(d -> ((JavascriptExecutor) d)
	            .executeScript("return document.readyState")
	            .equals("complete"));
	}
	
//	 @AfterClass
//	    public void teardown() throws InterruptedException {
//	        try {
//	            // Take a final screenshot of whatever is on screen right now.
//	            // This captures the state at the end of the class — pass or fail.
//	            ScreenshotUtils.captureScreenshot(driver);
//	            System.out.println("[BaseClass] End-of-class screenshot taken for: " + currentTestClass);
//	        } catch (Exception e) {
//	            System.err.println("[BaseClass] Could not take end-of-class screenshot: " + e.getMessage());
//	        }
//
//	        Thread.sleep(1000);
//	        System.out.println("Close Window");
//	        driver.quit();
//	    }

//	public void takeScreenshot(String name) {
//		ScreenshotUtils.takeScreenshot(driver, name);
//	}
	
	
	
	
	public void screenshot(WebDriver driver, String TCName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + TCName + ".png");
		FileHandler.copy(source, target);
		System.out.println("Screenshot is taken");

	}

	public static String Readcaptcha() throws TesseractException, IOException {
		File src = driver.findElement(By.id("Image2")).getScreenshotAs(OutputType.FILE);
		String des = System.getProperty("user.dir") + "/Screenshots/captcha.png";
		FileHandler.copy(src, new File(des));

		ITesseract img = new Tesseract();
		String imgtxt = img.doOCR(new File(des));
		System.out.println(imgtxt);
		return imgtxt;

	}

	// Put this in BaseClass.java — reuse everywhere
	public void scrollAndClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		// Wait for element in DOM
		fluentWait.until(driver -> element.isDisplayed());

		// Scroll to center
		js.executeScript("arguments[0].scrollIntoView({block: 'center'})", element);

		// Wait for scroll to settle
		try {
			Thread.sleep(300);
		} catch (Exception e) {
		}

		// Wait until clickable
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));

		// Click with fallback
		try {
			element.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", element);
		}
	}

	public void scrollAndSendKeys(WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		// Wait for element in DOM
		fluentWait.until(driver -> element.isDisplayed());

		// Scroll to center
		js.executeScript("arguments[0].scrollIntoView({block: 'center'})", element);

		// Wait for scroll to settle
		try {
			Thread.sleep(300);
		} catch (Exception e) {
		}

		// Wait until element is clickable
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));

		// Clear and SendKeys with fallback
		try {
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			// Fallback — set value via JavaScript
			js.executeScript("arguments[0].value = arguments[1];", element, value);
			// Trigger JS change event so page detects the input
			js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", element);
			System.out.println("Normal sendKeys failed, used JS fallback: " + e.getMessage());
		}
	}

	public void handleAlertIfPresent() {
		try {
			// Wait up to 5 seconds for alert to appear
			WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(5));
			alertWait.until(ExpectedConditions.alertIsPresent());

			// Alert found — get text for logging
			String alertText = driver.switchTo().alert().getText();
			System.out.println("✅ Alert found: " + alertText);

			// Accept the alert
			driver.switchTo().alert().accept();
			System.out.println("✅ Alert accepted.");

		} catch (TimeoutException e) {
			// No alert appeared — continue normally
			System.out.println("ℹ️ No alert present, continuing...");
		} catch (NoAlertPresentException e) {
			System.out.println("ℹ️ No alert present, continuing...");
		} catch (Exception e) {
			System.out.println("⚠️ Unexpected alert error: " + e.getMessage());
		}
	}

	public static String captureFailureScreenshot(String testName, Throwable throwable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}