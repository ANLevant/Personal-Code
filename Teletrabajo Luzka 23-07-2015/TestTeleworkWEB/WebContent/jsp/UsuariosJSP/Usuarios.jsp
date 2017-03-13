<%@page import="test.persistence.entities.Usuarios"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="usuarios" class="test.mb.UsuariosMB" scope="request"/>
	
	<table width = "80%">
		<% Iterator<Usuarios> iterador = usuarios.getUsuariosEncontrados().iterator();
			while(iterador.hasNext())
			{
				Usuarios usuario = iterador.next();
		%>
		<tr>
			<td><%= usuario.getUsuId()%></td>
			<td><%= usuario.getUsuApeUsu()%></td>
			<td><%= usuario.getUsuNomUsu()%></td>
			<td><%= usuario.getUsuCedUsu()%></td>
			<td><%= usuario.getUsuCorUsu()%></td>
			<td><%= usuario.getUsuTelUsu()%></td>
			<td><%= usuario.getUsuDirUsu()%></td>
		</tr>
		<% } %>
	</table>
</body>
</html>