<!doctype html>
<html>
	<head>
		<title>FORM POST</title>
		<style>
		</style>
	</head>
	<body>
		<h3 style="text-align:center;">Login</h3>
		<div>
		<form action="./login" method="post" style="text-align: center;">
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
		<div style="text-align:center;">
			OR
		</div>
		<div style="margin:5px; text-align:center;">
			<a href="./register">Register</a>
		</div>
	</body>
</html>