package com.backend;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bank.application.DAO;

public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao =new DAO();
		HttpSession session =request.getSession();
		System.out.println("called the deposit servlet");
	Long accountnumber =Long.parseLong(session.getAttribute("accno").toString());
	String password=(String)session.getAttribute("password");
	int depositamount =Integer.parseInt((String)request.getParameter("amount"));
	System.out.println(accountnumber+","+password);
session.setAttribute("depositamount",depositamount);
	int balanceamount;	
	try {
		System.out.println(dao.customerverificator(accountnumber,password));
		if(dao.customerverificator(accountnumber,password)){
		balanceamount=dao.getAmount(accountnumber,password);
		System.out.println(balanceamount);
		dao.deposit_transaction(accountnumber,depositamount);
	int	totalamount=depositamount+balanceamount;
	System.out.println(depositamount);
	System.out.println(totalamount);
	     dao.addAmount(totalamount, accountnumber);
	     response.sendRedirect("Depositamount.jsp");
		}
	} catch (ClassNotFoundException |SQLException e ) {
		e.printStackTrace();
	}
		
	}

}
