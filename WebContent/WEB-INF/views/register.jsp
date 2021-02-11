<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Inserisci i dati</h3>
		<div>
		<form action="./Register" method="post">
			<div style="margin:10px; padding:2px;">
				<div style="margin:5px;">
					<label for="first_name">First name</label>
				</div>
				<div style="margin:5px;">
					<input style="padding:10px;" type="text" name="first_name" required size="25px;"/>
				</div>
			</div>
			<div style="margin:10px; padding:2px;">
				<div style="margin:5px;">
					<label for="last_name">Last name</label>
				</div>
				<div style="margin:5px;">
					<input style="padding:10px;" type="text" name="last_name" required size="25px;"/>
				</div>
			</div>
			<div style="margin:10px; padding:2px;">
				<div style="margin:5px;">
					<label for="email">Email</label>
				</div>
				<div style="margin:5px;">
					<input style="padding:10px;" type="email" name="email" required size="25px;"/>
				</div>
			</div>
			<div style="margin:10px; padding:2px;">
				<div style="margin:5px;">
					<label for="password">Password</label>
				</div>
				<div style="margin:5px;">
					<input type="password" style="padding:10px;" type="text" name="password" required size="25px;"/>
				</div>
			</div>
			<div style="margin:5px;">
				<input type="submit" value="INVIO"/>
			</div>
		</form>
		</div>
</body>
</html>