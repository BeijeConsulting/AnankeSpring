<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@page import="it.beije.ananke.model.Product"%>
   <%@page import="it.beije.ananke.model.JPAmanager"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista prodotti</title>
</head>
<style type= "text/css">
.table {

 border : solid;
 border-collapse : collapse;
 width: 500px;

}


</style>
<body>
	<h1>LISTA DEI PRODOTTI:</h1>
	<%
	JPAmanager<?> jsp = new JPAmanager<>();
	ArrayList<Product> listaProdotti = (ArrayList<Product>) jsp.getList("Product");
	%>
	<div align = center>
		<table border= 1 class = "table">

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
				<td align="center"><form action="./preleva/<%=p.getId()%>"><input type = "submit" value = "Guarda"></form></td>
			</tr>
			<% } %>
		</table>
		</div>
</body>
</html>