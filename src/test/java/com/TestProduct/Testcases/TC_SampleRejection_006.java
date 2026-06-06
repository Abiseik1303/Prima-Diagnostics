package com.TestProduct.Testcases;


import org.testng.annotations.Test;

import com.TestProduct.PageObjects.BillingPage;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.PhelebotomistPage;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.PageObjects.RolesPage;
import com.TestProduct.PageObjects.SampleCollectionPage;
import com.TestProduct.PageObjects.SampleSearchPage;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.HelperClass;
import com.TestProduct.Utility.Readconfig;

public class TC_SampleRejection_006 extends BaseClass {
	Readconfig readConfig = new Readconfig();
	HelperClass helper = new HelperClass();

	@Test(retryAnalyzer = Zretryclass.class)
	public void Rejection() throws Throwable {
		LoginPage lp = new LoginPage(driver);

		lp.login(Username, Password);
		

		Thread.sleep(5000);

		RoleSelectionPage rsp = new RoleSelectionPage(driver);

		rsp.selectRole(readConfig.getRole1());
		
		
		Thread.sleep(5000);

		rsp.selectLocation(readConfig.getLocation());
		

		Thread.sleep(5000);

		BillingPage bp = new BillingPage(driver);
		bp.RegistrationBilling();
		
		bp.None();

		bp.PatientSalutation(readConfig.getSalutation());
		

		String name = helper.generatedname();
		String age = helper.generatedage();
		String mobno = helper.generatedmobno();

		bp.PatientName(name);
		
		bp.PatientAge(age);
		

		bp.PatientMobile(mobno);
		

		bp.AddTest(readConfig.getTest1());
		

		bp.Addbtn();
		

		bp.Generatebill();
		

		Thread.sleep(4000);
		SampleCollectionPage SampleCollect = new SampleCollectionPage(driver);

		SampleCollect.Samplestatus(readConfig.getStatusReject());
		

		Thread.sleep(2000);

		SampleCollect.Reason(readConfig.getReasonForReject());
		
		Thread.sleep(3000);
		SampleCollect.billprintclose();
		
		
		Thread.sleep(2000);

		RolesPage rolepage = new RolesPage(driver);
		rolepage.phelbotomist(readConfig.getphelborole());

		PhelebotomistPage phelo = new PhelebotomistPage(driver);
		Thread.sleep(2000);
		phelo.samplesearch();

		Thread.sleep(1000);

		SampleSearchPage searchpage = new SampleSearchPage(driver);
		searchpage.checkbox(name);
		searchpage.selectstatus(readConfig.getStatusReject());
		searchpage.Search(readConfig.getActiondropdown());

		Thread.sleep(1000);

		SampleCollectionPage SampleCollect1 = new SampleCollectionPage(driver);
		SampleCollect1.GenerateWorkorder();
		Thread.sleep(2000);
		SampleCollect1.BarcodeClose();
		
		Thread.sleep(2000);

	}
}
