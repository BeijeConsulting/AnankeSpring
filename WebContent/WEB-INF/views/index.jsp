<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Ecommerce Project</title>
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
<h2>Per registrarti <a href="registration.jsp">clicca qui</a></h2>
<h2>Per accedere <a href="login.jsp">clicca qui</a></h2>
<% } else{
%>
<h1>Benvenuto <%= u.getFirstName() %></h1>

<%} %>







</div>
</body>
</html>