<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
  <style>
    table {
      font-family: arial, sans-serif;
      border-collapse: collapse;
      width: 100%;
    }

    h1 {
      text-align: centered;
    }

    th {
      border: 1px solid #dddddd;
      text-align: centered;
      padding: 8px;
    }

    td {
      border: 1px solid #dddddd;
      text-align: centered;
      padding: 8px;
    }

    tr:nth-child(even) {
      background-color: #dddddd;
    }
    </style>
    
</head>

<body>

<div class = "text-center">
	<h1>Tutti i Prodotti </h1>
</div>

<br>

${{conferma}}

<br>

 <a href="./aggiungiProdotto">Inserisci un Prodotto</a>
 <br>
 <a href="./eliminaProdotto">Rimuovi un Prodotto</a>
 
 
 
<br>
<br>


	<table style="width:60%">
	
      <tr>
      
        <th>Id</th>
        <th>Nome</th>
        <th>Descrizione</th>
        <th>Prezzo</th>
        
      </tr>
      
	<c:forEach var="p" items="${products}">
		
		<tr>
			<td>${p.id}</td>
			<td>${p.name}</td>
			<td>${p.description}</td>
			<td>${p.price}</td>
			<td> 
				<form action="./aggiungi" method="post"> 
	  				 <input type="number" name="quantity" value="0">
	  				 <input type="hidden" name="id" value="${p.id}">
	   				<p><input type="submit" value="Aggiungi al Carrello"></p>
   				</form>
   			<td>
		</tr>
			
	</c:forEach>
	
      
    </table>
    
 <br>
    
 <a href="./home">Torna alla home</a>
    
    

</body>

	