package test.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import test.delegate.AdminUsuariosDelegate;
import test.persistence.entities.Usuarios;

@ManagedBean(name = "usuariosMb")
@RequestScoped
public class UsuariosMB
{
	private List<Usuarios> usuariosEncontrados;
	private AdminUsuariosDelegate adminUsuarios;
	private Usuarios usuarioARegistrar;
	
	public UsuariosMB()
	{
		adminUsuarios = new AdminUsuariosDelegate();
		usuarioARegistrar = new Usuarios();
		
		usuariosEncontrados = adminUsuarios.buscarUsuariosTodos();
	}
	
	public void crearUsuario()
	{
		adminUsuarios.agregarUsuario(usuarioARegistrar);
	}

	public List<Usuarios> getUsuariosEncontrados()
	{
		return usuariosEncontrados;
	}

	public void setUsuariosEncontrados(List<Usuarios> usuariosEncontrados)
	{
		this.usuariosEncontrados = usuariosEncontrados;
	}

	/**
	 * @return the usuarioARegistrar
	 */
	public Usuarios getUsuarioARegistrar() {
		return usuarioARegistrar;
	}

	/**
	 * @param usuarioARegistrar the usuarioARegistrar to set
	 */
	public void setUsuarioARegistrar(Usuarios usuarioARegistrar) {
		this.usuarioARegistrar = usuarioARegistrar;
	}
	
	
	
}
