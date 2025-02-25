<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1{
text-align:center;
font-size:65px;}
div.d{
text-align:center;
font-size:25px;}
button{
font-size:25px;}
</style>
<meta charset="UTF-8">
<title>Withdraw</title>
</head>
<body>
 <% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("accno")==null){
	  response.sendRedirect("customerlogin.jsp");}
 %>
 <h1>Withdraw</h1>
<div class="d">
     <form action="withdraw" method="post"><label>Enter the amount</label><br>
     <input type="text" id="amount" name="amount" style="height:25px;font-size:25px">
     <br>
     <br>
     <button type="submit">submit</button></form>
     <form action="customeroptions.jsp">
     <br>
     <button type="submit">back</button>
     </form>
     
     </div>
     
</body>
</html>