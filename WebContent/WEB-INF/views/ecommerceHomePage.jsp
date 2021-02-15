<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<!-- qui metto il nome del tipo -->
	<h2>Caio Tipo!</h2>
	<form action = "" method = "get">
		<input type = "submit" value = "LOGOUT">
	</form>

	<table>
		<caption>
			<p>I NOSTRI PRODOTTI</p>
		</caption>
		<thead>
			<tr><th>PRODOTTO</th><th>PREZZO</th><th></th></tr>
		</thead>
		<!-- 
		<tfoot>
			<tr><td>Totale 1</td><td>Totale 2</td></tr>
		</tfoot>
		-->
		<tbody>
			<tr><td>prodotto 1</td><td>prezzo</td></tr>
			<tr><td>prodotto 2</td><td>prezzo</td></tr>
			<tr><td>prodotto 3</td><td>prezzo</td></tr>
		</tbody>
	</table>
	
<!-- mostriamo nel modo più facile i prodotti. 
	 il carrello sarà un label visibile da qualche parte nella stessa pagina che si aggiorna
	 con i prodotti man mano che venogono aggiunti
	 poi appena ci sarà questa cosa più "semplice" si pensa a qualche pagina in più -->
</body>
</html>