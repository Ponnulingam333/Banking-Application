package com.backend;

import java.util.Date;
public class customerinformation {
public	String fullname;
public 	String address;
public 	String phoneno;
public 	String emailid;
public	String accounttype;
public 	int amount;
public 	Date date;
public	String idproof;
public	String filename;
public long accountno;
public String password;
public String bankname="successbank";

public boolean photoformatchecker(String str) {
/*	String strarray[] =str.split(".");
 System.out.println("Before Loop");
	for(int i=0;i<strarray.length;i++) {
		
		if(strarray[i]=="jpg") {
			return true;
		}
		System.out.println(strarray[i]);
	}
	return false;*/
	System.out.println(str.contains(".jpg"));
	        if(  str.contains(".jpg")) {
	        return true;	
	        }
	return false;
	
}

public String getFullname() {
	return fullname;
}

public void setFullname(String fullname) {
	this.fullname = fullname;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPhoneno() {
	return phoneno;
}

public void setPhoneno(String phoneno) {
	this.phoneno = phoneno;
}

public String getEmailid() {
	return emailid;
}

public void setEmailid(String emailid) {
	this.emailid = emailid;
}

public String getAccounttype() {
	return accounttype;
}

public void setAccounttype(String accounttype) {
	this.accounttype = accounttype;
}

public int getAmount() {
	return amount;
}

public void setAmount(int amount) {
	this.amount = amount;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getIdproof() {
	return idproof;
}

public void setIdproof(String idproof) {
	this.idproof = idproof;
}

public String getFilename() {
	return filename;
}

public void setFilename(String filename) {
	this.filename = filename;
}

public long getAccountno() {
	return accountno;
}

public void setAccountno(long accountno) {
	this.accountno = accountno;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getBankname() {
	return bankname;
}

public void setBankname(String bankname) {
	this.bankname = bankname;
}
         public String  getpasswordupdate() {
        	 return "\nAccount Holder Fullname : "+fullname+"\nThe Accountnumber : "+ accountno +
        			 "\nThe password : "+ password ;
         }
         
         public String  getnewpasswordupdate(String pass) {
        	 return "\nAccount Holder Fullname : "+fullname+"\nThe Accountnumber : "+ accountno +
        			 "\nThe old password : " + pass+
        			 "\nThe new password : "+ password ;
         }
@Override
public String toString() {
	return "customerinformation:\n"
			+ "fullname:" + fullname + "\n address:" + address + "\n phoneno:" + phoneno + "\nemailid:"
			+ emailid + " \naccounttype=" + accounttype + "\namount=" + amount + "\ndate=" + date + "\nidproof="
			+ idproof + "\nfilename=" + filename + "\naccountno=" + accountno + "\n password=" + password + "\nbankname="
			+ bankname ;
}

}