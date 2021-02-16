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
</head>
<body>
<% String username = (String)session.getAttribute("username");
String usermail = (String)session.getAttribute("useremail");%>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Ecommerce Project</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
        </li>
          <li class="nav-item">
          <a class="nav-link" href="contacts.html">Contatti</a>
        </li>
        
        
         <c:if test="${username != null}">
        <li class="nav-item">
          <a class="nav-link" href="./productsPage">Prodotti</a>
        </li>

        <c:if test="${usermail eq 'admin@admin.it'}">
         <li class="nav-item">
          <a class="nav-link" href="./dashboard">Administration Panel</a>
        </li>
   		</c:if>
         </ul>
        <ul class="navbar-nav mr-auto">
         <li class="nav-item">
          <a class="nav-link" href="./logout">Logout</a>
        </li>
        </ul>
        </c:if>
      
      
      
        
     
    </div>
  </div>
</nav>
</body>
</html>