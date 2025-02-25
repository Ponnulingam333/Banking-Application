<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
div.pdf{
font-size:25px;
text-align:center;}
h1{
font-size:65px;}
button{
font-size:25px;}
</style>
<meta charset="UTF-8">
<title>downloadpdf</title>
</head>
<body>
 <% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("accno")==null){
	  response.sendRedirect("customerlogin.jsp");}
 %>
<% Long accno =Long.parseLong(session.getAttribute("accno").toString()); %>
 <div class="pdf"><h1>PDF created successfully</h1>
 <iframe src="..\PDFoutput\<%=accno%>.pdf" width="50%" height="450px"></iframe>
 <form action="customeroptions.jsp"><button type="submit">back</button></form>
 </div>

</body>
</html>