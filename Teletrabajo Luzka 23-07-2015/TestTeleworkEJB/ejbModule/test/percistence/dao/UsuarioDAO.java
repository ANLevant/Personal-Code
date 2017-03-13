package test.percistence.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import test.persistence.entities.Usuarios;

@LocalBean
@Stateless
public class UsuarioDAO 
{
	@PersistenceContext(unitName = "TestTeleworkPU")
	EntityManager em;
	
	public List<Usuarios> findAllUsuarios()
	{
		String sentencia = "SELECT u FROM Usuarios u";
		List<Usuarios> usuariosEncontrados = new ArrayList<Usuarios>();
		
		Query query = em.createQuery(sentencia);
		usuariosEncontrados = query.getResultList();
		
		return usuariosEncontrados;
	}
	
	public void agregarUsuario(Usuarios usuario)
	{
		em.persist(usuario);
	}
}
