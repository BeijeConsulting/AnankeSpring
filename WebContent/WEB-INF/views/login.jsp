<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css"/> 
<link href="./resources/css/style.css" rel="stylesheet">        
<script src="./resources/js/bootstrap.min.js"></script>  
</head>
<body>
<%@ include file = "navbar.jsp"%>

<div class="container">
<div class="row" style="margin-top:2em;">
<div class="col-md-12 d-flex flex-column justify-content-center">
<div class="row">
<div class="col-lg-6 col-md-8 mx-auto">
<div class ="card rounded shadow shadow-sm">
<div class="card-header"><h3 class="mb-0">Login</h3></div>
<div class="card-body">
<form action="./auth" method="post">
<label for="email">Email:</label><br>
  <input type="text" id="fname" name="email"><br>
  <label for="email">Password:</label><br>
  <input type="password" id="lname" name="password">
  <p><input type="submit" class="btn btn-dark buttonform" value="Log in"></p>
</form>
<c:if test="${error != null}">
<h5>${error} <a href="./registrationPage">registrati</a></h5>
</c:if>
</div>
</div>
</div>
</div>
</div>
</div>
</div>

<%@ include file = "footer.jsp"%>
</body>
</html>