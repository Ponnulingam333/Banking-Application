package com.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import com.bank.application.DAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class changepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  Long accno =Long.parseLong(request.getParameter("accno").trim());
	  String password=(String)request.getParameter("password").trim();;
	  String newpassword=(String)request.getParameter("newpass");
	  System.out.println(password);
	  System.out.println(newpassword);
	  PrintWriter out =response.getWriter();
	  DAO dao =new DAO();
	  try {
		if(dao.customerverificator(accno,password)) {
			dao.updatePassword(accno,newpassword);
			HttpSession session =request.getSession();
			session.setAttribute("newpw",newpassword);
		//	out.println("password updated successfully");  
		
			 customerinformation custom1 =new customerinformation();
		       custom1.accountno=accno;
		       custom1.password=newpassword;
		         customerinformation custom2=dao.getDetails(accno);
		    custom1.fullname=dao.getName(accno);
		    String info=custom1.getnewpasswordupdate(password);
			SendEmail.sendingMail(custom2.getEmailid(),info);
			response.sendRedirect("changedpw.jsp");
		  }
		  else{
			  out.println("Invalid username and password");
		  }
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
