<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!doctype html>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>LOGIN</title>
		<style>
		</style>
	</head>
	<body>
		<h3>Identificati per accedere al sito:</h3>
		<form action="./verifica" method="post">
			EMAIL:&nbsp;<input type="text" name="email" value=""/><br/>
 			PASSWORD:&nbsp;<input type="text" name="password" value=""/><br>
			<br><input type="submit" value="ACCEDI"/>
		</form>
		<c:if test="${errore != null}">${errore}</c:if>
	</body>
</html>
