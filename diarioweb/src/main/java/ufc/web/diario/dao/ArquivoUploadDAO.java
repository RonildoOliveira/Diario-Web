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

import ufc.web.diario.models.ArquivoUpload;

@Repository
public class ArquivoUploadDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ArquivoUploadDAO() {

	}
	
	public ArquivoUploadDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(ArquivoUpload arquivoUpload) {
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
	public List<ArquivoUpload> list() {
		Session session = sessionFactory.getCurrentSession();
		List<ArquivoUpload> documents = null;
		try {
			documents = (List<ArquivoUpload>)session.createQuery("from ArquivoUpload").list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return documents;
	}
	
	@Transactional
	public ArquivoUpload get(Long arquivoId) {
		Session session = sessionFactory.getCurrentSession();
		return (ArquivoUpload)session.get(ArquivoUpload.class, arquivoId);
	}
}
