<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="home.jsp"%>
<h3>Insert new product</h3>
		<div>
		<form action="./newProduct" method="post">
			<div style="margin:10px; padding:2px;">
				<div style="margin:5px;">
					<label for="name">Name</label>
				</div>
				<div style="margin:5px;">
					<input style="padding:10px;" type="text" name="name" required size="25px;"/>
				</div>
			</div>
			<div style="margin:10px; padding:2px;">
				<div style="margin:5px;">
					<label for="description">Description</label>
				</div>
				<div style="margin:5px;">
					<input style="padding:10px;" type="text" name="description" required size="25px;"/>
				</div>
			</div>
			<div style="margin:10px; padding:2px;">
				<div style="margin:5px;">
					<label for="price">Price</label>
				</div>
				<div style="margin:5px;">
					<input style="padding:10px;" type="text" name="price" required size="25px;"/>
					$
				</div>
			</div>
			<div style="margin:5px;">
				<input type="submit" value="INVIO"/>
			</div>
		</form>
		</div>
</body>
</html>