<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
div.l{
text-align:right;
font-size:25px;}
button{
font-size:25px;}
div.u{
text-align:center;
font-size:25px;}
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
<%  String username=(String)session.getAttribute("username");
               out.println("Admin name: "+username);%>
               <br>
<button type="submit">logout</button></form></div>
<div class="u"><h1>Update customer details</h1>
<form action="updatechecker" method="post" enctype="multipart/form-data">
<label for="accno">Enter the Account no(which you want to update)</label><br>
<input type="text" name="accno" id="accno" style="height:25px;font-size:25px" required></input><br>
<label for="fullname">Enter the full name</label><br>
<input type="text" name="fullname" id="fullname" style="height:25px;font-size:25px" required></input><br>
<label for="address">Enter the address</label><br>
<textarea  name="address" id ="address" cols="30" rows="2"  style="font-size:25px" placeholder="Address" required></textarea><br>
<label for="phoneno" >Enter the phone number</label><br>
<input type="tel" name="phoneno" id="phoneno"  style="height:25px;font-size:25px" required><br>
<label for="emailid">Enter the email id</label><br>
<input type="Email" name="emailid" id="emailid"  style="height:25px;font-size:25px" required>
<br> <br>
<label for="accounttype">choose the accout type</label>
<br>
<label for="currentaccounttype">CurrentAccount</label>
<input type="radio" name="accounttype" id="currentaccounttype" value="CurrentAccount" style="height:20px;width:25px;" required >
<label for="savingsaccounttype">SavingsAccount</label>
<input type="radio" name="accounttype" id="savingsaccounttype" value="SavingsAccount"style="height:20px;width:25px;"  required><br>
<br>
<label for="dob">Enter the date of birth</label><br>
<input type="date" name="date" id="date" min="1980-01-01" max="2024-01-01" style="height:25px;font-size:25px" required><br>
<br>
<label for="idproof">Choose the id proof</label><br>
<select name="idproof" id="idproof"  style="height:35px;font-size:25px" required><option value="Aadhaar" style="height:25px;font-size:25px">Aadhaar</option>
<option value="Drivinglicense" style="height:25px;font-size:25px">Drivinglicense</option><option value="voterid"  style="height:25px;font-size:25px">voterid</option></select>
<br><br>
<input type="file" name="uploadfile" id="uploadfile" title="only support jpg and png format" style="height:35px;font-size:25px" required> 
<br>
<br><label for="uploadfile">choose the file(only support jpg and png format)</label><br> <br>
<button type="submit">submit</button>
</form> 
<br>
<form action="controls.jsp"><button type="submit">back</button></form>
</div>
</body>
</html>