package ufc.web.diario.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ufc.web.diario.models.Noticia;

@Repository
public class NoticiaDAO {
    
    @PersistenceContext
	private EntityManager manager;
	
	public void inserir(Noticia n){		
		
		this.manager.persist(n);
		
	}
	
	public void alterar(Noticia n){		
		this.manager.merge(n);
		
	}

	public List<Noticia> listar(){
		
		String hql = "select n from NOTICIA n order by n.dataNoticia desc";
		List<Noticia> noticias = this.manager.createQuery(hql, Noticia.class).getResultList();
		
		return noticias;
	}
	
	public List<Noticia> listarNoticiasRecentes(){
		
		String hql = "select n from NOTICIA n order by n.dataNoticia desc";
		List<Noticia> noticias = this.manager.createQuery(hql, Noticia.class).setFirstResult(0).setMaxResults(5).getResultList();
		
		return noticias;
	}

	public void remover(Noticia n){
		Noticia not = this.manager.find(Noticia.class, n.getNoticiaId());
		this.manager.remove(not);
	}
	
	public Noticia getNoticia(Long id){
		return this.manager.find(Noticia.class, id);
	}
	
}
