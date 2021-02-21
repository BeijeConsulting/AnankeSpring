 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
    
  .carousel-inner img {
      width: 25%; /* Set width to 100% */
      margin: auto;
      min-height:200px;
  }

  /* Hide the carousel text when the screen is less than 600 pixels wide */
  @media (max-width: 600px) {
    .carousel-caption {
      display: none; 
    }
    .h{
    align: right;
    color: black;
    }
  }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="http://localhost:8080/AnankeSpring/lista1">Acquista</a></li>
        <li><a href="#">Projects</a></li>
        <li><a href="http://localhost:8080/AnankeSpring/out">Logout</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><c:out value="${nome}"></c:out></li>
      </ul>
    </div>
  </div>
</nav>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
     <div class="item active">
          <img src="https://www.techwalls.com/wp-content/uploads/2020/10/iPhone-12-mini.jpg" >
        
        <p> iPhone12 in promozione!</p>
        <div class="carousel-caption">
          <h3 align=right ><font color = black>899.99 $</font></h3>
          <p>Acquista</p>
        </div>      
      </div>

      <div class="item">
         <img src="https://images.eprice.it/nobrand/0/hres/445/208962445/DAM208962445-1-147cbe9a-e464-43ad-9041-7e9683a2af03.jpg" width = 25%>
        <p>AppleWatch in promozione!</p>
        <div class="carousel-caption">
          <h3 align=right><font color = black>250.99 $</font></h3>
          <p>Acquista</p>
        </div>      
      </div>
    <div class="item">
         <img src="https://store.hp.com/ItalyStore/Html/Merch/Images/c06716957_500x367.jpg" width = 25%>
        <p>Pc Hp in promozione!</p>
        <div class="carousel-caption">
          <h3 align=right><font color = black>1000.00 $</font></h3>
          <p>Acquista</p>
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
  
<div class="container text-center">    
  <h3><c:out value="${nome}"></c:out></h3><br>
  <div class="row">
    <div class="col-sm-4">
   
      <img src="https://images-na.ssl-images-amazon.com/images/I/71XUx5JUGRL._AC_SX466_.jpg" width = 25%>
        <p>Tv in promozione!</p>
     
    </div>
    <div class="col-sm-4"> 
       <img src="https://www.techwalls.com/wp-content/uploads/2020/10/iPhone-12-mini.jpg" width=25%>
        
        <p> iPhone12 in promozione!</p>
    </div>
    <div class="col-sm-4">
      <div class="well">
       <p>I miglior prodotti in circolazione!</p>
      </div>
    </div>
  </div>
</div><br>

<footer class="container-fluid text-center">
  <p>@BittiIndustries</p>
</footer>

</body>
</html>
