package ufc.web.diario.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ufc.web.diario.models.Arquivo;

@Repository
public class ArquivoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ArquivoDAO() {

	}
	
	public ArquivoDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(Arquivo arquivoUpload) {
		sessionFactory.getCurrentSession().save(arquivoUpload);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Arquivo> list() {
		Session session = sessionFactory.getCurrentSession();
		List<Arquivo> documents = null;
		try {
			documents = (List<Arquivo>)session.createQuery("from Arquivo").list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return documents;
	}
	
	@Transactional
	public Arquivo get(Long arquivoId) {
		Session session = sessionFactory.getCurrentSession();
		return (Arquivo)session.get(Arquivo.class, arquivoId);
	}
}
