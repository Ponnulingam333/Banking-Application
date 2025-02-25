package com.bank.application;



import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.backend.customerinformation;

public class DAO {
	public boolean checkadmin(String user, String pass) throws SQLException, ClassNotFoundException {
		String query = "select * from admin_info where username=? and pass=?";
		Connection con;

		con = DBconnection.getConnection();
		PreparedStatement pst;

		pst = con.prepareStatement(query);

		pst.setString(1, user);
		pst.setString(2, pass);
		ResultSet rt = pst.executeQuery();
		while (rt.next()) {
			return true;
		}
		return false;
	}

	public void createaccount(customerinformation c) throws Exception {
		String query = "Insert into customerinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = DBconnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, c.fullname);
		pst.setString(2, c.address);
		pst.setString(3, c.phoneno);
		pst.setString(4, c.emailid);
		pst.setString(5, c.accounttype);
		pst.setInt(6, c.amount);
		java.sql.Date sdate = new java.sql.Date(c.date.getTime());
		pst.setDate(7, sdate);
		pst.setString(8, c.idproof);
		FileInputStream in = new FileInputStream(c.filename);
		pst.setBlob(9, in);
		c.accountno = getaccno();
		pst.setString(10,c.filename);
		pst.setLong(11, c.accountno);
		pst.setString(12, c.password);
		pst.setString(13, "Success Bank");
		int rows = pst.executeUpdate();

		System.out.println("Number of rows affected is : " + rows);
		/*
		 * FileInputStream fis = null; for (FileItem fi : c.multifiles) { //
		 * fi.write(new File("D:\\eclipse-workspace\\.metadata\\fileuploaddemo\\"
		 * +fi.getName())); fi.write(new File("D:\\temporaryserver\\" +fi.getName()));
		 * fis =new FileInputStream("D:\\temporaryserver\\" +fi.getName()); }
		 * pst.setBlob(8,fis);
		 */}
	public void updateaccount(customerinformation c) throws Exception {
		String query = "Insert into customerinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = DBconnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, c.fullname);
		pst.setString(2, c.address);
		pst.setString(3, c.phoneno);
		pst.setString(4, c.emailid);
		pst.setString(5, c.accounttype);
		pst.setInt(6, c.amount);
		java.sql.Date sdate = new java.sql.Date(c.date.getTime());
		pst.setDate(7, sdate);
		pst.setString(8, c.idproof);
		FileInputStream in = new FileInputStream(c.filename);
		pst.setBlob(9, in);
		pst.setString(10,c.filename);
		pst.setLong(11, c.accountno);
		pst.setString(12, c.password);
		pst.setString(13, "Success Bank");
		int rows = pst.executeUpdate();

		System.out.println("Number of rows affected is : " + rows);
		/*
		 * FileInputStream fis = null; for (FileItem fi : c.multifiles) { //
		 * fi.write(new File("D:\\eclipse-workspace\\.metadata\\fileuploaddemo\\"
		 * +fi.getName())); fi.write(new File("D:\\temporaryserver\\" +fi.getName()));
		 * fis =new FileInputStream("D:\\temporaryserver\\" +fi.getName()); }
		 * pst.setBlob(8,fis);
		 */}


	public void createaccinfo(customerinformation i) throws ClassNotFoundException, SQLException {
		String query = "insert into accountinformation(pass_word,bankname) values(?,?)";
		Connection con = DBconnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		Random random = new Random();
		i.password =Integer.toString(random.nextInt(90000));
		pst.setString(1, i.password);
		pst.setString(2, i.bankname);
		int rows = pst.executeUpdate();
		System.out.println("number of rows affected is: " + rows);
	}
	public void updateaccinfo(customerinformation i) throws ClassNotFoundException, SQLException {
		String query = "insert into accountinformation values(?,?,?)";
		Connection con = DBconnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		Random random = new Random();
		i.password =Integer.toString(random.nextInt(90000));
		pst.setLong(1,i.accountno);
		pst.setString(2, i.password);
		pst.setString(3, i.bankname);
		int rows = pst.executeUpdate();
		System.out.println("number of rows affected is: " + rows);
	}

