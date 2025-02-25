package com.backend;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.application.DAO;

public class withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao =new DAO();
		HttpSession session =request.getSession();
		//PrintWriter out =response.getWriter();
		System.out.println("called the deposit servlet");
	Long accountnumber =Long.parseLong(session.getAttribute("accno").toString());
	String password=(String)session.getAttribute("password");
	int debitamount =Integer.parseInt((String)request.getParameter("amount"));
	session.setAttribute("withdrawamount",debitamount);
	System.out.println(accountnumber+","+password);	
	try {
		System.out.println(dao.customerverificator(accountnumber,password));
		if(dao.customerverificator(accountnumber,password)){
		int amount=	dao.getAmount(accountnumber,password);
		if(amount>0&&amount>=debitamount) {
		dao.withdraw_transaction(accountnumber,debitamount);
	int debitedamount =	amount-debitamount;
	dao.addAmount(debitedamount, accountnumber);
	response.sendRedirect("Withdrawnotify.jsp");}
		else{
			response.sendRedirect("insufficientbalance.jsp");
		}
		}	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}}
