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
	text-decoration: none;
}


.flex {
	max-width: 25%;
   
}

.visible {
   margin-top: 50px;
   display:${visible};

}
</style>

<body>
	<div class="bordi-arrotondati">
		<h1 align="center">HOME</h1>
		</div>
		<div class="bordodestro">
			<form action="./registrazione">
				<input type="submit" value="Registrati">
			</form>
			<br>
			<form action="./log">
				<input type="submit" value="Login">
			</form>
		</div>
	<br>
	<br>
	<div align="right" class="visible">
		<table>

			<tr>
				<td><form action="./lista1">
						<input type="submit" value="Compra online">
					</form></td>
			</tr>
			<tr>
				<td><form action="./lista1">
						<input type="submit" value="Ordini">
					</form></td>
			</tr>
			<tr>
				<td><form action="./lista1">
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
	
	<div class = "visual">
	<table>
	<tr>
	<td>        <img
				src="https://www.techwalls.com/wp-content/uploads/2020/10/iPhone-12-mini.jpg"
				class="flex">
	</td>
	</tr>
	<tr>
	<td>    <img
				src="https://store.hp.com/ItalyStore/Html/Merch/Images/c06716957_500x367.jpg"
				class="flex">
	</td>
	</tr>
	<tr>
	<td><img
				src="https://images.eprice.it/nobrand/0/hres/445/208962445/DAM208962445-1-147cbe9a-e464-43ad-9041-7e9683a2af03.jpg"
				class="flex">
	</td>
	</tr>
	<tr>
	<td> <img
				src="https://images-na.ssl-images-amazon.com/images/I/71XUx5JUGRL._AC_SX466_.jpg"
				class="flex">
	</td>
	</tr>
	
	</table>
	
	</div>
</body>
</html>