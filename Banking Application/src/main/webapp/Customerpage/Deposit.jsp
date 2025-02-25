<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1{
font-size:65px;}
div.d{
text-align:center;
font-size:25px;}
div.a{
text-align:center;}
button{
font-size:25px;}

</style>
<meta charset="UTF-8">
<title>Deposit</title>
</head>
<body>
 <% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("accno")==null){
	  response.sendRedirect("customerlogin.jsp");}
 %>
<div class="d">
      <h1>Deposit</h1>
     <form action="Deposit" method="post">
     <label for="amount">Enter the amount</label><br>
     <input type="text" id="amount" name="amount" style="height:25px;font-size:25px">
     <br> <br>
     <button type="submit">submit</button></form>
     <br></div>
     
     <div class="a"><form action="customeroptions.jsp">
     <br>
     <button type="submit">back</button>
     </form></div>

</body>
</html>