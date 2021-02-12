<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
       <link rel="stylesheet" href="bootstrap.min.css"/> 
       <link href="style.css" rel="stylesheet">        
       <script src="bootstrap.min.js"></script>  
</head>
<body>
<div class="container">
<form action="./registration" method="post">
<label for="email">First Name:</label><br>
  <input type="text" id="fname" name="fname"><br>
  <label for="email">Last Name:</label><br>
  <input type="text" id="lname" name="lname"><br>
  <label for="email">Email:</label><br>
  <input type="email" id="email" name="email"><br>
 <% if(request.getAttribute("error") == null){
	 
 }else{
  %>
  <span>${error}</br></span>
  <%} %>

  <label for="email">Password:</label><br>
  <input type="password" id="psw" name="password">
  <p><input type="submit" class="btn btn-dark" value="Registrati"></p>
</form>
</div>
</body>
</html>