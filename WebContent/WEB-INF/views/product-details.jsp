<%@page import="java.util.ArrayList"%>
<%@page import="it.beije.ananke.ecommerce.Product"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product details</title>
<style>
	ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #5C5C5E;
	}

	li {
	  float: left;
	}
	
	li a {
	  display: block;
	  color: white;
	  text-align: center;
	  padding: 14px 16px;
	  text-decoration: none;
	}
	
	/* Change the link color to #111 (black) on hover */
	li a:hover {
	  background-color: #111;
	}
</style>
</head>
<body>
	<ul>
	  <li><a href="products">Home</a></li>
	  <li><a href="orders">My orders</a></li>
	  <li><a href="">Profile</a></li>
	  <li style="float:right"><a class="active" href="login">Logout</a></li>
	</ul>

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