<%@ page import = "java.util.*, eserciziostudenti2.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	List<Studente>studenti=
						(List<Studente>)request.getAttribute("listaStudenti");
%>
<body>
<%= studenti%>
</body>
</html>