	public long getaccno() throws ClassNotFoundException, SQLException {
		String query1 = "select accountnumber from accountinformation order by accountnumber desc limit 1";
		Connection con = DBconnection.getConnection();
		//PreparedStatement pst = con.prepareStatement(query1);
		Statement st = con.createStatement();
		ResultSet rt1 = st.executeQuery(query1);
		while (rt1.next()) {
			return rt1.getLong(1);
		}
		return 0;
	}
	  public void deleteaccount(long accno) throws ClassNotFoundException, SQLException {
		  String query1 ="delete from customerinfo where accountnumber=?";
			Connection con = DBconnection.getConnection();
		  PreparedStatement pst1 = con.prepareStatement(query1);
			pst1.setLong(1, accno);
			int rows1 =pst1.executeUpdate();
			System.out.println("Number of rows affected is: "+rows1);
		  String query2 = "delete from accountinformation where accountnumber=?";
			PreparedStatement pst2 = con.prepareStatement(query2);
			pst2.setLong(1,accno);
		int rows2=pst2.executeUpdate();
		System.out.println("Number of rows affected is: "+rows2);
		
	  }
	  public void deleteaccount(long accno,String name) throws ClassNotFoundException, SQLException {
		  String query1 ="delete from customerinfo where accountnumber=? and full_name=?";
			Connection con = DBconnection.getConnection();
		  PreparedStatement pst1 = con.prepareStatement(query1);
			pst1.setLong(1, accno);
			pst1.setString(2,name);
			int rows1 =pst1.executeUpdate();
			System.out.println("Number of rows affected is: "+rows1);
		  String query2 = "delete from accountinformation where accountnumber=?";
			PreparedStatement pst2 = con.prepareStatement(query2);
			pst2.setLong(1,accno);
		int rows2=pst2.executeUpdate();
		System.out.println("Number of rows affected is: "+rows2);
		
	  }
	 
	  
	  public customerinformation displayinfo(Long accno,String name) throws ClassNotFoundException, SQLException, IOException {
		  System.out.println("called displayinfo");
		  String query="select * from customerinfo where accountnumber=? and full_name=?";
		  Connection con =DBconnection.getConnection();
		PreparedStatement pst =  con.prepareStatement(query);
		               pst.setLong(1,accno);
		               pst.setString(2,name);
		     ResultSet rt = pst.executeQuery();
		     customerinformation custom =new customerinformation();
		   while(rt.next()) {
			   System.out.println(rt.getString(1));
			   System.out.println(rt.getString(2));
			custom.fullname=rt.getString(1);
			custom.address=	rt.getString(2);
			custom.phoneno=rt.getString(3);
			custom.emailid=	rt.getString(4);
			custom.accounttype=	rt.getString(5);
			custom.amount=rt.getInt(6);
			custom.date =rt.getDate(7);
			custom.idproof=rt.getString(8);
			
				  Blob blob=rt.getBlob(9);
				   custom.filename=rt.getString(10);
				   byte bytearray[] =blob.getBytes(1,(int)blob.length());
				   System.out.println(custom.getFilename());
				   System.out.println(custom.photoformatchecker(custom.filename));
				   if(custom.photoformatchecker(custom.filename)) {
				    FileOutputStream out =
new FileOutputStream(
		"D:\\backup files\\eclipse-workspace\\.metadata\\BankingApplication\\src\\main\\webapp\\Bloboutput\\"+custom.fullname+".jpg");
				    out.write(bytearray);
				   out.close(); 
				   custom.filename=	"Bloboutput\\"+custom.fullname+".jpg";
				   System.out.println(custom.filename);
				   }
				   else {
					   FileOutputStream out =
	new FileOutputStream("D:\\backup files\\eclipse-workspace\\.metadata\\BankingApplication\\src\\main\\webapp\\Bloboutput\\"+custom.fullname+".png");
		  				    out.write(bytearray);
							   				   out.close();
			 custom.filename="Bloboutput\\"+custom.fullname+".png";
				   }
			custom.accountno=rt.getLong(11);
				custom.password =rt.getString(12);
			custom.bankname=rt.getString(13);
		   }
		return custom;
	
	  }
	  public boolean checkcustomer(Long accno) throws SQLException, ClassNotFoundException {
			String query = "select * from customerinfo where accountnumber=?";
			Connection con;

			con = DBconnection.getConnection();
			PreparedStatement pst;

			pst = con.prepareStatement(query);

			pst.setLong(1,accno);
			ResultSet rt = pst.executeQuery();
			while (rt.next()) {
				return true;
			}
			return false;
		}
	  public customerinformation getDetails(Long accno) throws ClassNotFoundException, SQLException, IOException {
		  String query="select * from customerinfo where accountnumber=?";
		  Connection con =DBconnection.getConnection();
			PreparedStatement pst =  con.prepareStatement(query);
			               pst.setLong(1,accno);
			     ResultSet rt = pst.executeQuery();
			     customerinformation custom =new customerinformation();
			   while(rt.next()) {
				   System.out.println(rt.getString(1));
				   System.out.println(rt.getString(2));
				custom.fullname=rt.getString(1);
				custom.address=	rt.getString(2);
				custom.phoneno=rt.getString(3);
				custom.emailid=	rt.getString(4);
				custom.accounttype=	rt.getString(5);
				custom.amount=rt.getInt(6);
				custom.date =rt.getDate(7);
				custom.idproof=rt.getString(8);
				
					  Blob blob=rt.getBlob(9);
					   custom.filename=rt.getString(10);
					   byte bytearray[] =blob.getBytes(1,(int)blob.length());
					   System.out.println(custom.getFilename());
					   if(custom.photoformatchecker(custom.filename)) {
			  System.out.println(custom.photoformatchecker(custom.filename));
					    FileOutputStream out =
	new FileOutputStream(
			"D:\\backup files\\eclipse-workspace\\.metadata\\BankingApplication\\src\\main\\webapp\\Bloboutput\\"+custom.fullname+".jpg");
					    out.write(bytearray);
					   out.close(); 
					   custom.filename=	"Bloboutput\\"+custom.fullname+".jpg";
					   System.out.println(custom.filename);
					   }
					   else {
						   FileOutputStream out =
		new FileOutputStream("D:\\backup files\\eclipse-workspace\\.metadata\\BankingApplication\\src\\main\\webapp\\Bloboutput\\"+custom.fullname+".png");
			  				    out.write(bytearray);
								   				   out.close();
				 custom.filename="Bloboutput\\"+custom.fullname+".png";
					   }
				custom.accountno=rt.getLong(11);
					custom.password =rt.getString(12);
				custom.bankname=rt.getString(13);
			   }
			return custom;
			  }
	  public boolean customerverificator(Long accno,String password) throws ClassNotFoundException, SQLException{
		  String query ="select * from customerinfo where accountnumber=? and pass_word=?";
		  Connection con;
			con = DBconnection.getConnection();
			PreparedStatement pst=  con.prepareStatement(query);
			pst.setLong(1,accno);
			pst.setString(2,password);
			ResultSet rt =pst.executeQuery();
			while(rt.next()) {
				System.out.println(true);
				return true;	
			}
			return false;	  
	  }

