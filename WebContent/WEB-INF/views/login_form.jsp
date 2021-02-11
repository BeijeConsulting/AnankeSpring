<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
			<h1>Login</h1>
		  
		  <h3>Inserisci i campi per l'accesso</h3>	  
				<form action ="./loginForm" method="post">
						
						<label for="email">Email</label><br>
						<input type="email" name="email" required><br>
						<label for="password">Password</label><br>
						<input type="password" name="password" required><br>
						<input style="margin-top:8px;" type="submit" value="Accedi" >						
				</form>			
</body>
</html>