<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="ecommerce.entity.*"%>
    <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ecommerce Amministration Panel</title>
</head>
<body>
<%
List<User> u = (ArrayList<User>)request.getAttribute("users");
List<Product> p = (ArrayList<Product>)request.getAttribute("products");
%>
<h2> Ci sono <%= u.size() %> utenti registrati</h2><br>
<h2> Ci sono <%= p.size() %> prodotti disponibili</h2>
</body>
</html>