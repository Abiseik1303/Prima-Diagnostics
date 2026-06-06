package com.helperclass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readconfig {

	Properties p;

	public readconfig() {

		File fe = new File("C:\\Users\\Abiseik C\\eclipse-workspace\\Prima\\Configurations\\Confi.properties");

		try {
			FileInputStream files = new FileInputStream(fe);
			p =new Properties();
			p.load(files);

		} catch (Exception e) {
//			System.out.println("Exception is " +e.getMessage());
		}

	}

	public String appurl() {
		String link = p.getProperty("URL");
		return link;
	}

	public String username() {
		String username = p.getProperty("ume");
		return username;
	}

	public String password() {
		String password = p.getProperty("pass");
		return password;
	}

	public String chromebrowser() {
		String browser =p.getProperty("chrome");
		return browser;	
	}
	public String bill() {
		String  role1=p.getProperty("role1");
		return role1;	
	}
	public String r3() {
		String  role3=p.getProperty("role3");
		return role3;	
	}
	public String loc1() {
		String  loc1=p.getProperty("loc1");
		return loc1;	
	}
	
	public String salun() {
		String  salut=p.getProperty("salutation");
		return salut;

	}
	public String Invest1() {
		String  inv1=p.getProperty("Inves1");
		return inv1;

	}
	public String Invest2() {
		String  inv2=p.getProperty("Inves2");
		return inv2;

	}
	public String Invest3() {
		String  inv3=p.getProperty("Inves3");
		return inv3;

	}
	public String samplecollection() {
		String rle1=p.getProperty("samplecollection");
		return rle1;
	
	}
	
	public String stachag1() {
		String st1=p.getProperty("stachag1");
		return st1;
	
	}
	public String stachag2() {
		String st2=p.getProperty("stachag2");
		return st2;
	
	}
	public String stachag3() {
		String st3=p.getProperty("stachag3");
		return st3;
	
	}
	public String stachag4() {
		String st4=p.getProperty("stachag4");
		return st4;
	
	}
	public String lbtch() {
		String rl2=p.getProperty("enterresult");
		return rl2;
	}
	public String aprve() {
		String rl3=p.getProperty("approval");
		return rl3;
	}
	public String recep() {
		String rl1=p.getProperty("Rrception");
		return rl1;
	}
	public String credit() {
		String  client=p.getProperty("crdcntl");
		return client;
	}
	public String clttyp() {
		String clt=p.getProperty("clttype");
		return clt;
	}
	public String bus() {
		String bust=p.getProperty("bustype");
		return bust;
	}
	public String add() {
		String add=p.getProperty("addtype");
		return add;
	}
	public String cnt() {
		String cnt=p.getProperty("cnttype");
		return cnt;
	}
	public String reas() {
		String rn=p.getProperty("reason");
		return rn;
	}
	public String admin() {
		String an=p.getProperty("admn");
		return an;		
	}
	public String gpname() {
		String ge=p.getProperty("groupname");
		return ge;
		}
	public String gpcode() {
		String gcde=p.getProperty("groupcode");
		return gcde;
		}
	public String c1() {
		String Cone=p.getProperty("content1");
		return Cone;
		}
	public String c2() {
		String Ctwo=p.getProperty("content2");
		return Ctwo;
		}
	public String c3() {
		String c3=p.getProperty("content3");
		return c3;
		}
	public String c4() {
		String c4=p.getProperty("content4");
		return c4;
		}
	public String c5() {
		String c5=p.getProperty("content5");
		return c5;
		}
	public String rtename() {
		String rn=p.getProperty("Ratename");
		return rn;
	}
	public String gbi() {
		String gb=p.getProperty("feetype1");
		return gb;
	}
	public String hpkg() {
		String hp=p.getProperty("feetype2");
		return hp;
	}
	public String invf() {
		String in=p.getProperty("feetype3");
		return in;
	}
	public String invgf() {
		String igf=p.getProperty("feetype4");
		return igf;
	}
	public String pc1() {
		String p1=p.getProperty("packagename");
		return p1;
	}
	public String pc2() {
		String pc=p.getProperty("packcode");
		return pc;
	}
	public String ac1() {
		String acc=p.getProperty("acsn");
		return acc;
	}
	public String loc2() {
		String  loc2=p.getProperty("loc2");
		return loc2;	
	}
	public String idte() {
		String  idte=p.getProperty("invoicdate");
		return idte;	
	}
}

