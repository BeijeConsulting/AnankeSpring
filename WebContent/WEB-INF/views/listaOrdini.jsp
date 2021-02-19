<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<table>
			<tr>
				<td>NUMERO</td>
				<td>STATO</td>
				<td>COSTO</td>
			</tr>
			<tr>
				<c:forEach var = "p" items="${list}"> 
					<td>${p.id}</td>
					<td>${p.state}</td>
					<td>${p.amount}</td>
				</c:forEach>
			</tr>
		</table>
		<form action="./statoCarrello" method="get">
			<input type="submit" value="Visualizza il tuo carrello">
		</form>
		<form action="./mainShopping" method="get">
			<input type="submit" value="Torna al catalogo">
		</form>
	</body>
</html>