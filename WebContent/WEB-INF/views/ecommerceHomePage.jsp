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
	<form action = "" method = "get">
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
				<form action = "./addProduct?id=${product.id}" method = "post">
					<input type = "submit" value = "ACQUISTA">
				</form>
			</td>
			</tr>
			
		</c:forEach>
	</table>
	
</body>
</html>