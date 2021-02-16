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
<%
List<User> u = (ArrayList<User>)request.getAttribute("users");
List<Product> p = (ArrayList<Product>)request.getAttribute("products");

%>
<h2> Ci sono <%= u.size() %> utenti registrati</h2><br>
<h2> Ci sono <%= p.size() %> prodotti disponibili</h2>
<h2><a href="./addProductPage">Aggiungi prodotto</a></h2>
</body>
</html>