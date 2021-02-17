<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<!-- faccio una riga speciale che collassa qualche colonna per le info dell'ordine => colspan="2"-->
		<tr>
			<!-- <th> è per le righe header -->
			<th>
				Ordine numero:
			</th>
			<th>
				<!-- su che base numero gli ordini? perché non voglio tirare fuori proprio tutti tutti gli ordini fatti da un utente, ma solo gli ultimi.
					 d'altro canto... io non posso decidere quali tirare fuori, facendo solo una select sull'userId... avrei bisogno non so di una data
					 quindi comunque li tirerei fuori tutti per forza dal db e poi ne mostro solo alcuni tipo popolando un'altra lista partendo dalla 
					 listona di ordini fatti -->
			</th>
		</tr>
		
			<!-- ciclo per ogni prodotto nell'ordine-->
			<tr>
				<td>prodotto</td>
				<td>quantità</td>
			</tr>
			
		<!-- piede dell'ordine con il totale -->
		<tr>
			<td>Totale</td>
			<td>...$</td>
		</tr>
			
	</table>

</body>
</html>