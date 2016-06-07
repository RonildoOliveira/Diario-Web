package ufc.web.diario.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ufc.web.diario.models.Noticia;

@Repository
public class NoticiaDAO {

	@PersistenceContext
	private EntityManager manager;

	public void save(Noticia noticia){
		manager.persist(noticia);
	}

	public List<Noticia> listar() {
		return manager.createQuery("select n from Noticia as n",
				Noticia.class).getResultList();
	}
}
