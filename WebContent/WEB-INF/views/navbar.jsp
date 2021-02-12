<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="ecommerce.model.JPAManager"%>
<%@page import="ecommerce.entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>navbar</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
       <link rel="stylesheet" href="bootstrap.min.css"/> 
       <link href="style.css" rel="stylesheet">        
       <script src="bootstrap.min.js"></script>  
</head>
<body>

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
        <%
        User u = (User) session.getAttribute("user");
        if(u == null){
        	
        }else{
        
        %>
        <li class="nav-item">
          <a class="nav-link" href="./productsPage">Prodotti</a>
        </li>
        <%if(u.getEmail().equals("admin@admin.it")){ %>
         <li class="nav-item">
          <a class="nav-link" href="./dashboard">Administration Panel</a>
        </li>
        <%} %>
         </ul>
        <ul class="navbar-nav mr-auto">
         <li class="nav-item">
          <a class="nav-link" href="./logout">Logout</a>
        </li>
        </ul>
        <%} %>
      
        
     
    </div>
  </div>
</nav>
</body>
</html>