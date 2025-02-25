<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
div.c{
text-align:center;
font-size:25px;}
h1{
font-size:65px;}
button{
font-size:25px;
}
</style>
<meta charset="UTF-8">
<title>Notification</title>
</head>
<body>
 <% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("accno")==null){
	  response.sendRedirect("customerlogin.jsp");}
 %>
<div class="c">
     <h1>Password Changed Successfully!</h1>
     <p>New password is : <%= session.getAttribute("newpw")%></p>
<form action="customerlogin.jsp"><button type="submit">back</button></form></div>

</body>
</html>