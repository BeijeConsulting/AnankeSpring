<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="ecommerce.model.JPAManager"%>
<%@page import="ecommerce.entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>navbar</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css"/> 
<link href="./resources/css/style.css" rel="stylesheet">        
<script src="./resources/js/bootstrap.min.js"></script>  
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet"> 
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
</head>
<body>
<% User user = (User)session.getAttribute("user"); %>


<nav class="navbar navbar-expand-lg navbar-light navbar-custom">
  <div class="container-fluid">
    <a class="navbar-brand" href="./index" data-aos="zoom-in">Ecommerce Project</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./index">Home</a>
        </li>
          <li class="nav-item">
          <a class="nav-link" href="contacts.html">Contatti</a>
        </li>
        
        
         <c:if test="${user.email != null}">
        <li class="nav-item">
          <a class="nav-link" href="./productsPage">Prodotti</a>
        </li>

        <c:if test="${user.email eq 'admin@admin.it'}">
         <li class="nav-item">
          <a class="nav-link" href="./dashboard">Administration Panel</a>
        </li>
   		</c:if>
         </ul>
        <ul class="navbar-nav ms-auto">
        <c:if test="${cart_item != null }">
        <li class="nav-item">
        <a href="./cartPage" class="nav-link" data-toggle="dropdown" role="button" aria-expanded="false"> <img src="./resources/images/shopping-cart.png" style="width:16px;">${cart_item.size()} - Items</a>
        <span></span>
        </li>
        </c:if>
         <li class="nav-item">
          <a class="nav-link" href="./logout">Logout</a>
        </li>
        </c:if>
      
      
      
        
     
    </div>
  </div>
</nav>
<script>
  AOS.init();
</script>
</body>
</html>