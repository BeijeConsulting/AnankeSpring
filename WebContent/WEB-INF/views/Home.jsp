<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<style type="text/css">
.bordi-arrotondati {
	border-radius: 5px; /*ie >9*/
	-moz-border-radius: 5px; /*firefox*/
	-webkit-border-radius: 5px; /*chrome, safari*/
	background: cyan;
	height: 60px;
	padding: 10px;
	margin-right: auto;
	margin-left: auto;
}
.bordodestro {
     width: 100px;
}
.nolink {
	text-decoration: none
}
</style>
<body>
	<div class="bordi-arrotondati">
		<h1 align="center">HOME</h1>
		
	</div>
	<br>
	<br>
	<div align="center">
		<table>
			<tr>
				<td>
				<form action="./buy" method = "post">
					<input type = "submit" value = "acquista">
				</form>
			</tr>
			<tr>
				<td><a href="" class="nolink">Ordini</a></td>
			</tr>
			<tr>
				<form action="./mod" method = "post">
					<input type = "submit" value = "modifica profilo">
				</form>
			</tr>
			<tr>
				<td><form action="./out" method = "post">
					<input type = "submit" value = "ESCI">
				</form></td>
			</tr>
		</table>
	</div>
</body>
</html>