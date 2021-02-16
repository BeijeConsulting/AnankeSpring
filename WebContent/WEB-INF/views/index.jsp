<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Ecommerce Project</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css"/> 
<link href="./resources/css/style.css" rel="stylesheet">        
<script src="./resources/js/bootstrap.min.js"></script>  
</head>
<body>
<%@ include file = "navbar.jsp"%>
<div class = "container">

<c:if test="${username == null }">
<h1>Benvenuto su Ecommerce</h1>
<h2>Per registrarti <a href="./registrationPage">clicca qui</a></h2>
<h2>Per accedere <a href="./loginPage">clicca qui</a></h2>
</c:if>
<c:if test="${username != null }">
<h1>Benvenuto ${username}</h1>




<h2>Per aggiungere prodotti <a href="">clicca qui</a></h2>
</c:if>




</div>
</body>
</html>