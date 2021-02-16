<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home</title>
	<link rel="stylesheet" href="style.css"><link>
</head>
<body>
	<h1>DONUTINC.</h1>
	<div class="topnav">
 		<a class="active" href="home.jsp">Home</a>
 		<c:choose>
	 		<c:when test = "${userId == null}">
		 		<a href="./login">Login</a>
	 		</c:when>
	 		<c:when test = "${title.equals(\"admin\")}">
		 		<a href="./logout">Logout</a>
		 		<a href="./newProduct">Insert new product</a>
	 		</c:when>
	 		<c:when test = "${title == null}">
		 		<a href="./logout">Logout</a>
		 		<a href="./orders">Orders</a>
	 		</c:when>
 		</c:choose>
 		<a href="./products">Products</a>
	</div>
	
</body>
</html>