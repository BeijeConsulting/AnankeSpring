<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
	<head>
		<title>Reindirizzamento</title>
	</head>
	<body>
		<h3>Autenticazione fallita</h3>
		<form action="./login" method="post">
			<input type ="submit" value = "Accedi">
		</form>
		<form action="./home" method="post">
			<input type = "submit" value = "Home">
		</form>
	</body>
</html>
