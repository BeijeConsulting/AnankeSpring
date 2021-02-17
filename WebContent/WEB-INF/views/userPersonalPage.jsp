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

 <h2> Personal page of ${user.getFirstName()} </h2>
 <h3>Choose products and give order!</h3>
 <p style="text-align:right">Cart : ${quantity} items</p>
<c:forEach items = "${allProducts}" var = "item" > 
 <div  style="border-top: 1px solid red;
			border-bottom: 1px solid #9494b8; background-color: #dfff80">
 Product id: ${item.id} <br>
  Product Name :  ${item.productName} <br>
  Description :  ${item.productDescription} <br> 
  Price :  ${item.price}$<br>
    <form action="./addToCartPost" method="post">
  <label for="quantity">Quantity :</label>
  <input type="number" name="quantity" value="0" >
  <input type="hidden" name="id" value="${user.getId()}"/>  
  <input type="hidden" name="productId" value="${item.id}"/>
  <input type="submit" value = "addToCart">
</form>
    <br> <br>
  </div> 
</c:forEach>

<p><a href="./cartPage">See carello</a></p>
<br><br><br><br><br><br>
<p>use the back button to go back</p>
</body>
</html>