<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rubrica</title>
</head>

<head>
	
	<meta charset="ISO-8859-1">
	
	<style>
	
	div.a {
	text-align: center;
	}
	
	li {
	text-align: center;
	}
	
	</style>
	
	<title>E-Commerce</title>
	
	</head>
	
	
	<body>
	
		<div class = "a">
	
		<h1>E-COMMERCE</h1>
	
		<h3>Inserisci i dati</h3>
			<form action="./login" method="post">
				
				${error}<br/>
				
				USERNAME:&nbsp;<input type="text" name="nome" value=""/><br/>
 				PASSWORD:&nbsp;<input type="text" name="password" value=""/><br>			
 				<br><input type="submit" value="ACCEDI"/>
			</form>
	    	
		   
		   
		   <form action="./registrazione" method="get">		
 				<br><input type="submit" value="REGISTRATI"/>
			</form>
		   
		</div>

</html>