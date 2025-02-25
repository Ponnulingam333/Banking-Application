<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>
h1{
text-align:center;
font-size:60px}
div.c{
text-align:right;
font-size:25px;}
div.b{
text-align:center;}
div.n{
text-align:center;}
button{
font-size:25px;}
</style>
<meta charset="UTF-8">
<title>Admin page</title>
</head>
<body>
<!--  
 <h1>Welcome Admin</h1>-->
 <% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("username")==null){
	  response.sendRedirect("adminlogin.jsp");}
 %>
 <div class="c"><form action="logout.jsp">
<%  String username=(String)  session.getAttribute("username");
               out.println("Admin name: "+username);%>
               <br>
<button type="submit">logout</button></form></div>

 <h1>Admin controls</h1>
 <div class="n">
 <form action="createaccount.jsp">
 <button type="submit">Create account</button>
 </form>
 <br>
 <br>
 <form action="controls.jsp">
 <button type="submit">Controls</button>
 </form></div>
 <br>
 <br>
<div class="b"><form action="adminlogin.jsp">
<button type="submit">back</button>
</form></div>
</body>
</html>