<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
   div.d{
     text-align:center;
     font-size:25px;
     }
     div.c{
     text-align:center;
   }
     div.l{
     text-align:right;
     font-size:25px;}
     button{
     font-size:25px;
     text-align:center;}

</style>
<meta charset="UTF-8">
<title>Customer page</title>
</head>
<body>
 <% response.setHeader("Cache-Control","no-Cache, no-store , must-revalidate");
  if(session.getAttribute("username")==null){
	  response.sendRedirect("adminlogin.jsp");}
 %>
<div class="l"><form action="logout.jsp">
<%  String username=(String)  session.getAttribute("username");
               out.println("Admin name: "+username);%>
               <br>
<button type="submit">logout</button></form></div>
<div class="c"><h1>Create Customer Account Form</h1></div>
<div class="d">
<form action="createaccount" method="post" enctype="multipart/form-data">
<label for="fullname">Enter the full name</label><br>
<input type="text" name="fullname" id="fullname" style="height:25px;font-size:25px"required></input><br>
<label for="address">Enter the address</label><br>
<textarea  name="address" id ="address" cols="30" rows="2" required style="font-size:25px" placeholder="Address"></textarea><br>
<label for="phoneno" >Enter the phone number</label><br>
<input type="tel" name="phoneno" id="phoneno" required style="height:25px;font-size:25px"><br>
<label for="emailid">Enter the email id</label><br>
<input type="Email" name="emailid" id="emailid" required style="height:25px;font-size:25px">
<br> <br>
<label for="accounttype">choose the account type</label>
<br>
<label for="currentaccounttype">CurrentAccount</label>
<input type="radio" name="accounttype" id="currentaccounttype" value="CurrentAccount" required style="height:20px;width:25px;" >
<label for="savingsaccounttype">SavingsAccount</label>
<input type="radio" name="accounttype" id="savingsaccounttype" value="SavingsAccount" required style="height:20px;width:25px;"  ><br>
<br>
<label for="Amount">Initial balance amount</label><br>
<input type="number" name="Amount" id="Amount"  min="1000" required style="height:25px;font-size:25px"><br> <br>
<label for="dob">Enter the date of birth</label><br>
<input type="date" name="date" id="date" min="1980-01-01" max="2024-11-22" required style="height:25px;font-size:25px"><br>
<br>
<label for="idproof">Choose the id proof</label><br>
<select name="idproof" id="idproof" required style="height:35px;font-size:25px"><option value="Aadhaar" style="height:25px;font-size:25px">Aadhaar</option>
<option value="Drivinglicense" style="height:25px;font-size:25px">Driving license</option><option value="voterid"  style="height:25px;font-size:25px">voterid</option></select>
<br><br>
<input type="file" name="uploadfile" id="uploadfile" title="only support jpg and png format" style="height:35px;font-size:25px"> 
<br>
<br><label for="uploadfile">choose the file(only support jpg and png format)</label><br> <br>
<button type="submit">submit</button>
</form>
 <br>
           <form action="admin.jsp"> <button type="submit">back</button></form>
</div> 
</body>
</html>