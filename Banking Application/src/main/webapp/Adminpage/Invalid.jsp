<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 <%
 response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
 response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("username")==null){
	  response.sendRedirect("adminlogin.jsp");}
 %>
<div class="n"><h1>please check the username and password!</h1>
<form action="adminlogin.jsp"> <button type="submit">back</button></form>
</div>

</body>
</html>