package com.TestProduct.Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * ScreenshotUtils ─────────────── All screenshot methods for the project live
 * here.
 *
 * WHAT IS AVAILABLE ───────────────── 1. captureScreenshot(driver) Plain
 * screenshot. No name needed. Use it anywhere.
 *
 * 2. captureOnClick(driver, element) Pass the WebElement you just clicked.
 * Screenshot is taken right after.
 *
 * 3. captureOnClick(driver, "ButtonName") Pass a label as a String. Screenshot
 * is taken with that label in the file name.
 *
 * 4. capturePageLoad(driver) Call this after a page finishes loading. No string
 * or element needed. It waits for the page to be ready, then takes the
 * screenshot automatically.
 *
 * 5. captureAutoSuggestion(driver, element) Pass the input field WebElement.
 * Call AFTER typing, BEFORE selecting.
 *
 * 6. captureAutoSuggestion(driver, "FieldName") Same as above but with a label
 * string.
 *
 * 7. captureOnFailure(driver, testName, stepName, error) Call in a catch block.
 * Test name + step name + error go into the file name.
 *
 * FILE NAMES (always unique) ────────────────────────── Screenshots/General/
 * Screenshot_HH-mm-ss_dd-MMM-yyyy.png Screenshots/Click/
 * Click_<name>_HH-mm-ss_dd-MMM-yyyy.png Screenshots/PageLoad/
 * PageLoad_HH-mm-ss_dd-MMM-yyyy.png Screenshots/AutoSugg/
 * AutoSugg_<name>_HH-mm-ss_dd-MMM-yyyy.png Screenshots/Failure/
 * FAIL_<test>_<step>_<error>_HH-mm-ss_dd-MMM-yyyy.png
 */
public class ScreenshotUtils {

	// ── Folders ───────────────────────────────────────────────────────────────
	private static final String ROOT = System.getProperty("user.dir") + "/Screenshots/";
	private static final String GENERAL = ROOT + "General/";
	private static final String CLICK = ROOT + "Click/";
	private static final String PAGELOAD = ROOT + "PageLoad/";
	private static final String AUTOSUGG = ROOT + "AutoSugg/";
	private static final String FAILURE = ROOT + "Failure/";

	// ─────────────────────────────────────────────────────────────────────────
	// 1. Plain screenshot — no name needed, just pass the driver
	// ─────────────────────────────────────────────────────────────────────────
	/**
	 * Takes a plain screenshot. No label needed.
	 *
	 * Usage: ScreenshotUtils.captureScreenshot(driver);
	 */
	public static String captureScreenshot(WebDriver driver) {
		return save(driver, GENERAL, "Screenshot");
	}

	// ─────────────────────────────────────────────────────────────────────────
	// 2. Click screenshot — pass the WebElement that was clicked
	// ─────────────────────────────────────────────────────────────────────────
	/**
	 * Takes a screenshot after a click. Pass the element that was clicked. The
	 * element name is read automatically from its id / name / value / text.
	 *
	 * Usage: ScreenshotUtils.captureOnClick(driver, GenerateBillButton);
	 */
	public static String captureOnClick(WebDriver driver, WebElement element) {
		String name = readElementName(element);
		highlight(driver, element);
		String path = save(driver, CLICK, "Click_" + name);
		removeHighlight(driver, element);
		return path;
	}

	// ─────────────────────────────────────────────────────────────────────────
	// 3. Click screenshot — pass a label string
	// ─────────────────────────────────────────────────────────────────────────
	/**
	 * Takes a screenshot after a click. Pass any label you like.
	 *
	 * Usage: ScreenshotUtils.captureOnClick(driver, "GenerateBill");
	 */
	public static String captureOnClick(WebDriver driver, String label) {
		return save(driver, CLICK, "Click_" + label);
	}

	// ─────────────────────────────────────────────────────────────────────────
	// 4. Page load screenshot — no string or element needed
	// ─────────────────────────────────────────────────────────────────────────
	/**
	 * Waits for the page to finish loading, then takes a screenshot. You do NOT
	 * need to pass a page name or element — it works automatically.
	 *
	 * Usage: ScreenshotUtils.capturePageLoad(driver);
	 */
	public static String capturePageLoad(WebDriver driver) {
		waitForPageReady(driver);
		return save(driver, PAGELOAD, "PageLoad");
	}

	// ─────────────────────────────────────────────────────────────────────────
	// 5. Auto-suggestion screenshot — pass the input WebElement
	// ─────────────────────────────────────────────────────────────────────────
	/**
	 * Highlights the field and takes a screenshot while the dropdown is visible.
	 * Call AFTER typing into the field, BEFORE clicking a suggestion. Pass the
	 * input WebElement — the name is read automatically.
	 *
	 * Usage: ScreenshotUtils.captureAutoSuggestion(driver, ReferringDoctorField);
	 */
	public static String captureAutoSuggestion(WebDriver driver, WebElement element) {
		String name = readElementName(element);
		highlight(driver, element);
		String path = save(driver, AUTOSUGG, "AutoSugg_" + name);
		removeHighlight(driver, element);
		return path;
	}

	// ─────────────────────────────────────────────────────────────────────────
	// 6. Auto-suggestion screenshot — pass a label string
	// ─────────────────────────────────────────────────────────────────────────
	/**
	 * Same as above but you pass a label instead of the element.
	 *
	 * Usage: ScreenshotUtils.captureAutoSuggestion(driver, "ReferringDoctor");
	 */
	public static String captureAutoSuggestion(WebDriver driver, String label) {
		return save(driver, AUTOSUGG, "AutoSugg_" + label);
	}

