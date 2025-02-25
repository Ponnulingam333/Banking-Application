package com.bank.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBconnection{
public  static Connection getConnection() throws SQLException, ClassNotFoundException {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	  String url="jdbc:mysql://localhost:3306/bankingapplication";
	  String username="root";
	  String password="2001";
	   Connection con =DriverManager.getConnection(url,username,password);
    return con;}}