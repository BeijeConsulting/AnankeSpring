<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order</title>
</head>
<body>
	<h3>Order</h3>
	
	<table>
		<tr>
			<th>Product</th>
			<th>Description</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Amount</th>
		<tr>
			<c:forEach var = "orderItem" items="${orderItem}">
				<td>${orderItem.name}</td>
				<td>${orderItem.quantity}</td>
				<td>${orderItem.amount}</td>
			</c:forEach>		
		</tr>
	</table>

</body>
</html>