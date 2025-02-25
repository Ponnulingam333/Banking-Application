package com.backend;

import java.io.IOException;

import java.sql.SQLException;

import com.bank.application.DAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class closeAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
   			throws ServletException, IOException {
		HttpSession session =request.getSession();
	Long accno=Long.parseLong(session.getAttribute("accno").toString());
	String password=(String)session.getAttribute("password");
  //	String name=session.getAttribute("name").toString();
	DAO dao =new DAO();
	try {
		if(dao.getAmount(accno, password)==0) {
			dao.deleteaccount(accno);
		   response.sendRedirect("deletenotify.jsp");
		}  
		else {
			response.sendRedirect("closeaccountinfo.jsp");
		}
	} catch (ClassNotFoundException | SQLException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
