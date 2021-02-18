<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

.bordosinistro {
	
}

.nolink {
	text-decoration: none;
}

.elencoImmagini {
	align: right;
	width: 25%;
}

.flex {
	max-width: 25%;
}

.visible {
	text-align: left;
	display: ${visible};
}
.visibilita{
display: ${visibilita};
}
</style>

<body>
	<div class="bordi-arrotondati">
		<h1 align="center">HOME</h1>
         <h3 align="center">  <c:out value="${nome}"></c:out> </h3>
		<div align="right" class ="visibilita">
			<table>
				<tr>
					<td>
						<form action="./registrazione">
							<input type="submit" value="Registrati">
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<form action="./log">
							<input type="submit" value="Login">
						</form>
					</td>
				</tr>
			</table>
		</div>
	</div>

	<div class="visible">
		<table>

			<tr>
				<td><form action="./lista1">
						<input type="submit" value="Compra online">
					</form></td>
			</tr>
			<tr>
				<td><form action="./viewcart">
						<input type="submit" value="Ordini">
					</form></td>
			</tr>
			<tr>
				<td><form action="./pagemodifca">
						<input type="submit" value="Modifica profilo">
					</form></td>
			</tr>
			<tr>
				<td><form action="./out">
						<input type="submit" value="log-out">
					</form></td>
			</tr>

		</table>
	</div>

	
</body>
</html>