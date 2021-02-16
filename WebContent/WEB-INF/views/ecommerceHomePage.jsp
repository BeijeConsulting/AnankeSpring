<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import ="it.beije.ananke.ecommerce.beans.*" %>    
<%@page import ="it.beije.ananke.ecommerce.repositories.*" %> 
<%@page import="java.time.LocalDateTime"%>
<%@page import ="java.util.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

	<style>
		table {
		border-collapse:collapse
		}
		td, th {
		border:1px solid #ddd;
		padding:8px;
		}
	</style>
	
<head>
<meta charset="ISO-8859-1">
<title>Anank-E-Commerce</title>
</head>
<body>

	<h2>Ciao ${firstName} !</h2>
	<form action = "../logOut" method = "get">
		<input type = "submit" value = "LOGOUT">
	</form>
	
	<table>
		<tr>
			<th>Nome</th>
			<th>Descrizione</th>
			<th>Prezzo</th>
		</tr>
		<c:forEach var = "product" items="${products}">
			 
			<tr>
			<td><c:out value = "${product.name}"/><p></td>
			<td><c:out value = "${product.desc}"/><p></td>
			<td><c:out value = "${product.price} $"/><p></td>
			<td>
				<form action = "./addProduct?productId=${product.id}&quantity=1&amount=${product.price}" method = "post">
					<input type = "submit" value = "ACQUISTA">
				</form>
			</td>
			</tr>
			
		</c:forEach>
		
	</table>
		
	<c:if test = "${seeCart}">
		<table>
		
			<!-- head della tabella -->
			<c:forEach var = "item" items="${cart.items}">
			 
				 <!-- vorrei poi fare un join tra product e orderItem per mostrare meglio il carrello -->
				<tr>
				<td><c:out value = "${item.productId}"/><p></td>
				<td><c:out value = "${item.quantity}"/><p></td>
				<td><c:out value = "${item.amount} $"/><p></td>
				</tr>
			
			</c:forEach>
			<tfoot>
				<tr>
				<td>
					<form action = "./buy" method = "post">
						<input type = "submit" value = "ACQUISTA">
					</form>
				</td>
				<td>Totale:</td>
				<td>${amount}</td>
				</tr>
			</tfoot>
		</table>
	</c:if>
	
</body>
</html>