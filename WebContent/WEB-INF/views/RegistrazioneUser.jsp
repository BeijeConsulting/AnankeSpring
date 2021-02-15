<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Autenticazione</title>
</head>
<body>

	<form action="./RegistrazioneUser" method="post">

		<table>
			<tr>
				<td>EMAIL:</td>
				<td><input type="text" name="email" placeholder="@mail"></td>
			</tr>
			<tr>
				<td>NOME:</td>
				<td><input type="text" name="first_name" placeholder=""></td>
			</tr>
			<tr>
				<td>COGNOME:</td>
				<td><input type="text" name="second_name" placeholder=""></td>
			</tr>
			<tr>
				<td>PSW:</td>
				<td><input type="text" name="password" placeholder="*****"></td>
			</tr>
		</table>
		<input type="submit" value="Invia">

	</form>

	<form action="./log" method="post">
		<input type="submit" value="Logga">
	</form>

	<c:choose>
	<c:when test = "${Errore == false}">
	hai sbagliato a inserire email
	</c:when>
	<c:when test = "${Errore==true}">
	va nella home, ma qeusto messagio non lo vedrà mai.
	</c:when>
	<c:otherwise>
	questo ramo èimpossibile, un boolean è true o false.
	</c:otherwise>
	</c:choose>
<!--  <c:if test = "${Errore != true}">
    <c:out value =  "Errore nell' inserimento" />
</c:if> -->
</body>
</html>