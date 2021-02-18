<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Storico ordini</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  margin-top:8px;
  margin-left:auto;
  margin-right:auto;
}

h2{text-align: center;}
</style>
</head>
<body>

<h2>Ordini effettuati</h2>


<c:choose>
    <c:when test="${orders.isEmpty() }">
        <h3 style="text-align:center;"> Non hai ancora effettuato ordini</h3>
    </c:when>
    <c:otherwise>
        <table>
	<tr>
		<th>#Ordine</th>
		<th>Totale</th>
		<th>Stato</th>
	</tr>
	<c:forEach items="${orders}" var="ord">
	<tr>
	<td>${ord.id}</td>
	<td>${ord.amount }&nbsp;$</td>
	<td>${ord.state}</td>
	</tr></c:forEach>
</table>
    </c:otherwise>
</c:choose>


	

</body>
</html>