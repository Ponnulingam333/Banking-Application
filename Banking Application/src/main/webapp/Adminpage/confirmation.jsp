<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.backend.SendEmail,com.backend.customerinformation,com.bank.application.DAO" %>
<!DOCTYPE html>
<html>
<head>
<style> div.acc{
text-align:center;}
div.d{
text-align:right;
font-size:25px;}
 
 button{
 font-size:25px;}
 
 div.c{
text-align:center;
font-size:25px;
}</style>

<meta charset="UTF-8">
<title>confirmation</title>
</head>
<body>
 <% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("username")==null){
	  response.sendRedirect("adminlogin.jsp");}
 %>

<div class="d"><form action="logout.jsp">
<%  String username=(String)  session.getAttribute("username");
               out.println("Admin name: "+username);%>
               <br>
<button type="submit">logout</button></form></div>

<div class="c">
 <h1>Account Created Successfully</h1>
 <%  
  String customername =(String)session.getAttribute("customername");
 Long accno=(Long)session.getAttribute("accno");
       String password=(String)  session.getAttribute("password");
       customerinformation custom1 =new customerinformation();
       custom1.fullname=customername;
       custom1.accountno=accno;
       custom1.password=password;
       DAO dao =new DAO();
         customerinformation custom2=dao.getDetails(accno);
        String info = custom1.getpasswordupdate();
      SendEmail.sendingMail(custom2.getEmailid(),info); 
   out.println("Customer name : "+customername);%>
   <br><% 
       out.println("Customer Accountnumber : "+accno);%>
       <br> <% 
   out.println("Customer  password : "+password);%>
   <br><br>
<form action="createaccount.jsp">
<button type="submit">back</button> </form>
</div>
</body>
</html>