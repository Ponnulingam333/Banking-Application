<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<style>
div.d{
text-align:center;
font-size:25px;}
button{
font-size:25px;}
</style>
<meta charset="UTF-8">
<title>Error occured</title>
</head>
<body>
 <% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("username")==null){
	  response.sendRedirect("adminlogin.jsp");}
 %>
<div class="d">
<h1>No changes added! </h1>
<form action="updatedb.jsp">
<button type="submit">back</button></form>
</div>

</body>
</html>