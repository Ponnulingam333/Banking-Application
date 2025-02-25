<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<style>
div.n{
text-align:center;
font-size:25px;}
button{
font-size:25px;}
</style>
<meta charset="UTF-8">
<title>Invalid!</title>
</head>
<body>
 <% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("username")==null){
	  response.sendRedirect("customerlogin.jsp");}
 %>
<div class="n"><h1>Please enter the correct  or password or customername and account number</h1>
<form action="controls.jsp"> <button type="submit">back</button></form>
</div>

</body>
</html>