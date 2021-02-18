<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrello</title>
</head>
<style type="text/css">
.sfondoDiv {
	Background-color: cyan;
	height : 40px;
	width: 50%;
	}

</style>
<body>
<div  class = "sfondoDiv">
	<h1>CARRELLO:</h1>
	</div>
<br>
<div>
<th>Prodotti nel carrello</th>

<table border = >
	   <c:forEach var = "i" items= "${listacarrello}">
       <tr>
       <td>
       <c:out value = "${i.name}"/>
       </td>
       <td>
       <form action = "./deleteitems ${i.id}" method = "get"><input type = "submit" value = "Elimina"></form>
       </td>
       </tr>
       </c:forEach>
        </table>
</div>

<br>
<form action = "./acquista"><input type = "submit" value = "acquista"></form>
</body>
</html>