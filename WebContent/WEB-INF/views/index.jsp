<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Ecommerce Project</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css"/> 
<link href="./resources/css/style.css" rel="stylesheet">        
<script src="./resources/js/bootstrap.min.js"></script> 
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet"> 
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
</head>
<body>
<%@ include file = "navbar.jsp"%>
<div class = "container">

<c:if test="${user.firstName == null }">
<h1>Benvenuto su Ecommerce</h1>

<img alt="" src="./resources/images/sfondo.png" style="width:75%" data-aos="zoom-in" data-aos-duration="1000">
<div class="row row-cols-1 row-cols-md-2 " style="margin-top:0.5em;">
<div class="col mb-4" data-aos="zoom-in">
<div class="card text-center border-0">
<img src="./resources/images/registration.svg" class="card-img-top rounded mx-auto d-block" alt="..." style ="widht:100px; height:100px" >
  <div class="card-body">
   <h5 class="card-title">Registrati</h5>
   <p class="card-text"><a href="./registrationPage">Clicca qui</a></p>
   </div>
   </div>
   </div>
   <div class="col mb-4" data-aos="zoom-in">
<div class="card text-center border-0">
<img src="./resources/images/loginicon.svg" class="card-img-top rounded mx-auto d-block" alt="..." style ="widht:100px; height:100px">
  <div class="card-body">
   <h5 class="card-title">Accedi</h5>
   <p class="card-text"><a href="./loginPage">Clicca qui</a></p>
   </div>
   </div>
   </div>
   </div>

</c:if>
<c:if test="${user.firstName != null }">
<h1>Benvenuto ${user.firstName}</h1>
<h3>Ordini effettuati</h3>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Amount</th>
      <th scope="col">Prodotti</th>
     </tr>
      <tbody>
<c:forEach items="${orders}" var ="item">
<tr>
 <td>${item.id}</td>
 <td>${item.amount} Euro</td>
 <td><a href="./getOrderItem?id=${item.id}">Vedi Prodotti</a></td>
 </tr>
</c:forEach>
</tbody>
</table>

<c:if test="${user.email eq 'admin@admin.it'}">
<h2>Per aggiungere prodotti <a href="">clicca qui</a></h2>
</c:if>
</c:if>



</div>

<script>
  AOS.init();
</script>
</body>
</html>