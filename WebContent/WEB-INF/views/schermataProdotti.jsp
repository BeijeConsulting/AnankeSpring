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

	<h1>Benvenuto, <c:out value="${user.firstName}"/> cosa vuoi comprare?</h1>
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
  					<form action="aggiungi" method="post">
  						<input type="submit" value="ACQUISTA"/>
  					</form>
  				</td>
  			</tr>
  		</c:forEach>
	</table>
</body>
</html>