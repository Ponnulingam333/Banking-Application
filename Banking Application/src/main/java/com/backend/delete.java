package com.backend;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import com.bank.application.DAO;
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		long accountnumber =Long.parseLong(request.getParameter("accountnumber").trim());
String name=(String)request.getParameter("fullname").trim();
	
	DAO dao =new DAO();
	  dao.deleteaccount(accountnumber,name);
		//dao.deleteaccount(accountnumber);
		response.sendRedirect("deletenotify.jsp");
	} catch (ClassNotFoundException |SQLException |NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		response.sendRedirect("invalid2.jsp");
	
	}
	}
	}
