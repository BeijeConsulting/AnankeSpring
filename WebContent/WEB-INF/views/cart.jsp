<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css"/> 
<link href="./resources/css/style.css" rel="stylesheet">        
<script src="./resources/js/bootstrap.min.js"></script>
<%@ include file = "navbar.jsp"%>
</head>
<body>
<div class="container">
<div class="row row-cols-1 row-cols-md-3">
<c:forEach items = "${cart_item}" var = "item" > 
<div class="col mb-4">
<div class="card text-center">
  <div class="card-body">
   <h5 class="card-title">${item.p.name}</h5>
   <p class="card-text">${item.quantity}</p>
   </div>
   </div>
</div>
</c:forEach>
</div>
<p><a href="./completeOrder"><button class = "btn btn-dark buttonform">Acquista</button></a></p>
</div>
</body>
</html>