	  public boolean update(customerinformation c1) throws ClassNotFoundException, SQLException, IOException {
		if(checkcustomer(c1.accountno)) {
		customerinformation c2 =getDetails(c1.accountno);
		System.out.println(c2.accountno);
			if(c1.accountno==c2.accountno&&c1.fullname==c2.fullname&&
					c1.address==c2.address&&c1.phoneno==c2.phoneno&&
			c1.emailid==c2.emailid&&
			c1.accounttype==c2.accounttype&&
			c1.amount==c2.amount&&c1.date==c2.date&&
			c1.idproof==c2.idproof&&
			c1.filename==c2.filename&&
			c1.accountno==c2.accountno&&
			c1.password==c2.password&&
			c1.bankname==c2.bankname) {
				//System.out.println(c1.filename+"and"+c2.filename);
				return true;
			}
			return false;
		}
		else {
			System.out.println("There is no customer found");
			 return false;
		}
		  	  
	  }
	  
	  public boolean checkcustomer(String name,Long accno) throws ClassNotFoundException, SQLException {
		  
		  String query = "select * from customerinfo where full_name=? and accountnumber=?";
			Connection con;

			con = DBconnection.getConnection();
			PreparedStatement pst;

			pst = con.prepareStatement(query);

			pst.setString(1,name);
			pst.setLong(2,accno);
			
			ResultSet rt =pst.executeQuery();
			
			while(rt.next()) {
				return true;
			}
			return false;
		  
	  }
	  
