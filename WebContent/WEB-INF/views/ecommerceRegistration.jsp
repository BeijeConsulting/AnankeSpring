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
		<label for="firstName">First name:</label><br>
  		<input type="text" id="firstName" name="firstName" ><br>
 		<label for="secondName">Last name:</label><br>
  		<input type="text" id="secondName" name="secondName"><br><br>
  		<label for="email">Email:</label><br>
  		<input type="text" id="email" name="email" required><br><br>
  		<label for="password">Password:</label><br>
  		<input type="password" placeholder="Enter Password" id="password" name="password" required><br><br>
  		<input type="submit" value="REGISTRATI">
	</form>
	
	<p>${message}</p>
	
</body>
</html>