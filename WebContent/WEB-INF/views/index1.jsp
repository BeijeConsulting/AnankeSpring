<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="it.beije.ananke.model.*"%>
        <%@page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="/WebContent/WEB-INF/views/style.css">
    <meta charset="UTF-8">
     <title>Ecommerce</title>
     
     
     <style> 
     body{
width: 100%;
height: 100%;
margin: 0;
padding: 0;
}
#navbar{
    width: 100%;
    height: 10%;
    display: block;
    background-color: deepskyblue;
margin:0;
align-items: center;
align-content: center;
text-align: center;
}
#conteiner{
    width: 100%;
    height: 100%;
    margin: 0%;
padding: 0;
min-height: 900px;
}
#login{
    position: absolute;
   right: 0px;
top:65px;
}
h1{
    display: inline-block;
}
#Content{
	margin-top:30px;
	align-items: center;
align-content: center;
text-align: center;
}
.prodotti{
float: left;
width: 33%;
height: 400px;
margin-top:30px;
}
     
     </style>
     
</head>
<body>
   
    <div id="conteiner"> 
        <div id="navbar">

<h1>  Ecommerce</h1>

<% 
String login= session.getAttribute("login")!=null?(String)session.getAttribute("login"):"" ;
boolean sessione= session.getAttribute("session")!=null?(boolean)session.getAttribute("session"):false;
if(!sessione&& !login.equals("ok")){
	
%>
            <div id="login"> 
                <form action="./login" method="post">
                    <input type="text" name="email" placeholder="mario@gmail.com" required>     <input type="password" name="password"  required> <button type="submit">login</button>
                </form>
              
            </div>
      <br>
      <br> 
      <a style="position:absolute; right:0px;" href="./registrazione">registrati</a>
          <% 
if(session.getAttribute("login")!=null){

if(login.equals("error")){
	 session.removeAttribute("login");
	out.print("<p>Attenzione utente o password sbagliata</p>");
}
}
%>
        </div>
        <% 
        }
if(session.getAttribute("login")!=null){

if(login.equals("ok")){
	Users user=(Users)session.getAttribute("users");
	out.print("<div> Benvenuto : "+user.getFirstNname()+"  "+ user.getSecondName() +"</div>");
%>
  <a style="position:absolute; right:0px;" href="./logout">Logout</a>
	<%
	}}
%>
<!-- <div id="Content"> -->


<!-- </div> -->
    </div>
</body>
</html>