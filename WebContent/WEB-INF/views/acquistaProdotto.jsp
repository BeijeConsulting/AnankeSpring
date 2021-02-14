<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="it.beije.ananke.model.Product"%>
<%@page import="it.beije.ananke.model.JPAmanager"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prodotto</title>
<style type="text/css">
.flex {
	max-width: 40%;

}
</style>
</head>
<body>
	<h1>Prodotto selezionato: <c:out value="${el.name}"></c:out></h1>  

	<c:choose>
		<c:when test="${el.id == 1}">
		<center>
			<img
				src="https://www.techwalls.com/wp-content/uploads/2020/10/iPhone-12-mini.jpg"
				class="flex">
				</center>
		</c:when>
		<c:when test="${el.id == 2}">
		<center>
			<img
				src="https://store.hp.com/ItalyStore/Html/Merch/Images/c06716957_500x367.jpg"
				class="flex">
				</center>>
		</c:when>
		<c:when test="${el.id == 3}">
		<center>
			<img
				src="https://images.eprice.it/nobrand/0/hres/445/208962445/DAM208962445-1-147cbe9a-e464-43ad-9041-7e9683a2af03.jpg"
				class="flex">
				</center>
		</c:when>
		<c:when test="${el.id == 4}">
		<center>
			<img
				src="https://images-na.ssl-images-amazon.com/images/I/71XUx5JUGRL._AC_SX466_.jpg"
				class="flex">
				</center>
		</c:when>
	</c:choose>
	<h2>Prezzo: <c:out value="${el.price}"></c:out>$</h2>
	<h3>Descrizione prodotto: <c:out value="${el.desc}"></c:out>. </h3> <br>
	<form action = "../addorder ${el.id}" method = "get">
	Quanti ne vuoi acquistare? 
	<select name = "numero">
	<option value = "1">1
	<option value = "2">2
	<option value = "3">3
	<option value = "4">4
	<option value = "5">5
	</select>
	<input type= "submit"  value = "Conferma">
</form>
</body>
</html>