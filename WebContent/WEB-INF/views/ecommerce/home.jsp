<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home</title>
	<style>
		body {
			margin: 0;
		  	font-family: Arial, Helvetica, sans-serif;
		}
		
		.topnav {
			overflow: hidden;
			background-color: #333;
		}
		
		.topnav a {
			float: left;
			color: #f2f2f2;
			text-align: center;
			padding: 14px 16px;
			text-decoration: none;
			font-size: 17px;
		}

		.topnav a:hover {
			background-color: #ffff;
			color: black;
		}
		
		.topnav a.active {
			background-color: #333;
			color: white;
		}
		
		h1 {
			background-color: #333;
			text-align: center;
			color: white;
			margin: 0px;
			padding: 25px;
			margin-bottom: 1px;
		}
	</style>
</head>
<body>
	<h1>DONUT INC.</h1>
	<div class="topnav">
 		<a href="./home">Home</a>
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