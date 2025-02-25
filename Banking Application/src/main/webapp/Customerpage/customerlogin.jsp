<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1{
font-size:65px;}
div.c{
font-size:25px;
text-align:center;
}
div.i{
text-align:center;}
button{
font-size:25px;}

</style>
<meta charset="UTF-8">
<title>customerloginpage</title>
</head>
<body>
<%
response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
 %>
<div class="c"><h1>Customer login</h1>
<form action="customerchecker" method="post">
<label for="accno">Enter the accountnumber</label><br>
<input type="text" name="accno" id="accno" style="height:25px;font-size:25px"></input><br>
<label for="password">Enter the password</label><br>
<input type="text" name="pw" id="pw" style="height:25px;font-size:25px"></input><br><br>
<button type="submit">submit</button>
<br>
</form></div>
<br>
<div class="i">
 <form action="..\Frontpage\index.jsp">
 <button type="submit">back</button>
 </form></div>

</body>
</html>