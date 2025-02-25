package com.backend;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.application.DAO;

public class customerchecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Long accountnumber=Long.parseLong(request.getParameter("accno").trim());
	   String password=request.getParameter("pw").toString().trim();
	
	   System.out.println(accountnumber);
	   System.out.println(password);
	   //PrintWriter out =response.getWriter();
	DAO dao =new DAO();
		if(dao.customerverificator(accountnumber,password)) {
			System.out.println(dao.customerverificator(accountnumber,password));
		HttpSession session =request.getSession();
		session.setAttribute("accno",accountnumber);
		session.setAttribute("password",password);
		response.sendRedirect("customeroptions.jsp");}
		else {
			response.sendRedirect("invalidcust.jsp");
		}
	} 
	
	catch(ClassNotFoundException |SQLException |NumberFormatException c){
     c.printStackTrace();	
     response.sendRedirect("invalidcust.jsp");
	}
	
	
	}

}
