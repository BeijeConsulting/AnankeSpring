<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Autenticazione</title>
</head>
<body>
	
<form action="./updateUsers" method = "post">
		
<table>
<tr><td>PSW:</td><td> <input type = "text" name = "password" placeholder = "*****"></td></tr>
<tr><td>NOME:</td><td> <input type = "text" name = "first_name" placeholder = ""></td></tr>
<tr><td>COGNOME:</td><td> <input type = "text" name = "second_name" placeholder = ""></td></tr>

</table>
<input type = "submit" value = "MODIFICA">

</form>

<form action="./annullaUpdate" method = "post">
<input type = "submit" value = "ANNULLA">
</form>

<p>
<a href=""></a>
</p>


	</form>

</body>
</html>