<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1{
font-size:65px;
text-align:center;}
div.f{
text-align:center;
font-size:25px;}
button{
font-size:25px;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("accno")==null){
	  response.sendRedirect("customerlogin.jsp");}
 %>
<h1>Change password</h1>
<div class="f"><form action="changepassword" method="post">
<label for="accno">Enter the accountnumber</label><br>
<input type="text" name="accno" id="accno" style="height:25px;font-size:25px"></input><br>
<label for="password">Enter the password</label><br>
<input type="text" name="password" id="password" style="height:25px;font-size:25px"></input><br>
<label for="newpass">Enter the new password</label><br>
<input type="text" name="newpass" id="newpass" style="height:25px;font-size:25px"></input>
<br>
<br>
<button type="submit">submit</button><br>
</form>
<br>
<form action="customeroptions.jsp"><button type="submit">back</button></form></div>

</body>
</html>