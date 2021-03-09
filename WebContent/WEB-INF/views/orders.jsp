<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
<style>
#order {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#order td, #order th {
  border: 1px solid #ddd;
  padding: 8px;
}

#order tr:nth-child(even){background-color: #f2f2f2;}

#order tr:hover {background-color: #ddd;}

#order th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #00b3b3;
  color: white;
}
	ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #5C5C5E;
	}

	li {
	  float: left;
	}
	
	li a {
	  display: block;
	  color: white;
	  text-align: center;
	  padding: 14px 16px;
	  text-decoration: none;
	}
	
	/* Change the link color to #111 (black) on hover */
	li a:hover {
	  background-color: #111;
	}
</style>
</head>
<body>
	<ul>
	  <li><a href="products">Home</a></li>
	  <li><a href="">My orders</a></li>
	  <li><a href="">Profile</a></li>
	  <li style="float:right"><a class="active" href="login">Logout</a></li>
	</ul>

	<h3>Orders</h3>
	
	<table id="order">
		<tr>
			<th>Order</th>
			<th>State</th>
			<th>Amount</th>
			
			<c:forEach var = "order" items="${orders}">
				<tr>			
					<td>${order.id}</td>
	    			<td>${order.state}</td>
					<td>${order.amount}</td>
				</tr>
			</c:forEach>		
	</table>
	
</body>
</html>