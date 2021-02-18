<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<style>	
			table, tr, td, th {
		  	border: 1px solid #dddddd;
		 	border-collapse: collapse;
		  	text-align: left;
		  	padding: 8px;
			}
		</style>
	</head>
	<body>
		<%@ include file="home.jsp"%>
		<table>
			<tr>
			<th>Product</th>
			<th>Description</th>
			<th>Price</th>
			<c:choose>
	 			<c:when test = "${userId != null}">
	 				<th></th>
	 			</c:when>
 			</c:choose>
			</tr>
			<c:forEach items="${products}" var="products">
		        <tr>
				<td>${products.name}</td>
				<td>${products.description}</td>
				<td>${products.price} $</td>
				<c:choose>
		 			<c:when test = "${userId != null}">
					<td>
						<form action="./products" method="post">
							<input type="hidden" name="id" value="${products.id}"/>
							<input type="hidden" name="price" value="${products.price}"/>
							<input type="hidden" name="name" value="${products.name}"/>
							<input type="hidden" name="description" value="${products.description}"/>
				 			<input type="number" name="quantity"/>
							<input type="submit" value="Add to chart"/>
						</form>
					</td>
					</c:when>
				</c:choose>
				</tr>
	      	</c:forEach>
		    
		</table>
	</body>
</html>