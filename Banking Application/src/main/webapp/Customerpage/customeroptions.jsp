<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.bank.application.DAO" %>
<!DOCTYPE html>
<html>
<head>
<style>
button{
text-size:25px;
}
h1{
text-align:center;
font-size:65px;
}
div.a{
text-align:right;
font-size:25px;}
button{
font-size:25px;
}
div.c{
text-align:center;}
</style>
<meta charset="UTF-8">
<title>customeroptions</title>
</head>
<body>
 <% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("accno")==null){
	  response.sendRedirect("customerlogin.jsp");}
 %>
<div class="a"><%
Long accno=(Long)session.getAttribute("accno");
  DAO dao =new DAO();
           String name=dao.getName(accno);
           session.setAttribute("name",name);
    out.println("Customer name: "+name);
  %>
    <br>
    <%
    out.println("Account number: "+accno);
%>
<form action="customerlogin.jsp">
 <button type="submit">logout</button>
 </form></div>
  <h1>Cutomer Dashboard</h1>
<div class="c"><form action="customerpage.jsp"><button type="submit">Customer Dashboard</button></form>
<br>
<form action="changepassword.jsp" method="post"><button type="submit">Changepassword</button></form>
<br>
<form action="Deposit.jsp" method="post"><button type="submit">Deposit</button></form>
<br>
<form action="Withdraw.jsp" method="post"><button type="submit">Withdraw</button></form>
<br>
<form action="printstatement" method="post"><button type="submit">View</button></form>
<br>
<form action="closeAccount" method="post"><button type="submit">CloseAccount</button></form>
<br>
<form action="customerlogin.jsp"><button type="submit">back</button></form></div>

</body>
</html>