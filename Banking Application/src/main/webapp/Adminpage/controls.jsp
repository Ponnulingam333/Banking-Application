<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
div.c{
text-align:right;
font-size:25px;}
div.d{
text-align:center;
font-size:25px;}
button{
font-size:25px;}
h1{
font-size:65px;}
</style>
<meta charset="UTF-8">
<title>controls</title>
</head>
<body>
 <% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("username")==null){
	  response.sendRedirect("adminlogin.jsp");}
 %>
<div class="c"><form action="logout.jsp">
<%String username=(String)session.getAttribute("username");
               out.println("Admin name: "+username);%>
               <br>
<button type="submit">logout</button></form></div>
<div class="d">
<h1>Admin Controls</h1>
    <h3>To delete the customer:</h3>
   <form action="delete" method="post">
   <label for="accountnumber">Enter the account no</label><br>
   <input type="text" name="accountnumber" id="accountnumber" style="height:25px;font-size:25px"><br>
   <label for="fullname">Enter the customer fullname</label><br>
   <input type="text" name="fullname" id="fullname" style="height:25px;font-size:25px"><br>
  <br> <button type="submit">Submit</button> 
   </form></div>
    <div class="d">
     <h3>To see the customer information:</h3>
  <form action="display.jsp" method="post" >
   <label for="accountnumber">Enter the account no</label><br>
   <input type="text" name="accountnumber" id="accountnumber" style="height:25px;font-size:25px"><br>
   <label for="fullname">Enter the customer fullname</label><br>
   <input type="text" name="fullname" id="fullname" style="height:25px;font-size:25px"><br>
  <br> <button type="submit" >Submit</button> 
   </form></div>
   <div class="d">
     <h3>To update the customer information:</h3>
   <form action="updatedb.jsp">
   <button type="submit" >Update</button> 
   </form>  
   <br>
<form action="admin.jsp"><button type="submit">back</button> </form></div>
   <br>
   <br>
</body>
</html>