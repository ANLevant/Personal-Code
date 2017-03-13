package test.negocio.admin;

import test.persistence.entities.Usuarios;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminUsuariosLocal 
{
	/**Método que busca todos los usuarios existentes en la base de datos.*/
	public List<Usuarios> buscarUsuariosTodos();
	
	/**Método qeu agrega un usuario a la base de datos*/
	public void agregarUsuario(Usuarios usuario);
}
