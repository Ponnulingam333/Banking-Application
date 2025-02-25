<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
div.clas{
text-align:center;
font-size:25px;}
h1{
font-size:65px;
}
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
<div class="clas">
<h1>You can only close the amount after withdraw all the amount!</h1>
<form action="customeroptions.jsp">
<button type="submit">back</button>
</form>

</div>
</body>
</html>