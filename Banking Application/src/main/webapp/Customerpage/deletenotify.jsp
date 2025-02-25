<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
div.c{
text-align:center;
font-size:25px;}
button{
font-size:25px;}
</style>
<meta charset="UTF-8">
<title>notification</title>
</head>
<body>
 <% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("accno")==null){
	  response.sendRedirect("customerlogin.jsp");}
 %>
<div class="c"><h1>Account Closed Sucessfully</h1>
<form action="customerlogin.jsp">
<button type="submit">back</button>
</form></div>

</body>
</html>