<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Anank-E-Commerce</title>
</head>
<body>
	<h2>${firstName}</h2>
	<p>Ecco il riassunto del tuo ordine</p>
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
					
				</td>
				<td>Totale:</td>
				<td>${amount}</td>
				</tr>
			</tfoot>
		</table>
		<form action = "./confirmedOrder" method = "post">
			<input type = "submit" value = "ACQUISTA">
		</form>
</body>
</html>