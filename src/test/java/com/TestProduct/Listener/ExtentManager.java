package com.TestProduct.Listener;



import com.TestProduct.Utility.HelperClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			return createInstance();

		} else {
			return extent;
		}
	}

	public static ExtentReports createInstance() {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")
				+ "/Reports/AutomationReport" + HelperClass.getCurrrentDateTime() + ".html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("LIS Product");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;

	}

}
