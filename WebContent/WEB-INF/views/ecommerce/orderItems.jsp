<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Order items</title>
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
			<th>Product</th>
			<th>Description</th>
			<th>Quantity</th>
			<th>Amount</th>
	 		<th></th>
			</tr>
			<c:forEach items="${chart}" var="chart">
		        <tr>
				<td><c:out value = "${chart.name}"/></td>
				<td><c:out value = "${chart.description}"/></td>
				<td><c:out value = "${chart.quantity}"/></td>
				<td><c:out value = "${chart.amount}"/></td>
				<c:choose>
					<c:when test = "${order.state.equals(\"open\")}">
						<td>
							<form action="./removeOrderItem" method="post">
								<input type="hidden" name="id" value="${chart.id}"/>
								<input type="submit" value="Remove product"/>
							</form>
						</td>
					</c:when>
				</c:choose>
				</tr>
	      	</c:forEach>
		</table>
		<div>Total : ${order.amount}$</div>
		<c:choose>
			<c:when test = "${order.state.equals(\"open\")}">
				<form action="./confirmOrder" method="post">
					<input type="hidden" name="id" value="${orderId}"/>
					<input type="submit" value="Confirm order"/>
				</form>
			</c:when>
		</c:choose>
			
	</body>
</html>