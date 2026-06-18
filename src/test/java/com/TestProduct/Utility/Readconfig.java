package com.TestProduct.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	Properties pro;

	public Readconfig() {
		File file = new File("C:\\Users\\dell\\eclipse-workspace\\Prima-Diagnostics\\Configurations\\Config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is..." + e.getMessage());
		}

	}

	public String getApplicationURL() {
		String URL = pro.getProperty("baseURL");
		return URL;
	}

	public String getUsername() {
		String Uname = pro.getProperty("Username");
		return Uname;
	}
	
	public String getOrganization() {
		String URL = pro.getProperty("OrgName");
		return URL;
	}
	
	public String editpatient() {
		String Uname = pro.getProperty("Editpatient1");
		return Uname;
	}
	
	public String editpatientSalutation() {
		String Uname = pro.getProperty("Editpatient2");
		return Uname;
	}
	
	public String editpatientName() {
		String Uname = pro.getProperty("Editpatient3");
		return Uname;
	}

	public String getPassword() {
		String Pwd = pro.getProperty("Password");
		return Pwd;
	}
	
	public String getEmail() {
		String mail = pro.getProperty("Email");
		return mail;
	}
	
	public String getRefdr() {
		String dr = pro.getProperty("Refdr");
		return dr;
	}

	public String getChromebrowser() {
		String Chromepath = pro.getProperty("Chromepath");
		return Chromepath;
	}

	public String getRole1() {
		String Role = pro.getProperty("Role1");
		return Role;
	}

	public String getRole2() {
		String Role = pro.getProperty("Role2");
		return Role;
	}
	
	public String getRole3() {
		String getRole3 = pro.getProperty("Role3");
		return getRole3;

	} 
	
	public String getRole4() {
		String getRole4 = pro.getProperty("Role4");
		return getRole4;

	} 
	
	public String getRole5() {
		String getRole5 = pro.getProperty("Role5");
		return getRole5;

	} 
	
	public String getRole6() {
		String getRole6 = pro.getProperty("Role6");
		return getRole6;

	} 

	public String getLocation() {
		String Location = pro.getProperty("Location1");
		return Location;
	}

	public String getSalutation() {
		String Salutation = pro.getProperty("Salutation");
		return Salutation;
	}
	
	public String getAutoTest1() {
		String Test = pro.getProperty("AutoTest1");
		return Test;
	}
	
	public String getAutoTest2() {
		String Test = pro.getProperty("AutoTest3");
		return Test;
	}

	public String getTest1() {
		String Test = pro.getProperty("Test1");
		return Test;
	}

	public String getTest2() {
		String Test = pro.getProperty("Test2");
		return Test;
	}
	
	public String getTest4() {
		String Test = pro.getProperty("Test4");
		return Test;
	}

	public String getStatus() {
		String Status = pro.getProperty("Status");
		return Status;
	}

	public String getStatusNotgiven() {
		String Status = pro.getProperty("Status1");
		return Status;
	}

	public String getStatusReject() {
		String Status = pro.getProperty("Status2");
		return Status;
	}

	public String getStatusOutsource() {
		String Status = pro.getProperty("Status3");
		return Status;
	}
	
	public String getstatusCollected() {
		String collected = pro.getProperty("Status4");
		return collected;
	}

	public String getReasonForNotGiven() {
		String Reason = pro.getProperty("ReasonforNotgiven");
		return Reason;
	}

	public String getReasonForReject() {
		String Reason = pro.getProperty("ReasonforReject");
		return Reason;
	}

	public String getActiondropdown() {
		String collectsample = pro.getProperty("Action");
		return collectsample;
	}

	public String getActiondropdown1() {
		String sendout = pro.getProperty("Action1");
		return sendout;
	}

	public String getActiondropdown2() {
		String receiveout = pro.getProperty("Action2");
		return receiveout;
	}

	public String getphelborole() {
		String Role = pro.getProperty("postion");
		return Role;
	}

	public String getLabTechrole() {
		String Role = pro.getProperty("postion1");
		return Role;
	}
	
	public String getSeniorLab() {
		String Role = pro.getProperty("position7");
		return Role;
	}

	public String getPathorole() {
		String Role = pro.getProperty("postion3");
		return Role;
	}

	public String getAccessionrole() {
		String Role = pro.getProperty("postion4");
		return Role;
	}
	
	public String getReceptionrole() {
		String Role = pro.getProperty("postion5");
		return Role;
	}
	public String getAdminrole() {
		String Role = pro.getProperty("postion6");
		return Role;
	}
	
	public String getCenterManagerrole() {
		String Role = pro.getProperty("position8");
		return Role;
	}
	
	public String getCreditcontroller() {
		String Role = pro.getProperty("position9");
		return Role;
	}
	
	public String gettestvalue() {
		String value = pro.getProperty("value");
		return value;
	}

	public String getclienttype() {
		String clienttype = pro.getProperty("cctype");
		return clienttype;
	}

	public String getclientname() {
		String name = pro.getProperty("cname");
		return name;
	}

	public String getclientcode() {
		String code = pro.getProperty("ccode");
		return code;
	}

	public String getbussinestype() {
		String btype = pro.getProperty("btype");
		return btype;
	}

	public String getinvoicecycle() {
		String incycle = pro.getProperty("invoicecycle");
		return incycle;
	}

	public String getaddresstype() {
		String addresstype = pro.getProperty("addresstype");
		return addresstype;
	}

	public String getaddress() {
		String address = pro.getProperty("address");
		return address;
	}

	public String getcity() {
		String city = pro.getProperty("city");
		return city;
	}

	public String getmobilenumber() {
		String mobno = pro.getProperty("mobile");
		return mobno;
	}

	public String getemailid() {
		String email = pro.getProperty("invoiceemail");
		return email;
	}

	public String getcontacttype() {
		String contatcttype = pro.getProperty("ctype");
		return contatcttype;
	}

	public String getcontactname() {
		String contatctname = pro.getProperty("clname");
		return contatctname;
	}

	public String getinvname() {
		String invname = pro.getProperty("invname");
		return invname;
	}

	public String getinvcode() {
		String invcode = pro.getProperty("invcode");
		return invcode;
	}

	public String gettype() {
		String type = pro.getProperty("invtype");
		return type;
	}

	public String getratetype() {
		String ratetype = pro.getProperty("Rtype");
		return ratetype;
	}

	public String getratecard() {
		String rate = pro.getProperty("ratecard");
		return rate;
	}

	public String getdate() {
		String dte = pro.getProperty("DD");
		return dte;

	}

	public String getmonth() {
		String mon = pro.getProperty("MM");
		return mon;

	}

	public String getyear() {
		String yrs = pro.getProperty("YY");
		return yrs;
	}

	public String getgroupname() {
		String grp = pro.getProperty("Groupname");
		return grp;
	}

	public String getgroupcode() {
		String grpcode = pro.getProperty("Groupcode");
		return grpcode;
	}

	public String getgrpcontent1() {
		String Parameter = pro.getProperty("Content1");
		return Parameter;
	}

	public String getgrpcontent2() {
		String Parameter = pro.getProperty("Content2");
		return Parameter;

	}

	public String getgrpcontent3() {
		String Parameter = pro.getProperty("Content3");
		return Parameter;

	}

	public String getsubgroup() {
		String sgroup = pro.getProperty("SubGroup");
		return sgroup;

	}

	public String getoutsourcetest() {
		String outsource = pro.getProperty("OutsourceTest");
		return outsource;

	}
	
	public String getpackagename() {
		String getname = pro.getProperty("Packagename");
		return getname;

	}
	
	public String getpackagecode() {
		String getcode = pro.getProperty("Packagecode");
		return getcode;

	}
	
	public String getbillingname() {
		String getbillname = pro.getProperty("Billingname");
		return getbillname;

	}
	
	public String getpkgcont1() {
		String getcontent1 = pro.getProperty("packagecontent1");
		return getcontent1;

	}
	
	public String getpkgcont2() {
		String getcontent2 = pro.getProperty("packagecontent2");
		return getcontent2;

	}
	
	public String getpkgcont3() {
		String getcontent3 = pro.getProperty("packagecontent3");
		return getcontent3;

	}
	public String getpkgcont4() {
		String getcontent4 = pro.getProperty("packagecontent4");
		return getcontent4;

	}
	public String getpkgcont5() {
		String getcontent5 = pro.getProperty("packagecontent5");
		return getcontent5;

	}
	public String getpkgcont6() {
		String getcontent6 = pro.getProperty("packagecontent6");
		return getcontent6;

	}
	
	public String  getdepartment(){
		String getdepartment = pro.getProperty("Department");
		return getdepartment;

	}
	
	public String  getdepartmentheader(){
		String getdepartmentheader = pro.getProperty("DepartmentHeader");
		return getdepartmentheader;

	}
	
	public String  getsample(){
		String getsample = pro.getProperty("Sample");
		return getsample;

	}
	
	public String  getadditive(){
		String getadditive = pro.getProperty("Additive");
		return getadditive;

	}
	
	public String getresultvalue() {
		String getresultvalue = pro.getProperty("ResultValue");
		return getresultvalue;

	}
	
	public String getRangetype() {
		String getRangetype = pro.getProperty("Rangetype");
		return getRangetype;

	}
	
	public String  getgender(){
		String getgender = pro.getProperty("Gender");
		return getgender;

	}
	
	public String getcategory() {
		String getcategory = pro.getProperty("Category");
		return getcategory;

	}
	
	public String getvaluetype() {
		String getvaluetype = pro.getProperty("Valuetype");
		return getvaluetype;

	}
	
	public String getvalue1() {
		String getvalue1 = pro.getProperty("Value1");
		return getvalue1;

	}
	
	public String getvalue2() {
		String getvalue2 = pro.getProperty("Value2");
		return getvalue2;

	}
	
	public String getusername() {
		String getusername = pro.getProperty("UserName");
		return getusername;

	}
	
	public String getemail() {
		String getemail = pro.getProperty("Email");
		return getemail;

	}
	
	public String getaddress1() {
		String getaddress1 = pro.getProperty("Address1");
		return getaddress1;

	}
	
	public String getcity1() {
		String getcity1 = pro.getProperty("City");
		return getcity1;

	}
	
	public String getmobilenum() {
		String getmobilenum = pro.getProperty("MobileNum");
		return getmobilenum;

	}
	
	public String getempID() {
		String getempID = pro.getProperty("EmpID");
		return getempID;

	}
	
	public String getNewpassword() {
		String getNewpassword = pro.getProperty("Newpassword");
		return getNewpassword;

	}
	

	public String  getmasterupdation(){
		String getmasterupdation = pro.getProperty("Updation");
		return getmasterupdation;

	}
	
	public String GetdropdownCancel() {
		String cancel = pro.getProperty("Dropdown");
		return cancel;

	}
	
	public String getResultentry1() {
		String value1 = pro.getProperty("Value1");
		return value1;

	}
	
	public String getResultentry2() {
		String value1 = pro.getProperty("Value2");
		return value1;

	}
	
	public String getOrgname() {
		String orgname = pro.getProperty("OrgName");
		return orgname;

	}
	
	public String getOrgLocation() {
		String orgLocation = pro.getProperty("OrgLocation");
		return orgLocation;

	}
	
	public String gettranslocation() {
		String translocation = pro.getProperty("TransferOrgName");
		return translocation;

	}
	
	public String getDiscount() {
		String Discount = pro.getProperty("Discount");
		return Discount;

	}
	
	public String getDiscountReason() {
		String DiscountReason = pro.getProperty("Reason");
		return DiscountReason;

	}
	
	public String getAuthrizedBy() {
		String getAuthrizedBy = pro.getProperty("AuthrizedBy");
		return getAuthrizedBy;

	}
	
	public String getRemarks() {
		String Remarks = pro.getProperty("Remarks");
		return Remarks;

	}
	
	public String daterange() {
		String daterange = pro.getProperty("DateRange");
		return daterange;

	}
	
	public String rerun() {
		String rerun = pro.getProperty("Status5");
		return rerun;

	}
	
	public String reollect() {
		String recollect = pro.getProperty("Status6");
		return recollect;

	}
	
	public String RegistrationDate() {
		String date = pro.getProperty("RegistrationDate");
		return date;

	}
	
	public String  Onlinepayment(){
		String cash = pro.getProperty("PaymentType1");
		return cash;

	}
	
	public String CardPayment() {
		String card = pro.getProperty("PaymentType2");
		return card;

	}
	
	public String CreditNote() {
		String note = pro.getProperty("PaymentType3");
		return note;

	}
	
	public String UPIPayments() {
		String upi = pro.getProperty("PaymentType4");
		return upi;

	}
	
	public String CardType1() {
		String type = pro.getProperty("CardType1");
		return type;

	}
	
	public String CardType2() {
		String type = pro.getProperty("CardType2");
		return type;

	}
	
	public String CardType3() {
		String type = pro.getProperty("CardType3");
		return type;

	}
	
	public String CardNumber() {
		String num = pro.getProperty("CardNumber1");
		return num;

	}
	
	public String CardNumber2() {
		String num = pro.getProperty("CardNumber2");
		return num;

	}
	
	public String CardNumber3() {
		String num = pro.getProperty("CardNumber3");
		return num;

	}
	public String HolderName() {
		String hld = pro.getProperty("AccountHolderName");
		return hld;

	}
	
	public String Clientcode() {
		String clnt = pro.getProperty("Clientcode");
		return clnt;

	}
	
	public String Client() {
		String clnt = pro.getProperty("ClientName");
		return clnt;

	}
	
	public String Bussinesstype() {
		String btype = pro.getProperty("Bussinesstype");
		return btype;

	}
	
	public String InvoiceType() {
		String type = pro.getProperty("InvoiceType");
		return type;

	} 
	
	public String InvoiceType2() {
		String type = pro.getProperty("InvoiceType2");
		return type;

	} 
	
	public String SelectAction() {
		String act = pro.getProperty("SelectAction");
		return act;

	}
	
	public String bulkclientname() {
		String name = pro.getProperty("ClientBulk");
		return name;

	}
	
	public String bulkclientcode() {
		String code = pro.getProperty("Bulkcode");
		return code;

	}
	
	public String Showpdf() {
		String pdf = pro.getProperty("SelectAction2");
		return pdf;

	}
	
	
/*	public String  {
		String  = pro.getProperty("");
		return ;

	}  */

}
