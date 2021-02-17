<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="it.beije.ananke.model.User"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Carrello</title>
	</head>
	<body>
		<%User user = (User) session.getAttribute("user"); %>
		<h3>Carrello di <%= user.getFirstName() %></h3>
		<c:choose>
			<c:when test="${cart != null}">
				<table>
					<tr>
       					<th>NOME</th>
	  					<th>COSTO</th>
	   					<th>QUANTITA'</th>
  					</tr>
  					<c:forEach var = "p" items="${cart.list}"> 
  						<tr>
  							<td>${p.name}</td>
  							<td>${p.amount}</td>
  							<td>${p.quantity}</td>
  							<td>
  								<form action="./rimuovi" method="post">
  									<input type="hidden" name= "orderItemId" value="${p.orderItemId}">
  									<input type="submit" value="RIMUOVI"/>
  								</form>
  							</td>
  						</tr>
  					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				"Il carrello è vuoto."
			</c:otherwise>
		</c:choose>
		<p>
		<table>
			<tr>
				<td>
					<form action="./mainShopping" method ="get">
						<input type="submit" value="Torna al catalogo"/>
					</form>
				</td>
				<td>
					<form action="./chiudiOrdine">
						<input type="submit" value="Acquista"/>
					</form>
				</td>
			</tr>
		</table>
	</body>
</html>