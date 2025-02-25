<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="com.bank.application.DAO,com.backend.customerinformation,java.util.Date,java.text.SimpleDateFormat"%>
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
div.di{
text-align:right;
font-size:25px;}
button{
font-size:25px;}
div.b{
text-align:center;
font-size:25px;}
</style>
<meta charset="UTF-8">
<title>customerdashboard</title>
</head>
<body>
 <% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("accno")==null){
	  response.sendRedirect("customerlogin.jsp");}
 %>
<div class="b">
<%  
    Long accno = (Long)session.getAttribute("accno");
    String name=(String)session.getAttribute("name");
    DAO dao =new DAO();
    customerinformation custom=dao.displayinfo(accno,name);%>
     <h1>Customer Dashboard</h1>
    <% out.println("Fullname : "+custom.fullname); %><br>
    <% out.println("Address : "+custom.address); %><br>
    <% out.println("Phoneno : "+custom.phoneno); %><br>
    <% out.println("Emailid : "+custom.emailid); %><br>
    <% out.println("Accounttype: "+custom.accounttype); %><br>
    <%out.println("Amount: "+custom.amount+" Rs");%><br>
    <%
  Date jdate =new Date(custom.date.getTime());
     SimpleDateFormat format =new SimpleDateFormat("dd-MM-yyyy");
    String date = format.format(jdate);
    out.println("Date: "+date); %><br>
    <%out.println("Idproof: "+custom.idproof); %><br>
   <% out.println(custom.filename); %><br>
         <img src="..//<%=custom.filename%>" width="150" height="150"></img>
  <br> <%out.println("Accountnumber: "+custom.accountno); %><br>
   <%out.println("Bankname: "+custom.bankname); %><br>
    <br>
   <form action="customeroptions.jsp"><button type="submit">back</button></form>
   
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
 
 </body>
 </html>