<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="usuarios" class="test.mb.UsuariosMB" scope="request" />
	
	<%
		usuarios.getUsuarioARegistrar().setUsuNomUsu((String)request.getParameter("nombre"));
		usuarios.getUsuarioARegistrar().setUsuApeUsu((String)request.getParameter("apellido"));
		usuarios.getUsuarioARegistrar().setUsuCedUsu((String)request.getParameter("cedula"));
		usuarios.getUsuarioARegistrar().setUsuCorUsu((String)request.getParameter("correo"));
		usuarios.getUsuarioARegistrar().setUsuTelUsu((String)request.getParameter("telefono"));
		usuarios.getUsuarioARegistrar().setUsuDirUsu((String)request.getParameter("direccion"));
		
		usuarios.crearUsuario();
 	%>
	Registor exitoso
</body>
</html>