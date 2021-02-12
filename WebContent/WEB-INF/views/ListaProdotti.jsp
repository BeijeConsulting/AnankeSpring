<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="it.beije.ananke.model.Product"%>
   <%@page import="it.beije.ananke.model.JPAmanager"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista prodotti</title>
</head>
<body>
	<h1>LISTA DEI PRODOTTI:</h1>
	<%
	JPAmanager<?> jsp = new JPAmanager();
	ArrayList<Product> listaProdotti = (ArrayList<Product>) jsp.getList("Product");
	%>
	<div align = center>
		<table border=1>

			<th>Nome</th>
			<th>Descrizione</th>
			<th>prezzo</th>

			<%
		for (Product p : listaProdotti) {
		%>
			<tr>
				<td><%=p.getName()%></td>
				<td><%=p.getDesc()%></td>
				<td><%=p.getPrice()%></td>
				<td><form action="./check?id=<%=p.getId()%>" name = "id"><input type = "submit" value = "Acquista"></form></td>
			</tr>
			<% } %>
		</table>
		</div>
</body>
</html>