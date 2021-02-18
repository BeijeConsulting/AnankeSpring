<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Profilo</title>
</head>
<style type="text/css">
.sfondoDiv {
	Background-color: cyan;
	height : 40px;
	width: 50%;
	}
</style>
<body>
<div class = "sfondoDiv">
<h1>Modifica profilo:</h1>

</div>
<br>
<form action="./modificauser" method = "get">
<table>
<tr><td>Nome:</td><td> <input type = "text" name = "first_name" placeholder = "Mario"></td></tr>
<tr><td>Cognome:</td><td> <input type = "text" name = "second_name" placeholder = "Rossi"></td></tr>
<tr><td>password:</td><td> <input type = "password" name = "password" placeholder = "*********"></td></tr>
</table>
<input type = "submit" value = "Modifica">
</form>
</body>
</html>