<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!doctype html>
<html>
	<head>
		<title>LOGIN</title>
		<style>
		</style>
	</head>
	<body>
		<h3>Identificati per accedere al sito:</h3>
		<form action="./ServletLogin" method="post">
			EMAIL:&nbsp;<input type="text" name="email" value=""/><br/>
 			PASSWORD:&nbsp;<input type="text" name="password" value=""/><br>
			<br><input type="submit" value="ACCEDI"/>
		</form>
	</body>
</html>
