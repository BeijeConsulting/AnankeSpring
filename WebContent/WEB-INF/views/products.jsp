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


<div class="card-group " >
<% List<Product> products = JPAManager.getAllProducts();
for(Product p: products){
%>
<div class="card text-center">
  <div class="card-body">
   <h5 class="card-title"><%= p.getName()%></h5>
   <p class="card-text"><%= p.getDesc() %></p>
   <p> <%= p.getPrice() %> Euro</p>
   <form action="./addCart" method="post"> 
   <input type="number" name="quantity" value="0">
   <input type="hidden" name="id" value="<%=p.getId()%>">
   <p><input type="submit" value="Scegli"></p>
  </form>
   </div>
</div>
<%} %>
</div>
<p><a href="./viewCart"><button>Visualizza il carrello</button></a></p>

<% Cart cart = (Cart) request.getAttribute("cart"); 
if(cart == null){
} else{
for(Cart_Item ci : cart.getItems()){
%>
<p><%= ci.getP().getId() %></p>
<p><%= ci.getP().getName() %></p>
<%}} %>
</div>
</body>
</html>