	  public customerinformation displaycustomer(Long accno,String pass) throws ClassNotFoundException, SQLException, IOException {
		  System.out.println("called displayinfo");
		  String query="select * from customerinfo where accountnumber=? and pass_word=?";
		  Connection con =DBconnection.getConnection();
		PreparedStatement pst =  con.prepareStatement(query);
		               pst.setLong(1,accno);
		               pst.setString(2,pass);
		     ResultSet rt = pst.executeQuery();
		     customerinformation custom =new customerinformation();
		   while(rt.next()) {
			   System.out.println(rt.getString(1));
			   System.out.println(rt.getString(2));
			custom.fullname=rt.getString(1);
			custom.address=	rt.getString(2);
			custom.phoneno=rt.getString(3);
			custom.emailid=	rt.getString(4);
			custom.accounttype=	rt.getString(5);
			custom.amount=rt.getInt(6);
			custom.date =rt.getDate(7);
			custom.idproof=rt.getString(8);
			
				  Blob blob=rt.getBlob(9);
				   custom.filename=rt.getString(10);
				   byte bytearray[] =blob.getBytes(1,(int)blob.length());
				   System.out.println(custom.getFilename());
				   if(custom.photoformatchecker(custom.filename)) {
		  System.out.println(custom.photoformatchecker(custom.filename));
				    FileOutputStream out =
new FileOutputStream(
	"D:\\backup files\\eclipse-workspace\\.metadata\\BankingApplication\\src\\main\\webapp\\Bloboutput"+custom.fullname+".jpg");
				    out.write(bytearray);
				   out.close(); 
				   custom.filename=	"Bloboutput\\"+custom.fullname+".jpg";
				   System.out.println(custom.filename);
				   }
				   else {
					   FileOutputStream out =
	new FileOutputStream("D:\\backup files\\eclipse-workspace\\.metadata\\BankingApplication\\src\\main\\webapp\\Bloboutput"+custom.fullname+".png");
		  				    out.write(bytearray);
							   				   out.close();
			 custom.filename="Bloboutput\\"+custom.fullname+".png";
				   }
			custom.accountno=rt.getLong(11);
				custom.password =rt.getString(12);
			custom.bankname=rt.getString(13);
		   }
		return custom;
	
	  }
	
