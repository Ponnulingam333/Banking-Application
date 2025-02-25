<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer logout</title>
</head>
 <% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("accno")==null){
	  response.sendRedirect("customerlogin.jsp");}
 %>
<body>
     <% session.removeAttribute("accno");
     session.removeAttribute("pw");
     session.invalidate();%>
     response.sendRedirect("customerlogin.jsp");
</body>
</html>