<%@page import="entity.Contato"%>
<%@page import="jdbc.ContatoDAO"%>
<%@page import="jdbc.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Contatos</title>
</head>
<body>
	<h1>Lista de Contatos</h1>
	<ul>
		<%
		    DAO db = new ContatoDAO();
		    for (Contato c : db.listAll()) {
		%>
		<li><%=c.getNome()%> &lt;<%=c.getEmail()%>&gt;</li>
		<%
		    }
		%>
	</ul>
</body>
</html>