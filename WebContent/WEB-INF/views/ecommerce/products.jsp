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
		<table>
			<tr>
			<th>Product</th>
			<th>Description</th>
			<th>Price</th>
			<th></th>
			</tr>
			<c:forEach items="${products}" var="products">
		        <tr>
				<td>${products.name}</td>
				<td>${products.description}</td>
				<td>${products.price} $</td>
				<td>
					<form action="./addToChart" method="post">
						<input type="hidden" name="id" value="${products.id}"/>
			 			<input type="number" name="quantity"/>
						<input type="submit" value="Add to chart"/>
					</form></td>
				</tr>
	      	</c:forEach>
		    
		</table>
	</body>
</html>