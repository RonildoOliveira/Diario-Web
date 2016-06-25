package ufc.web.diario.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ufc.web.diario.models.Usuario;

@Repository
public class UsuarioDAO {
	@PersistenceContext
	private EntityManager manager;

		public void adicionar(Usuario user) {
			this.manager.persist(user);
	}

	public void remover(Usuario usuario) {
		Usuario u = this.manager.find(Usuario.class, usuario.getId());
		this.manager.remove(u);
	}

	public List<Usuario> listar() {
		
		String hql = "select u from USUARIO u ";
		List<Usuario> users = manager.createQuery(hql,Usuario.class).getResultList();
		return users;
	}

	public void alterar(Usuario user) {
		this.manager.merge(user);
		
	}
	
	public Usuario getUserId(Long id){
		return this.manager.find(Usuario.class, id);
	}
	
}
