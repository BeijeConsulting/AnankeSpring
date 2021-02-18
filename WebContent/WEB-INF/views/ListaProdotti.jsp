<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="it.beije.ananke.model.Product"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista prodotti</title>
</head>
<style type= "text/css">
.table {

 border : solid;

 width: 500px;

}
.sfondoDiv {
	Background-color: cyan;
	height : 40px;
	width: 50%;
	}

</style>
<body>
    <div  class = "sfondoDiv">
	<h1>LISTA DEI PRODOTTI:</h1>
	</div>
	<br>
	<div align = left>
		<table border= 1 class = "table">

			<th>Nome</th>
			<th>Descrizione</th>
			<th>prezzo</th>

		
		<c:forEach var = "i" items= "${list}" >
       <p>
			<tr>
				<td><c:out value = " ${i.name}"/></td>
				<td><c:out value = " ${i.desc}"/></td>
				<td><c:out value = " ${i.price}"/></td>
				<td align="center"><form action="./preleva ${i.id}" method = "post"><input type = "submit" value = "Guarda"></form></td>
			</tr>
			</c:forEach>
		</table>
		</div>
		<br>
		<form action="./viewcart"><input type = "submit" value = "Guarda carrello"></form>
		
</body>
</html>