package com.TestProduct.Testcases;

import com.TestProduct.Utility.HelperClass;
import org.testng.annotations.Test;

import com.TestProduct.PageObjects.AccessionPage;
import com.TestProduct.PageObjects.BillingPage;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.PageObjects.RolesPage;
import com.TestProduct.PageObjects.SampleCollectionPage;
import com.TestProduct.PageObjects.SampleSearchPage;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.Closebill;
import com.TestProduct.Utility.Readconfig;

public class TC_Outsource_008 extends BaseClass {

	Readconfig readconfig = new Readconfig();
	HelperClass helper = new HelperClass();

	@Test
	public void Notgiven() throws Throwable {
		LoginPage lp = new LoginPage(driver);

		lp.login(Username, Password);

		RoleSelectionPage rsp = new RoleSelectionPage(driver);

		rsp.selectRole(readconfig.getRole1());

		rsp.selectLocation(readconfig.getLocation());

		BillingPage bp = new BillingPage(driver);
		bp.RegistrationBilling();

		bp.None();

		bp.PatientSalutation(readconfig.getSalutation());

		String name = helper.generatedname();
		String age = helper.generatedage();
		String mobno = helper.generatedmobno();

		bp.PatientName(name);

		bp.PatientAge(age);

		bp.PatientMobile(mobno);

		bp.PatientMobile(mobno);

		bp.PatientEmail(readconfig.getEmail());

		bp.ReferringDR(readconfig.getRefdr());

		bp.FileUpload();

		bp.AddTest(readconfig.getoutsourcetest());

		bp.Addbtn();

		bp.Generatebill();

		bp.Generateworkorder();

		Closebill b = new Closebill();

		b.escape();

		b.CloseWindow();
		
		bp.back();

		RolesPage rolepage = new RolesPage(driver);
		rolepage.phelbotomist(readconfig.getAccessionrole());

		AccessionPage ap = new AccessionPage(driver);
		ap.samplesearch();

		Thread.sleep(2000);

		SampleSearchPage searchpage = new SampleSearchPage(driver);
		searchpage.checkbox(name);
		searchpage.selectstatus(readconfig.getStatusOutsource());
		searchpage.Outsourcedetails(readconfig.getActiondropdown1(), readconfig.getActiondropdown2());
		Thread.sleep(5000);

	}

}
