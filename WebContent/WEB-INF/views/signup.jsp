<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
	<head>
		<title>SIGN UP</title>
		<style>
		</style>
	</head>
	<body>
		<h3>Registrati</h3>
		<form action="./ServletSignUp" method="post">
			NAME:&nbsp;<input type="text" name="name_param" value=""/><br/>
			SURNAME:&nbsp;<input type="text" name="surname_param" value=""/><br>
 			EMAIL:&nbsp;<input type="text" name="email" value=""/><br>
 			PASSWORD:&nbsp;<input type="text" name="password" value=""/><br>
			<br><input type="submit" value="REGISTRATI"/>
		</form>
	</body>
</html>
