<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration to Anank-E-Commerce</title>
</head>
<body>
	<div>
		<h3>Benvenuto nel form di registrazione</h3>
		<p>Inserisci i tuoi dati per poterti <br> registrare al nostro sito di e-commerce</p>
	</div>
	
	<form action="./registration" method = "post">
		<label for="first_name">First name:</label><br>
  		<input type="text" id="first_name" name="first_name" ><br>
 		<label for="second_name">Last name:</label><br>
  		<input type="text" id="second_name" name="second_name"><br><br>
  		<label for="second_name">Email:</label><br>
  		<input type="text" id="email" name="email"><br><br>
  		<label for="second_name">Password:</label><br>
  		<input type="text" id="password" name="password"><br><br>
  		<input type="submit" value="REGISTRATI">
	</form>
	
</body>
</html>