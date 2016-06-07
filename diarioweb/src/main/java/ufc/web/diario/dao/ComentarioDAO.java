package ufc.web.diario.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ufc.web.diario.models.Comentario;

@Repository
public class ComentarioDAO {
	
	@PersistenceContext
	private EntityManager manager;

	public void inserir(Comentario c){
		this.manager.persist(c);		
	}

	public void alterar(Comentario c){
		this.manager.merge(c);
	}

	public List<Comentario> listar(){

		String hql = "select c from COMENTARIO c";
		List<Comentario> comentarios = this.manager.createQuery(hql, Comentario.class).getResultList();

		return comentarios;
	}

	public void remover(Comentario c){
		Comentario comentario = this.manager.find(Comentario.class,c.getComentId() );
		this.manager.remove(comentario);
	}

	public Comentario getNoticia(Long id){
		return this.manager.find(Comentario.class, id);
	}

	public Comentario getCass(Long id_cass){		

		String hql = " SELECT c FROM COMENTARIO c WHERE c.comentId = :id_cass";  

		TypedQuery<Comentario> query = this.manager.createQuery(hql, Comentario.class);
		query.setParameter("id_cass", id_cass).getResultList();
		List<Comentario> classificados = query.getResultList();
		Comentario c = classificados.get(0);

		return c;
	}

	public List<Comentario> comentarios(long id_noticia){

		String hql = " SELECT c FROM COMENTARIO c WHERE c.noticiaId = :id_noticia";  

		TypedQuery<Comentario> query = this.manager.createQuery(hql, Comentario.class);
		query.setParameter("id_noticia", id_noticia).getResultList();
		List<Comentario> comentarios = query.getResultList();

		return comentarios;
	}
}
