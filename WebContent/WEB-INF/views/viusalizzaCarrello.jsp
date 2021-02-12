<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.beije.ananke.ecommerce.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrello</title>
</head>
<body>

<%

	String httpCode = "";
	int id = (Integer) session.getAttribute("id");
	List<Carrello> list = DbManager.getCarrello(id);
	if(list.size() == 0){
		httpCode += "CARRELLO VUOTO";
	}else{
		for(Carrello c : list){
	
			Prodotto p = DbManager.getProdotto(c.getIdProdotto());
			httpCode += "Prodotto: " + p.getNome() + "Qta: " + c.getQta() + 
							"Prezzo: " + p.getPrezzo() * c.getQta();
			httpCode += "<br>";
		}
	}

%>

<%= httpCode %>

<form action="catalog" method="post">
<br><input type="submit" value="Torna al catalogo"/></form><br>

</body>
</html>