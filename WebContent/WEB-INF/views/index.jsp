<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import ="it.beije.ananke.entity.*" %>
<%@page import ="it.beije.ananke.model.*" %>
<%@page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  margin-top:8px;
  margin-left:auto;
  margin-right:auto;
}
</style>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/style.css">
<title>Home</title>
</head>
<body>
 <h1>Benvenuto nella home</h1>


<%if(session.getAttribute("user")==null){%>
<div class="topnav">
  <a class="active" href="index.jsp">Home</a>
  <a href="./register">Registrati</a>
  <a href="./login">Accedi</a>
  <a href="./productServlet">Prodotti</a>
</div><%}else{ %><div class="topnav">
  <a class="active" href="index.jsp">Home</a>
  <a href="registration_form.jsp">Registrati</a>
  <a href="./logout">Logout</a>
  <a href="./productServlet">Prodotti</a>
</div><%} %>
 
 <%List<Product> prodotti = JPAmanager.findAllProduct();%>
 <table>
	<tr>
		<th>Nome</th>
		<th>Descrizione</th>
		<th>Prezzo</th>
	</tr>
	<%for(Product prod : prodotti){%>
	<tr>
	<td><%=prod.getName()%></td>
	<td><%=prod.getDesc()%></td>
	<td><%=prod.getPrice() %>&nbsp;$</td>
	<td><a href="./OrderServlet?id=<%=prod.getId()%>">Acquista</a></td>
	</tr><%} %>
</table>
		  
</body>
</html>