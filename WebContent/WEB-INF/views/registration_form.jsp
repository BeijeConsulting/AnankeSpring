<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione</title>
</head>
<body>
		 <h1>Registrati</h1>
		  
		  <h3>Inserisci i dati nei campi sottostanti</h3>	  
				<form action ="./registerForm" method="post">
						<label for="name">Nome:</label><br>
						<input type="text" name="firstName" required><br>
						<label for="surname">Cognome</label><br>
						<input type="text" name="secondName" required><br>
						<label for="email">Email</label><br>
						<input type="email" name="email" required><br>
						<label for="password">Password</label><br>
						<input type="password" name="password" required><br>
						<input style="margin-top:8px;" type="submit" value="Registrati" >						
				</form>			
</body>
</html>