<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Autenticazione</title>
</head>
<style type="text/css">
.sfondoDiv {
	Background-color: cyan;
	height : 50px;
	width: 50%;
	}
</style>
<body>
<div class = "sfondoDiv">
<h1>Autenticazione</h1>
</div>
<br>
<form action = "./sign" method ="post">
<table>
<tr><td>Email:</td><td> <input type = "email" name = "email" placeholder = "@mail"></td></tr>
<tr><td>Password:</td><td> <input type = "text" name = "password" placeholder = "*****"></td></tr>
</table>
<br>
<input type = "submit" value = "Sign-in">
</form>
<br>
Se non sei registrato,  <form action="./registrazione"><input type = "submit" value = "click here"></form>
</body>
</html>