<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi Prodotto</title>
</head>
<body>
<h2>Aggiungi un nuovo prodotto</h2>
<form action="./insertProduct" method="post">
<label for="email">Name</label><br>
  <input type="text" id="name" name="name"><br>
  <label for="email">Desc</label><br>
  <input type="text" id="desc" name="desc" style="height:2em;"><br>
  <label for="email">Price:</label><br>
  <input type="number" id="price" name="price" step="0.1"><br>
  <p><input type="submit" value="Aggiungi"></p>
</body>
</html>