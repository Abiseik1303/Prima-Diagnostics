package com.TestProduct.Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.TestProduct.Utility.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ExtentTestNGITestListener implements ITestListener {

    static ExtentReports extent = ExtentManager.getInstance();
    ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();

    public synchronized void onFinish(ITestContext context) {
        System.out.println("LOG:INFO- Report getting generated");
        extent.flush();
        System.out.println("LOG:INFO- Report Generated");
    }

    public synchronized void onTestStart(ITestResult result) {
        ExtentTest child = extent.createTest(result.getMethod().getMethodName());
        parentTest.set(child);
    }

    public synchronized void onTestSuccess(ITestResult result) {
        parentTest.get().pass("Test Passed");
    }

    /**
     * On failure:
     *  1. Capture a screenshot via BaseClass (embeds test name + step name in file name).
     *  2. Attach the screenshot image inline to the Extent HTML report.
     *  3. Log the failed step name and full exception message to the report node.
     */
    public synchronized void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        Throwable throwable = result.getThrowable();
        String failedStep = BaseClass.currentStepName;

        // ── Capture screenshot ────────────────────────────────────────────────
        String screenshotPath = BaseClass.captureFailureScreenshot(testName, throwable);

        // ── Log to Extent report ──────────────────────────────────────────────
        ExtentTest test = parentTest.get();

        // Step and error detail as text
        test.fail("<b>Test Failed</b>"
                + "<br><b>Failed at step :</b> " + failedStep
                + "<br><b>Error         :</b> " + (throwable != null ? throwable.getMessage() : "Unknown error"));

        // Attach screenshot inline when capture succeeded
        if (screenshotPath != null) {
            try {
                test.fail(
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath,
                        "Failure @ " + failedStep).build()
                );
            } catch (Exception e) {
                test.fail("Screenshot captured but could not be attached: " + screenshotPath);
                System.err.println("[Listener] Could not attach screenshot to report: " + e.getMessage());
            }
        } else {
            test.fail("Screenshot capture failed — check console for details.");
        }
    }

    public synchronized void onTestSkipped(ITestResult result) {
        parentTest.get().skip("Test Skipped");
    }
}
