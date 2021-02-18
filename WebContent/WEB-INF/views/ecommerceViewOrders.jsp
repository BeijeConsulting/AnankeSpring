<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@page import ="it.beije.ananke.ecommerce.beans.*" %>    
<%@page import ="it.beije.ananke.ecommerce.repositories.*" %> 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
	
		<%! int index = 1; %>
		
		<c:forEach var = "order" items="${orders}">
			<!-- faccio una riga speciale che collassa qualche colonna per le info dell'ordine => colspan="2"-->
			<tr>
				<!-- <th> è per le righe header -->
				<th>
					Ordine numero:
				</th>
				<th>
					<% System.out.print(index); %>
				</th>
			</tr>
			
			<c:forEach var = "item" items="${orders.items}">
		
				<!-- ciclo per ogni prodotto nell'ordine-->
				<tr>
					<td>${item.id}</td>
					<td>${item.quantity}</td>
				</tr>
				
			</c:forEach>
			
			<!-- piede dell'ordine con il totale -->
			<tr>
				<td>Totale</td>
				<td>${order.amount} $</td>
			</tr>
			
			<% index++; %>
			
		</c:forEach>
			
	</table>

	<form action = "./homePage" method = "get">
		<input type = "submit" value = "LOGOUT">
	</form>
</body>
</html>