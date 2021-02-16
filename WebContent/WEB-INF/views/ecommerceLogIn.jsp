<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn to Anank-E-Commerce</title>
</head>
<body>
<div>
		<h3>Benvenuto nel form di logIn</h3>
		<p>Inserisci email e password</p>
	</div>
	
	<form action="./homePage" method = "post">
  		<label for="email">Email:</label><br>
  		<input type="text" id="email" name="email"><br><br>
  		<label for="password">Password:</label><br>
  		<input type="text" id="password" name="password"><br><br>
  		<input type="submit" value="ACCEDI">
	</form>
	
</body>
</html>