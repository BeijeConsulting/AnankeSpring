<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<h3>Register</h3>
		<form action="/register" method="post">
			Name:&nbsp;<input type="text" name="name" value=""/><br>
			Surname:&nbsp;<input type="text" name="surname" value=""/><br>
			Email:&nbsp;<input type="text" name="email" value=""/><br/>
 			Password:&nbsp;<input type="text" name="password" value=""/><br>
			<br><input type="submit" value="Register"/>			
		</form>
		<br>
		<a href="login">
			<button>Back</button>
		</a>
</body>
</html>