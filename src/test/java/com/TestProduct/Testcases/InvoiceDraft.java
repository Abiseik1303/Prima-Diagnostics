package com.TestProduct.Testcases;

import org.testng.annotations.Test;

import com.TestProduct.PageObjects.BillingPage;
import com.TestProduct.PageObjects.ClientPaymentTracker;
import com.TestProduct.PageObjects.Invoice;
import com.TestProduct.PageObjects.LoginPage;
import com.TestProduct.PageObjects.RoleSelectionPage;
import com.TestProduct.PageObjects.RolesPage;
import com.TestProduct.Utility.BaseClass;
import com.TestProduct.Utility.HelperClass;
import com.TestProduct.Utility.Readconfig;

public class InvoiceDraft extends BaseClass{

	Readconfig readconfig = new Readconfig();
	HelperClass helper = new HelperClass();
	
	@Test(retryAnalyzer = Zretryclass.class)
	public void invoiceDraft() throws Exception {
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
		
		bp.client(readconfig.Clientcode());
		
		bp.ReferringDR(readconfig.getRefdr());
		
		bp.FileUpload();
		
		bp.AddTest(readconfig.getTest1());
		
		bp.Addbtn();
		
		bp.Generatebill();
		
		bp.back();
		
		RolesPage r = new RolesPage(driver);
		r.CreditController(readconfig.getCreditcontroller());
		
		Invoice i = new Invoice(driver);
		i.schedules();
		
		Invoice i1 = new Invoice(driver);
		i1.invoice1(readconfig.Bussinesstype(), readconfig.Client());
		
		Invoice i2 = new Invoice(driver);
		i2.selectclient();
		
		i2.generateInvoice(readconfig.InvoiceType2());
		
		ClientPaymentTracker c = new ClientPaymentTracker(driver);

		c.tracker();
		
		c.trackerinvoiceDraft(readconfig.Client(), readconfig.SelectAction());
		
		
}
}
