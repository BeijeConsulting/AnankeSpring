<%@page import="it.beije.ananke.ecommerce.Product"%>
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
			<th>Quantity</th>
			<th>Amount</th>
			
			<c:forEach var = "orderItem" items="${orderItems}">
				<tr>			
					<td>${orderItem.productId}</td>
	    			<td>${orderItem.quantity}</td>
					<td>${orderItem.amount}</td>
				</tr>
			</c:forEach>		
	</table>

<p>Total: </p>${total}

<br><a href="products"><button>Back</button></a>
<br><a href=""><button>Proceed to payment</button></a>
</body>
</html>