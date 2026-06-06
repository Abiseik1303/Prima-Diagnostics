package com.TestProduct.Testcases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Zretryclass implements IRetryAnalyzer{

	 int fail  = 0;
	 
	    int retry = 1;  // number of times to retry

	    @Override
	    public boolean retry(ITestResult result) {
	        if (fail < retry) {
	            fail++;
	            System.out.println("[Retry] Retrying failed test: "
	                + result.getMethod().getMethodName()
	                + " | Attempt: " + (fail + 1));
	            return true;
	        }
	        return false;
	    }

}
