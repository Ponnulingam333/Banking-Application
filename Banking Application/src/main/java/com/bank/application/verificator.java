package com.bank.application;

import java.io.IOException;

//import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class verificator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username =(String)request.getParameter("username");
		username.trim();
		String password = (String)request.getParameter("password");
		password.trim();
	//PrintWriter out = response.getWriter();
		DAO dao = new DAO(); 
		System.out.println(username);
		System.out.println(password);
	
			try {
				if (dao.checkadmin(username, password)) {
					System.out.println(dao.checkadmin(username, password));
					HttpSession session =request.getSession();
					session.setAttribute("username",username);
					session.setAttribute("password",password);
					response.sendRedirect("admin.jsp");
				} 
				else {
					response.sendRedirect("Invalid.jsp");
				}
			} 
			
			catch (ClassNotFoundException | IOException |SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
}
	