	// ─────────────────────────────────────────────────────────────────────────
	// 7. Failure screenshot — call in a catch block
	// ─────────────────────────────────────────────────────────────────────────
	/**
	 * Takes a screenshot when a step fails. The test name, step name, and error
	 * type all go into the file name. Does NOT require a string or web element —
	 * just pass null for those if unavailable.
	 *
	 * Usage (in a catch block): } catch (Exception e) {
	 * ScreenshotUtils.captureOnFailure(driver, "RegBill", "GenerateBill", e); throw
	 * e; }
	 *
	 * Example file name:
	 * FAIL_RegBill_GenerateBill_NoSuchElementException_10-35-22_03-Jun-2026.png
	 *
	 * @param testName - the test method name, e.g. "RegBill"
	 * @param stepName - the step that failed, e.g. "GenerateBill"
	 * @param error    - the caught exception (pass null if not available)
	 */
	public static String captureOnFailure(WebDriver driver, String testName, String stepName, Throwable error) {
		if (driver == null) {
			System.err.println("[ScreenshotUtils] Cannot take failure screenshot — driver is null.");
			return null;
		}
		String errorType = (error != null) ? error.getClass().getSimpleName() : "UnknownError";
		String fileName = "FAIL_" + testName + "_" + stepName + "_" + errorType;

		System.err.println("──────────────────────────────────────────");
		System.err.println("[FAILURE]  Test : " + testName);
		System.err.println("[FAILURE]  Step : " + stepName);
		System.err.println("[FAILURE]  Error: " + (error != null ? error.getMessage() : "n/a"));
		System.err.println("──────────────────────────────────────────");

		return save(driver, FAILURE, fileName);
	}

	// ─────────────────────────────────────────────────────────────────────────
	// 8. Before Click screenshot — pass the WebElement you are about to click
	// ─────────────────────────────────────────────────────────────────────────
	/**
	 * Takes a screenshot BEFORE clicking an element. Highlights the element so it
	 * is visible in the screenshot. Call this BEFORE performing the click action.
	 *
	 * Usage: ScreenshotUtils.captureBeforeClick(driver, GenerateBillButton);
	 * GenerateBillButton.click();
	 */
	public static String captureBeforeClick(WebDriver driver, WebElement element) {
		String name = readElementName(element);
		highlight(driver, element);
		String path = save(driver, CLICK, "BeforeClick_" + name);
		removeHighlight(driver, element);
		return path;
	}

	// ─────────────────────────────────────────────────────────────────────────
	// 9. Before Click screenshot — pass a label string
	// ─────────────────────────────────────────────────────────────────────────
	/**
	 * Takes a screenshot BEFORE clicking. Pass any label you like.
	 *
	 * Usage: ScreenshotUtils.captureBeforeClick(driver, "GenerateBill");
	 * driver.findElement(By.id("generateBill")).click();
	 */
	public static String captureBeforeClick(WebDriver driver, String label) {
		return save(driver, CLICK, "BeforeClick_" + label);
	}

	// ─────────────────────────────────────────────────────────────────────────
	// Waits for page to be fully loaded — used by capturePageLoad()
	// ─────────────────────────────────────────────────────────────────────────
	private static void waitForPageReady(WebDriver driver) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(20)).until(d -> {
				String state = (String) ((JavascriptExecutor) d).executeScript("return document.readyState");
				return "complete".equals(state);
			});
		} catch (Exception e) {
			System.err.println("[ScreenshotUtils] Page load wait timed out: " + e.getMessage());
		}
	}

	// ─────────────────────────────────────────────────────────────────────────
	// Reads the element name from its attributes (no xpath or string needed)
	// Priority: id → name → value → visible text → tag
	// ─────────────────────────────────────────────────────────────────────────
	private static String readElementName(WebElement element) {
		try {
			String id = element.getAttribute("id");
			if (notEmpty(id))
				return clean(id);
			String name = element.getAttribute("name");
			if (notEmpty(name))
				return clean(name);
			String value = element.getAttribute("value");
			if (notEmpty(value))
				return clean(value);
			String text = element.getText();
			if (notEmpty(text))
				return clean(text);
			return clean(element.getTagName());
		} catch (Exception e) {
			return "element";
		}
	}

	// Adds a red border + yellow background so the element stands out in the
	// screenshot
	private static void highlight(WebDriver driver, WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].setAttribute('style','border:3px solid red;background:yellow;');", element);
		} catch (Exception ignored) {
		}
	}

	// Removes the highlight after screenshot is taken
	private static void removeHighlight(WebDriver driver, WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style','');", element);
		} catch (Exception ignored) {
		}
	}

	// Creates the folder if needed, saves the file, returns the full path
	private static String save(WebDriver driver, String folder, String prefix) {
		try {
			File dir = new File(folder);
			if (!dir.exists())
				dir.mkdirs();

			String time = new SimpleDateFormat("HH-mm-ss_dd-MMM-yyyy").format(new Date());
			String name = clean(prefix) + "_" + time + ".png";
			File target = new File(folder + name);

			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(source, target);

			System.out.println("[Screenshot] Saved → " + target.getAbsolutePath());
			return target.getAbsolutePath();

		} catch (IOException e) {
			System.err.println("[Screenshot] Save failed for '" + prefix + "': " + e.getMessage());
			return null;
		}
	}

	private static boolean notEmpty(String s) {
		return s != null && !s.trim().isEmpty();
	}

	// Removes characters not allowed in file names
	private static String clean(String raw) {
		if (raw == null || raw.isEmpty())
			return "unknown";
		return raw.replaceAll("[\\\\/:*?\"<>|\\s]", "_").replaceAll("_+", "_");
	}
}
