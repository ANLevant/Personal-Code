package test.negocio.admin;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import test.persistence.entities.Usuarios;
import test.percistence.dao.UsuarioDAO;

@Stateless
public class AdminUsuarios  implements AdminUsuariosLocal
{

	@EJB
	UsuarioDAO usuarioDao;
	
	@Override
	public List<Usuarios> buscarUsuariosTodos()
	{
		return usuarioDao.findAllUsuarios();
	}
	
	@Override
	public void agregarUsuario(Usuarios usuario)
	{
		usuarioDao.agregarUsuario(usuario);
	}

}
