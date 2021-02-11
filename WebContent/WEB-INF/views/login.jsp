<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
       <link rel="stylesheet" href="bootstrap.min.css"/> 
       <link href="style.css" rel="stylesheet">        
       <script src="bootstrap.min.js"></script>  
</head>
<body>


<div class="container">
<form action="./auth" method="post">
<label for="email">Email:</label><br>
  <input type="text" id="fname" name="email"><br>
  <label for="email">Password:</label><br>
  <input type="password" id="lname" name="password">
  <p><input type="submit" class="btn btn-dark" value="Accedi"></p>
</form>
<% 
String state = (String)request.getAttribute("state");
if(state == null){
	

%>


<%
} else{
%>
<h5>Le credenziali sono sbagliate. Riprova oppure <a href="registration.jsp">registrati</a></h5>

<% } %>

</div>
</body>
</html>