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
 		<a class="active" href="index.jsp">Home</a>
 		<c:choose>
	 		<c:when test = "${userId == null}">
		 		<a href="./login">Login</a>
	 		</c:when>
	  		<c:when test = "${userId != null}">
		 		<a href="./logout">Logout</a>
		 		<a href="./orders">Orders</a>
	 		</c:when>
 		</c:choose>
 		<a href="./showProducts">Products</a>
	</div>
	
</body>
</html>