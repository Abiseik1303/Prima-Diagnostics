package com.TestProduct.Testcases;

import org.testng.annotations.Test;

import com.TestProduct.PageObjects.BillingPage;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.PageObjects.VisitSearch;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.HelperClass;
import com.TestProduct.Utility.Readconfig;
import com.TestProduct.Utility.ScreenshotUtils;

public class Discount extends BaseClass {

	Readconfig readconfig = new Readconfig();
	HelperClass helper = new HelperClass();
	ScreenshotUtils s = new ScreenshotUtils();

	@Test(retryAnalyzer = Zretryclass.class)
	public void discount() throws Exception {

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

		bp.Discount(readconfig.getDiscountReason(), readconfig.getAuthrizedBy(), readconfig.getAuthrizedBy(),
				readconfig.getRemarks());

		bp.AddPayment();

		bp.Generatebill();

		bp.back();

		VisitSearch v = new VisitSearch(driver);
		v.visit(name);

		v.viewbill();
		
	}
}
