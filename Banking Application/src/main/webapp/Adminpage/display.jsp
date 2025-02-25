<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="invalid2.jsp"%>
    <%@ page import="com.bank.application.DAO,com.backend.customerinformation,java.util.Date,java.text.SimpleDateFormat"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix ="c"%>
<html>
<style>
div.c{
text-align:center;
font-size:25px;}
h1{
text-align:center;}
div.o{
text-align:center;
font-size:25px;}
button{
font-size:25px;}
</style>
<head>
<meta charset="UTF-8">
<title>Display</title>
</head>
<body>
 <% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("username")==null){
	  response.sendRedirect("adminlogin.jsp");}
 %>
<div class="o">
<%        Long accno =Long.parseLong(request.getParameter("accountnumber").trim());
      String name=(String)request.getParameter("fullname").trim(); 
      DAO dao =new DAO();
   customerinformation custom=dao.displayinfo(accno,name);%>
    <h1>Customer Information</h1>
   <br>
   <% out.println("Fullname : "+custom.fullname); %><br>
   <% out.println("Address : "+custom.address); %><br>
   <% out.println("Phoneno : "+custom.phoneno); %><br>
   <% out.println("Emailid : "+custom.emailid); %><br>
   <% out.println("Accounttype : "+custom.accounttype); %><br>
   <%
 Date jdate =new Date(custom.date.getTime());
    SimpleDateFormat format =new SimpleDateFormat("dd-MM-yyyy");
   String date = format.format(jdate);
   out.println("Date : "+date); %><br>
   <%out.println("Idproof : "+custom.idproof); %><br>
  <% out.println(custom.filename); %><br>
        <img src="..//<%=custom.filename%>" width="150" height="150"></img>
 <br> <%out.println("Accountnumber : "+custom.accountno); %><br>
  <%out.println("Bankname : "+custom.bankname); %><br>
  </div>
   
    <!--   
      <br>
    <c:forEach items="${custom}" var="c">
   <c:out value="fullname  :"></c:out><br>
   <c:out value="address   :">${c.address}</c:out><br>
   <c:out value="phoneno   : ${ c.phoneno}"></c:out><br>
    <c:out value="emailid  : ${c.emailid}"></c:out><br>
   <c:out value="accounttype:  ${c.accounttype}"></c:out><br>
   <c:out value="amount :${c.amount}"></c:out><br>
   <c:out value="date : ${ date}"></c:out> <br>
   <c:out value="idproof :${idproof}"></c:out><br>
		<c:out value="filename :${filename}"></c:out><br>
		<c:out value="accountno :${accountno}"></c:out><br>
		<c:out value="password  :${password}"></c:out><br>
		<c:out value="bankname : ${bankname}"></c:out><br>
    </c:forEach>
-->
 <br>
   <div class="c"><form action="controls.jsp"><button type="submit">back</button></form></div>

</body>
</html>