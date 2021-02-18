<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PAGINA DEL PRODOTTO</title>
</head>
<style type="text/css">
.riduzione {
	width: 35%;
}
</style>
<body>
	<h2 align="center">${immagine.name}</h2>
	<br>
	<h3 align="center">DESCRIZIONE DEL PRODOTTO: ${immagine.desc}</h3>
	<br>
	<c:choose>
		<c:when test="${immagine.id == 1}">
			<center>
				<img
					src="https://www.identicoop.it/wp-content/uploads/2016/07/dentifricio-big.png"
					class="riduzione">
			</center>
		</c:when>
		<c:when test="${immagine.id == 2}">
			<center>
				<img
					src="https://www.ghebagas.it/files/prodotti/748/spazzola-curva-con-dorso-in-metallo-e-manico-in-plastica.jpg"
					class="riduzione">
			</center>
		</c:when>
		<c:when test="${immagine.id == 3}">
			<center>
				<img
					src="https://images-na.ssl-images-amazon.com/images/I/41VbRogtrfL._SX218_BO1,204,203,200_QL40_.jpg"
					class="riduzione">
			</center>
		</c:when>
		<c:otherwise>
			<c:out value="NESSUN' IMMAGINE DISPONIBILE" />
		</c:otherwise>
	</c:choose>
</body>
</html>