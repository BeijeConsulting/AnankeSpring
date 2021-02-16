<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<%@ page import="it.beije.ananke.model.*"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>all Products</title>
</head>
<body>

<table>
<tr>
<th>Name</th>
<th>description</th>
<th>Price</th>
<th>Add to Cart</th>
</tr>
<c:forEach items = "${allProducts}" var = "item" > 
<tr>
  <td> ${item.productName} </td>
  <td> ${item.productDescription} </td>
  <td> ${item.price}</td>
   </tr>
</c:forEach>
</table>
<br><br><br><br><br><br>
<p>use the back button to go back</p>

</body>
</html>