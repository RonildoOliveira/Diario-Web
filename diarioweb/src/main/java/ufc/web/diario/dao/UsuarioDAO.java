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

	public void adicionar(Usuario usuario) {
		this.manager.persist(usuario);
	}

	public void remover(Usuario usuario) {
		Usuario u = this.manager.find(Usuario.class, usuario.getId());
		this.manager.remove(u);
	}

	public List<Usuario> listar() {

		String hql = "select u from USUARIO u ";
		List<Usuario> usuarios = manager.createQuery(hql,Usuario.class).getResultList();
		return usuarios;
	}

	public void alterar(Usuario usuario) {
		this.manager.merge(usuario);

	}

	public Usuario getUserId(Long id){
		return this.manager.find(Usuario.class, id);
	}
	
	public Usuario getUserLogin(String login){
		String sql = "select u from USUARIO u where u.login = :login";
		TypedQuery<Usuario> query = this.manager.createQuery(sql,Usuario.class);
		query.setParameter("login", login).getResultList();
		List<Usuario> user = query.getResultList();
		if(user.size() == 0){
			return null;
		}else{
			return user.get(0); 
		}
	}

}
