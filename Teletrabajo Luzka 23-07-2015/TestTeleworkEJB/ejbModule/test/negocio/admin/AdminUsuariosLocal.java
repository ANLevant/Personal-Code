package test.negocio.admin;

import test.persistence.entities.Usuarios;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminUsuariosLocal 
{
	/**M�todo que busca todos los usuarios existentes en la base de datos.*/
	public List<Usuarios> buscarUsuariosTodos();
	
	/**M�todo qeu agrega un usuario a la base de datos*/
	public void agregarUsuario(Usuarios usuario);
}
