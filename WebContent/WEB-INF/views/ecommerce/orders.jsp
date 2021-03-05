<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Orders</title>
		<style>	
			table, tr, td, th {
		  	border: 1px solid #dddddd;
		 	border-collapse: collapse;
		  	text-align: left;
		  	padding: 8px;
			}
		</style>
	</head>
	<body>
		<%@ include file="home.jsp"%>
		<table>
			<tr>
			<th>Order</th>
			<th>Price</th>
	 		<th>State</th>
	 		<th></th>
			</tr>
			<c:forEach items="${orders}" var="orders">
		        <tr>
				<td>${orders.id}</td>
				<td>${orders.amount} $</td>
				<td>${orders.state}</td>
				<td>
					<form action="./orderItems" method="post">
						<input type="hidden" name="id" value="${orders.id}"/>
						<input type="submit" value="Show order"/>
					</form>
				</td>
				</tr>
	      	</c:forEach>
		    
		</table>
	</body>
</html>