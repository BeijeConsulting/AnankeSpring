<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="it.beije.ananke.model.Product"%>
<%@page import="it.beije.ananke.model.JPAmanager"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista prodotti</title>
</head>
<body>
	<h1>LISTA DEI PRODOTTI:</h1>


	<table border=1>

		<th>Nome</th>
		<th>Descrizione</th>
		<th>Prezzo</th>
		<th>Quantità</th>


		<c:forEach var="i" items="${listaProdotti}">
			<tr>
				<td><c:out value="${i.name}" /></td>
				<td><c:out value="${i.desc}" /></td>
				<td><c:out value="${i.price}" /></td>
				<td>
					<form action="./acq ${i.id}" method="post">
				<td><input type="number" name="quantita" min=0 max=10></td>
				<td><input type="submit" value="acquista"></td>
					</form>

				<td><form action="./prodottoSpec ${i.id}" method="post">
						<input type="submit" value="guarda">
					</form></td>


			</tr>
		</c:forEach>

	</table>
</body>
</html>