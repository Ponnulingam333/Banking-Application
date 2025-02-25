<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="com.bank.application.DAO" %>
<!DOCTYPE html>
<html>
<head>
<style>
div.N{
text-align:center;
font-size:25px;}
button{
font-size:25px;}</style>
<meta charset="UTF-8">
<title>Notification</title>
</head>
<body>
 <% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("accno")==null){
	  response.sendRedirect("customerlogin.jsp");}
 %>
<div class="N"><h1>Amount withdraw successfully</h1>
<% DAO dao =new DAO();
 Long accno=Long.parseLong(session.getAttribute("accno").toString());
	String pw=(String)session.getAttribute("password");
	 int withdraw =Integer.parseInt(session.getAttribute("withdrawamount").toString());
out.println("Withdraw amount : "+withdraw);
out.println("<br>");
	 out.println("The Account balance is : "+dao.getAmount(accno,pw)); %>
	 <br>
	 <br>
  <form action="Withdraw.jsp">
     <button type="submit">back</button>
     </form></div>

</body>
</html>