<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import ="it.beije.ananke.entity.*" %>
<%@page import ="it.beije.ananke.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrello</title>
</head>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  margin-top:8px;
  margin-left:auto;
  margin-right:auto;
}
</style>
<body>
	<h2>Carrello</h2>
	<%if(session.getAttribute("order")!=null){%>
	<table>
	<tr>
		<th>#Ordine</th>
		<th>Codice Prodotto</th>
		<th>Quantità</th>
	</tr>
			<c:forEach items="${items}" var="item">
			<tr>
    		<td>${item.orderId}</td>
    		<td>${item.productId}</td>
   			<td>${item.quantity}</td>
   			</tr>
			</c:forEach>
			<tr><td>Totale: ${amount }</td></tr>
	</table><br>
	
	<a href="./continuaAcquisto"><button>Continua Acquisti</button></a>
	<a href="./confermaAcquisto"><button>Conferma Ordine</button></a>
	<a href="./annullaOrdine"><button>Annulla Ordine</button></a>
	<%}else{%>	
	<h2>Non hai ordini in corso</h2>
	<%} %>
	
	<a href="index"><button>Home</button></a>
</body>
</html>