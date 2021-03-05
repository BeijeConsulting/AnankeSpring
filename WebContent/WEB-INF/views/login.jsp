<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
	<head>
		<title>Login</title>
		<style>
		</style>
	</head>
	<body>
		<h3>Login</h3>
		<form action="./login" method="post">
			Email:&nbsp;<input type="text" name="email" value=""/><br/>
 			Password:&nbsp;<input type="text" name="password" value=""/><br>
			<br><input type="submit" value="Login"/>			
		</form>
		<br>
		<a href="register">
			<button>Register</button>
		</a>
	</body>
</html>
