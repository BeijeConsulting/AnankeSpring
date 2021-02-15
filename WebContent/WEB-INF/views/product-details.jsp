<%@page import="java.util.ArrayList"%>
<%@page import="it.beije.ananke.ecommerce.Product"%>
<%@page import="java.util.List"%>
<%@page import="it.beije.ananke.ecommerce.JPAmanager"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product details</title>
</head>
<body>
	<h3>Product details</h3>

	<form action="./product-details" method="post">
	<input type="hidden" name="id" value="${product.id}"> 
	Name:&nbsp;${product.name}<br>
	Description:&nbsp;${product.desc}<br>
	Price:&nbsp;${product.price}<br>
	Quantity:&nbsp;<input type="text" name="qnt" value="0"/><br>
	<br><input type="submit" value="Buy"/>	
	</form>
	
	<br><a href="products"><button>Back</button></a>
</body>
</html>