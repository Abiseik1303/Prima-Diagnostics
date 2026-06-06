package com.TestProduct.Testcases;

import org.testng.annotations.Test;

import com.TestProduct.PageObjects.BillingPage;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.PageObjects.VisitSearch;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.Closebill;
import com.TestProduct.Utility.HelperClass;
import com.TestProduct.Utility.Readconfig;

public class Due extends BaseClass{

	Readconfig readconfig = new Readconfig();
	HelperClass helper = new HelperClass();
	
	@Test(retryAnalyzer = Zretryclass.class)
	public void due() throws Exception {
		
		LoginPage lp = new LoginPage(driver);

		lp.login(Username, Password);

		RoleSelectionPage roleselection = new RoleSelectionPage(driver);

		roleselection.selectRole(readconfig.getRole1());
		
		roleselection.selectLocation(readconfig.getLocation());
	
		BillingPage bp = new BillingPage(driver);
		bp.LabQuickBilling();
		
		bp.None();
		
		bp.PatientSalutation(readconfig.getSalutation());
		
		String name = helper.generatedname();
		String age = helper.generatedage();
		String mobno = helper.generatedmobno();

		bp.PatientName(name);

		bp.PatientAge(age);

		bp.PatientMobile(mobno);
		
		bp.PatientEmail(readconfig.getEmail());
		
		bp.ReferringDR(readconfig.getRefdr());
		
		bp.FileUpload();
		
		bp.AddTest(readconfig.getTest1());
		
		bp.Addbtn();
		
		HelperClass h = new HelperClass();
		double halfAmount = h.HalfAmount();
		
		bp.Due(halfAmount, readconfig.getAuthrizedBy(), readconfig.getAuthrizedBy());

		bp.back();
		
//		Thread.sleep(1000);
//		driver.navigate().refresh();

		BillingPage bp1 = new BillingPage(driver);
		bp1.PatientDueDetails();
		
		BillingPage bp2 = new BillingPage(driver);
		bp2.DueCollection(name, readconfig.daterange(), halfAmount);
		
		Thread.sleep(3000);
		Closebill b = new Closebill();
		
		b.escape();
		
		b.handleSRSPrintPopup();
		
		VisitSearch v = new VisitSearch(driver);
		v.visit(name);
		
		v.viewbill();

	}
}
