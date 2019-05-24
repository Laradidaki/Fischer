<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Tabella Studenti</h1>
<hr>
<br>
<table border="1">

<tr>
<th>Nome</th>
<th>Cognome</th>
<th>Email</th>
</tr>

	<c:forEach var="tempStudenti" items="${listaStudenti}">
	<tr>
	<td>${tempStudenti.nome}</td>
	<td>${tempStudenti.cognome}</td>
	<td>${tempStudenti.email}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>