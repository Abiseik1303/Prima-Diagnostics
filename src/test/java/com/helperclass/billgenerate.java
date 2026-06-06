package com.helperclass;


import org.apache.commons.lang3.RandomStringUtils;


public class billgenerate {
	
	public  String generatedname() {
		String name = RandomStringUtils.randomAlphabetic(8);
		return name;
	}
	public  String generatedage() {
		String age = RandomStringUtils.randomNumeric(2);
		return age;
	}
	public String generatedmblno() {
		String mbl = RandomStringUtils.randomNumeric(10);
		return mbl;
	}
	public String generatedclientcode() {
		String ccde= RandomStringUtils.randomAlphanumeric(4);
		return ccde;
	}
	public String generateaddres() {
		String address= RandomStringUtils.randomAlphabetic(15);
		return address;
	}
	public String groupname() {
		String gnm= RandomStringUtils.randomAlphabetic(15);
		return gnm;
	}
	public String groupcode() {
		String gcd= RandomStringUtils.randomAlphabetic(5);
		return gcd;
	}
	
}
