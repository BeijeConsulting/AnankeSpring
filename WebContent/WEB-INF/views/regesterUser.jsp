<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>
   <%@ page import="it.beije.ananke.model.*"%> 
    <%@ page import="it.beije.ananke.dao.*"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>contatto Page</title>
</head>
<body>
<h1>hello to registration file</h1>
 firstName : ${firstName} 
 lastName : ${lastName} 
 email    : ${email}
 

 
 User user = new User(firstName,lastName,email,password);
  UserManager userManager = new UsersInJpaManager();
  userManager.setUser(user);
 
 <h2> user has been added </h2>

</body>
</html>