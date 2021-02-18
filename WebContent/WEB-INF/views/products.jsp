<%@page import="it.beije.ananke.ecommerce.User"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="it.beije.ananke.ecommerce.Order"%>
<%@page import="it.beije.ananke.ecommerce.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
	<h3>Products</h3>
	 <jsp:useBean id="userBean" class="it.beije.ananke.ecommerce.User" scope="session"/>
	<jsp:setProperty property="id" name="userBean" value="${id}"/>
	<jsp:useBean id="orderBean" class="it.beije.ananke.ecommerce.Order" scope="session"/> 
	
	<c:forEach var = "product" items="${products}">
		<a href="product-details?id=${product.id}">${product.name}</a><br>
	</c:forEach>
	
</body>
</html>