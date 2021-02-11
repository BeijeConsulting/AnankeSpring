<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Ecommerce Project</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="bootstrap.min.css"/> 
<link href="style.css" rel="stylesheet">        
<script src="bootstrap.min.js"></script>  
</head>
<body>
<%@ include file = "navbar.jsp"%>
<div class = "container">

<%

if(u == null){
%>
<h1>Benvenuto su Ecommerce</h1>
<h2>Per registrarti <a href="./registrationPage">clicca qui</a></h2>
<h2>Per accedere <a href="./loginPage">clicca qui</a></h2>
<% } else{
%>
<h1>Benvenuto <%= u.getFirstName() %></h1>

<%} %>







</div>
</body>
</html>