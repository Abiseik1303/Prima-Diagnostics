package com.TestProduct.Testcases;

import org.testng.annotations.Test;

import com.TestProduct.PageObjects.BillingPage;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.PaymentModes;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.PageObjects.VisitSearch;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.HelperClass;
import com.TestProduct.Utility.Readconfig;

public class DifferentPaymentMode extends BaseClass{

	
	Readconfig readconfig = new Readconfig();
	HelperClass helper = new HelperClass();
	
	@Test(retryAnalyzer = Zretryclass.class)
	public void DifferentPayment() throws Exception {
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
	
		bp.scrolldown1();
		
		HelperClass h = new HelperClass();
		double halfAmount = h.QuatraAmount();
		
		PaymentModes p = new PaymentModes(driver);
		p.Onlinepayment(readconfig.Onlinepayment(), halfAmount);
		
		PaymentModes p1 = new PaymentModes(driver);
		p1.Cardpayment(readconfig.CardPayment(), halfAmount,readconfig.CardType1(),
				readconfig.CardNumber(), readconfig.HolderName());
		
		PaymentModes p2 = new PaymentModes(driver);
		p2.CreditNote(readconfig.CreditNote(), halfAmount, readconfig.CardType2(), readconfig.CardNumber2());
	
		PaymentModes p3 = new PaymentModes(driver);
		p3.UpiPayments(readconfig.UPIPayments(), readconfig.CardType3(),  halfAmount,readconfig.CardNumber3());
		
		bp.Generatebill();
		
		bp.back();
		
		VisitSearch v = new VisitSearch(driver);
		v.visit(name);
		
		v.viewbill();
		
}
}