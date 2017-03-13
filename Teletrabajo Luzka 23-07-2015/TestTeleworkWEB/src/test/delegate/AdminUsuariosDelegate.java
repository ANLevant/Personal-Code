package test.delegate;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import test.persistence.entities.Usuarios;
import test.negocio.admin.AdminUsuariosLocal;

public class AdminUsuariosDelegate
{
	private AdminUsuariosLocal adminUsuarios;
	
	public AdminUsuariosDelegate()
	{
		try
		{
			Context ct = new InitialContext();
			
			adminUsuarios = (AdminUsuariosLocal) ct.lookup("java:global/TestTeleworkEAR/TestTeleworkEJB/AdminUsuarios!test.negocio.admin.AdminUsuariosLocal");
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
		}
	}
	
	public List<Usuarios> buscarUsuariosTodos()
	{
		return adminUsuarios.buscarUsuariosTodos();
	}
	
	public void agregarUsuario(Usuarios usuario)
	{
		adminUsuarios.agregarUsuario(usuario);
	}

}
