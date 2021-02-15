<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="it.beije.ananke.model.Product"%>
   <%@page import="it.beije.ananke.model.JPAmanager"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista prodotti</title>
</head>
<body>
    <h1>LISTA DEI PRODOTTI:</h1>
    <%
    JPAmanager jsp = new JPAmanager();
    ArrayList<Product> listaProdotti = (ArrayList<Product>) jsp.getList("Product");
    %>
        <table border=1>

            <th>Nome</th>
            <th>Descrizione</th>
            <th>prezzo</th>

            <%
        for (Product p : listaProdotti) {
        %>
            <tr>
                <td><%=p.getName()%></td>
                <td><%=p.getDesc()%></td>
                <td><%=p.getPrice()%></td>
                <td><input type="number" name="quantita" min=0 max=10> </td>
                <td><a href="ListaProdotti?id=<%=p.getId()%>" name = "id"> Acquista </a></td>
            </tr>

            <% } %>
        </table>
</body>
</html>