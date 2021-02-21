<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<meta charset="ISO-8859-1">
<title>Registrazione</title>
</head>
<body>


<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Crea il tuo account</h4>
	<form action = "./inserimentoUtente" method = "post">
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="first_name" class="form-control" placeholder="Nome" type="text">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="second_name" class="form-control" placeholder="Cognome" type="text">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <input name="email" class="form-control" placeholder="email@" type="email">
        
    </div> <!-- form-group// -->

    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input name= "password" class="form-control" placeholder="password" type="password">

    </div> <!-- form-group// -->
                                     
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Crea account  </button>
    </div> <!-- form-group// -->      
    <p class="text-center">Hai già un account? <a href="http://localhost:8080/AnankeSpring/">Accedi</a> </p>                                                                 
</form>
</article>
 <c:if test="${error}">
 <center>
 <div class="form-group">
        <div class="col-sm-6 col-md-6">
            <div class="alert-message alert-message-warning">
                <h4>
                    Attenzione!</h4>
                <p>
                    Email già usata.<strong>Inserisci un'altra email</strong>.</p>
            </div>
        </div>
       
</div> <!-- card.// -->
</center>
 </c:if>
</div> 
<!--container end.//-->
       
<br><br>
<article class="bg-secondary mb-3">  
<div class="card-body text-center">
    <h4 class="text-white mt-3">e-commerce</h4>

</div>
<br><br>
</article>
</body>
</html>