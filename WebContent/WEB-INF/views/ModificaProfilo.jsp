<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Profilo</title>
</head>
<body>
<form action="/modificauser">
<table>
<tr><td>First name:</td><td> <input type = "text" name = "first_name" placeholder = "Mario"></td></tr>
<tr><td>Second name:</td><td> <input type = "text" name = "second_name" placeholder = "Rossi"></td></tr>
<tr><td>password:</td><td> <input type = "password" name = "password" placeholder = "*********"></td></tr>
</table>
<input type = "submit">
</form>
</body>
</html>