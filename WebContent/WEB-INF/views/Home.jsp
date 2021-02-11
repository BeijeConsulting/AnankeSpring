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
		<div class="bordodestro">
			<a href="Login.html" class="nolink">Sign-in</a><br><br>
			<a href="/Registrazione" class="nolink">Sign-up</a>
			
		</div>
	</div>
	<br>
	<br>
	<div align="center">
		<table>
			<tr>
				<td><a href="ListaProdotti.jsp" class="nolink">Acquisti
						on-line</a></td>
			</tr>
			<tr>
				<td><a href="" class="nolink">Ordini</a></td>
			</tr>
			<tr>
				<td><a href="" class="nolink">Modifca profilo</a></td>
			</tr>
			<tr>
				<td><a href="tizio?id=" class="nolink">Esci</a></td>
			</tr>
		</table>
	</div>
</body>
</html>