<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="ecommerce.entity.*"%>
    <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ecommerce Amministration Panel</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css"/> 
<link href="./resources/css/style.css" rel="stylesheet">        
<script src="./resources/js/bootstrap.min.js"></script>  
</head>
<body>
<%@ include file = "navbar.jsp"%>
<div class="container">
<h2> Ci sono ${users} utenti registrati</h2><br>
<h2> Ci sono ${products} prodotti disponibili</h2>
<h2><a href="./addProductPage">Aggiungi prodotto</a></h2>
</div>
</body>
</html>