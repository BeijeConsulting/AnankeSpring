<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css"/> 
<link href="./resources/css/style.css" rel="stylesheet">        
<script src="./resources/js/bootstrap.min.js"></script>  
</head>
<body>
<%@ include file = "navbar.jsp"%>
<div class="container">
<form action="./registration" method="post">
<label for="email">First Name:</label><br>
  <input type="text" id="fname" name="fname"><br>
  <label for="email">Last Name:</label><br>
  <input type="text" id="lname" name="lname"><br>
  <label for="email">Email:</label><br>
  <input type="email" id="email" name="email"><br>
 	<label for="email">Password:</label><br>
  <input type="password" id="psw" name="password">
  <p><input type="submit" class="btn btn-dark buttonform" value="Registrati"></p>
  <c:if test="${state != null}">
<span>${state}</span>
</c:if>
</form>
</div>
</body>
</html>