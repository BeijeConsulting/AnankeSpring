<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contatti</title>
</head>
<body>
<%@ include file = "navbar.jsp"%>
<div class = "container">

<h2>Per contattare il servizio tecnico compila il form:</h2>
<div class="row" style="margin-top:2em;">
<div class="col-md-12 d-flex flex-column justify-content-center">
<div class="row">
<div class="col-lg-6 col-md-8 mx-auto">
<div class ="card rounded shadow shadow-sm">
<div class="card-header"><h3 class="mb-0">Contattaci</h3></div>
<div class="card-body">
<form action="./auth" method="post">
<label for="email">Email:</label><br>
  <input type="text" class="form-control" id="fname" name="email"><br>
  <label for="email">Message:</label><br>
  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
  <p><input type="submit" class="btn btn-dark buttonform" value="Contact us"></p>
</form>
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