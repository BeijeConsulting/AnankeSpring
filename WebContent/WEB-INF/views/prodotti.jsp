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

<h4> Prodotti </h4>

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
			<td>${p.desc}</td>
			<td>${p.price}</td>
		</tr>
			
	</c:forEach>
	
      
    </table>
    
 <br>
    
 <a href="./home">Torna alla home</a>
    
    

</body>

	