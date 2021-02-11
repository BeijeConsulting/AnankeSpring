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

<form action="./RegistrazioneServlet" method = "post">
<div class = "sfondoDiv">
<h1>Registrazione:</h1>
</div>
<br>
<table>
<tr><td>Email:</td><td> <input type = "text" name = "email" placeholder = "@mail"></td></tr>
<tr><td>First name:</td><td> <input type = "text" name = "first_name" placeholder = "Mario"></td></tr>
<tr><td>Second name:</td><td> <input type = "text" name = "second_name" placeholder = "Rossi"></td></tr>
<tr><td>password:</td><td> <input type = "password" name = "password" placeholder = "*********"></td></tr>
</table>
<br>
<input type = "submit" value = "Sign-up">

</form>
</body>
</html>