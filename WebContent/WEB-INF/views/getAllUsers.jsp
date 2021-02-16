<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<%@ page import="it.beije.ananke.model.*"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>all Users</title>
</head>
<body>

<table>
<tr>
<th>firstName</th>
<th>lastName</th>
<th>email</th>
</tr>
<c:forEach items = "${allUsers}" var = "item"> 
<tr>
   <td>${item.firstName}</td>
   <td>${item.lastName}</td>
   <td> ${item.email}</td>
   </tr>
</c:forEach>

</table>
<br><br><br><br><br><br>
<a href ="adminHomePage">Click to go to admin home page</a>
</body>
</html>
