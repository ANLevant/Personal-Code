<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form name="formularioRegistro" method="POST" action="UsuarioRegistrarPost.jsp">
		Nombre: <input type="text" name="nombre">	<br/>
		Apellido: <input type="text" name="apellido"><br/>	
		Cedula: <input type="text" name="cedula">	<br/>
		Correo: <input type="text" name="correo">	<br/>
		Telefono: <input type="text" name="telefono">	<br/>
		Direccion: <input type="text" name="direccion">	<br/>
		<input type="submit" value="Registrar" name="registrar">
	</form>
	
</body>
</html>