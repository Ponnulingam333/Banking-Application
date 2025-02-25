<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
  div.a{
  text-align:center;
  font-size:25px;}
  h1{
  font-size:65px;}
  button{
  font-size:25px;}
</style>
<meta charset="UTF-8">
<title>notification</title>
</head>
<body>
 <% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("username")==null){
	  response.sendRedirect("adminlogin.jsp");}
 %>
<div class="a">
<h1>Account updated successfully</h1>
<p>Customer new password is : <%= session.getAttribute("customerpw")%></p>
<br>
<form action="updatedb.jsp">
<button type="submit">back</button>
</form>
</div>
</body>
</html>