	  public void updatePassword(Long accno,String npassword) throws ClassNotFoundException, SQLException {
		  Connection con =DBconnection.getConnection();
		  String query1="update accountinformation set pass_word=? where accountnumber=?";
		  PreparedStatement pst1 =con.prepareStatement(query1);
		  pst1.setString(1,npassword);
		  pst1.setLong(2,accno);
		int rows1=pst1.executeUpdate();
		System.out.println("Number of rows affected is "+rows1);  
		  String query="update customerinfo set pass_word=? where accountnumber=?";
		  PreparedStatement pst =con.prepareStatement(query);
		  pst.setString(1,npassword);
		  pst.setLong(2,accno);
		int rows = pst.executeUpdate();
		System.out.println("new password is :"+npassword);
		System.out.println("Number of rows affected is "+rows);
		 }
	  public String getName(Long accno) throws ClassNotFoundException, SQLException {
		
		  String name;
		  String query="select Full_name from customerinfo where accountnumber=?";
		  Connection con =DBconnection.getConnection();
		 PreparedStatement pst= con.prepareStatement(query);
		 pst.setLong(1,accno);
	   ResultSet rt =pst.executeQuery();
	   while(rt.next()) {  
		   System.out.println(rt.getString(1));
		name=rt.getString(1);
		System.out.println(name);
		return name;
	   }
		return null; 
	  }
	  public int getAmount(Long accno,String password) throws SQLException, ClassNotFoundException{
		 int amount=0;
		  String query="select Initial_balance from customerinfo where accountnumber=? and pass_word=?";
		  Connection con =DBconnection.getConnection();
		PreparedStatement pst =con.prepareStatement(query);
		pst.setLong(1,accno);
		pst.setString(2,password);
	ResultSet rt=pst.executeQuery();
	while(rt.next()) {
	amount =Integer.parseInt(rt.getString(1));
	return amount;
	}
		 return amount;
	  }
	  public int getAmount(Long accno) throws SQLException, ClassNotFoundException{
		 int amount=0;
		  String query="select Initial_balance from customerinfo where accountnumber=?";
		  Connection con =DBconnection.getConnection();
		PreparedStatement pst =con.prepareStatement(query);
		pst.setLong(1,accno);
	ResultSet rt=pst.executeQuery();
	while(rt.next()) {
	amount =Integer.parseInt(rt.getString(1));
	return amount;
	}
		 return amount;
	  }
	  public void addAmount(int amount,Long accno) throws SQLException, ClassNotFoundException{
			String depamount =Integer.toString(amount);
			  String query="update customerinfo set Initial_balance=? where accountnumber=?";
			  Connection con =DBconnection.getConnection();
			PreparedStatement pst =con.prepareStatement(query);
			pst.setString(1,depamount);
			pst.setLong(2, accno);
		int rows =pst.executeUpdate();
		System.out.println("Number of rows affected is: "+rows);	
		  }
	  public void deposit_transaction(Long accountnumber,int amount) throws ClassNotFoundException, SQLException {
		  String query="insert into transaction_info(accountnumber,date_time,deposit) values(?,timestamp(now()),?)";
		  Connection con =DBconnection.getConnection();
	    PreparedStatement pst=con.prepareStatement(query);
	    pst.setLong(1,accountnumber);
	    pst.setInt(2, amount);
	    int rows= pst.executeUpdate();
	    System.out.println("Number of rows affected is :"+rows);
	  }
	  public void withdraw_transaction(Long accountnumber,int amount) throws ClassNotFoundException, SQLException {
		  String query="insert into transaction_info(accountnumber,date_time,withdraw) values(?,timestamp(now()),?)";
		  Connection con =DBconnection.getConnection();
	    PreparedStatement pst=con.prepareStatement(query);
	    pst.setLong(1,accountnumber);
	    pst.setInt(2, amount);
	    int rows= pst.executeUpdate();
	    System.out.println("Number of rows affected is :"+rows);
	  }
     
	  public int getWithdraw(Long accountnumber) throws ClassNotFoundException, SQLException {
		 int withdraw =0;
		  String query="select withdraw from transaction_info where accountnumber =? "
		  		+ "order by date_time desc limit 10";
		  Connection con =DBconnection.getConnection();
		  PreparedStatement pst =con.prepareStatement(query);
		  pst.setLong(1,accountnumber);
		 ResultSet rt =  pst.executeQuery();
		 while(rt.next()) {
			 String str=	rt.getString(1);
			 if(str==null) {
			withdraw +=0;
			 }
			 else {
			withdraw+= Integer.parseInt(str);
			 }
			}
           return withdraw;}
	  
	  public int getDeposit(Long accountnumber) throws ClassNotFoundException, SQLException {
			 int deposit =0;
			  String query="select deposit from transaction_info where accountnumber =? "
			  		+ "order by date_time desc limit 10";
			  Connection con =DBconnection.getConnection();
			  PreparedStatement pst =con.prepareStatement(query);
			  pst.setLong(1,accountnumber);
			 ResultSet rt =  pst.executeQuery();
			 while(rt.next()) {
				 String str=	rt.getString(1);
				 if(str==null) {
				deposit+=0;
				 }
				 else {
				deposit+= Integer.parseInt(str);
				 }
				 }
			 System.out.println("Deposit amount"+deposit);
			 return deposit;
	           }
}
