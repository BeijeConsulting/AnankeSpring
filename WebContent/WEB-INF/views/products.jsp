<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="ecommerce.model.JPAManager"%>
<%@page import="ecommerce.entity.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prodotti</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
       <link rel="stylesheet" href="bootstrap.min.css"/> 
       <link href="style.css" rel="stylesheet">        
       <script src="bootstrap.min.js"></script>  
</head>
<body>
<%@ include file = "navbar.jsp" %>
<div class="container">
<form action="orderServlet" method="post">

<div class="card-group " >
<% List<Product> products = JPAManager.getAllProducts();
for(Product p: products){
%>
<div class="card text-center">
  <div class="card-body">
   <h5 class="card-title"><%= p.getName()%></h5>
   <p class="card-text"><%= p.getDesc() %></p>
   <p> <%= p.getPrice() %> Euro</p>
   <label for="number">Quantità</label>
   <input id="number" type="number" name ="quantity<%= p.getId() %>" value="0"><br>
   <label for="product">Seleziona</label>
   <input type="checkbox" id="product" name="product<%= p.getId() %>" value="<%= p.getId() %>">
   </div>
</div>
<%} %>

</div>
<p><input type="submit" class="btn btn-dark" value="procedi"></p>
</form>
</div>
</body>
</html>