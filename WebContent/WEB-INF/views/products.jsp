<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="ecommerce.model.JPAManager"%>
<%@page import="ecommerce.entity.*"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prodotti</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css"/> 
<link href="./resources/css/style.css" rel="stylesheet">        
<script src="./resources/js/bootstrap.min.js"></script>   
</head>
<body>
<%@ include file = "navbar.jsp" %>
<div class="container">


<div class="row row-cols-1 row-cols-md-3">
<c:catch>

</c:catch>
<c:forEach items = "${products}" var = "item" > 
<div class="col mb-4">
<div class="card text-center">
  <div class="card-body">
   <h5 class="card-title">${item.name}</h5>
   <p class="card-text">${item.desc}</p>
   <p> ${item.price} Euro</p>
   <form action="./addCart" method="post"> 
   <input type="number" name="quantity" value="0">
   <input type="hidden" name="id" value="${item.id}">
   <p><input type="submit" value="Scegli"></p>
  </form>
   </div>
   </div>
</div>
</c:forEach>
</div>
<p><a href="./cartView"><button>Visualizza il carrello</button></a></p>

 


<c:if test="${cart != null }">
<c:forEach items="${cart_item}" var="item">
<p>${item.p.id}</p>
<p>${item.p.name}</p>
</c:forEach>
<h2>${cart.amount}</h2>

<p><a href="./completeOrder"><button>Acquista</button></a></p>

</c:if>
</div>
</body>
</html>