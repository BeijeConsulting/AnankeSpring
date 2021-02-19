<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="it.beije.ananke.model.User"%>
<%@page import="it.beije.ananke.model.Product"%>
<%@page import="it.beije.ananke.model.JPAmanager"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title></title>
</head>
<body>
<%User user = (User) session.getAttribute("user");  %>
	<h1>Benvenuto, <%= user.getFirstName() %> cosa vuoi comprare?</h1>
	<table>
		<tr>
    		<th>ID</th>
       		<th>NOME</th>
	  		<th>DESCRIZIONE</th>
	   		<th>PREZZO</th>
  		</tr>
  		<c:forEach var = "p" items="${list}"> 
  			<tr>
  				<td>${p.id}</td>
  				<td>${p.name}</td>
  				<td>${p.descrip}</td>
  				<td>${p.price}</td>
  				<td>
  					<form action="./aggiungi" method="post">
  						<input type="hidden" name= "productId" value="${p.id}">
  						<input type="submit" value="Aggiungi"/>
  					</form>
  				</td>
  			</tr>
  		</c:forEach>
	</table>
	<p>
	<form action="./statoCarrello" method="get">
		<input type="submit" value="Visualizza il carrello">
	</form>
	<form action="./visualizzaOrdini" method="get">
		<input type="submit" value="Visualizza i tuoi ordini">
	</form>
</body>
</html>