<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
div.c{
text-align:center;
font-size:25px;}
button{
font-size:25px;}
div.e{
text-align:right;}
h1{
text-align:center;
font-size:60px;}
div.b{
text-align:center;
font-size:25px;}

</style>
<meta charset="UTF-8">
<title>login page</title>
</head>
<body>
<% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate"); %>
<div ><h1>Admin login page</h1></div>
<div class="c">
<form action="verificator" method="post">
<label for="username">Enter the username </label><br>
<input type="text" name="username" id="username" style="height:25px;font-size:25px">
<br>
<label for="password">Enter the password</label><br>
<input type="password" name="password" id="password" style="height:25px;font-size:25px" >
<br>
<br>
<button type="submit">submit</button></form>  
</div>
<div class="b"><form action="../Frontpage/index.jsp">
<br>
<button type="submit">back</button>
</form></div>


</body>
</html>