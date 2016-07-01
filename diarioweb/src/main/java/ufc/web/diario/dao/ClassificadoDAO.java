package ufc.web.diario.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ufc.web.diario.models.Classificado;

@Repository
public class ClassificadoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Classificado c){
		this.manager.persist(c);
	}
	
	public void alterar(Classificado c){
		this.manager.merge(c);
	}
	
	public List<Classificado> listar(){
		
		String hql = "select c from CLASSIFICADO c";
		List<Classificado> classificados = this.manager.createQuery(hql, Classificado.class).getResultList();
		
		return classificados;
	}
	
	public void remover(Classificado c){
		Classificado d = this.manager.find(Classificado.class, c.getClassificadoId());
		this.manager.remove(d);
	}
	
	public Classificado getCass(Long id_cass){		
	    
        String hql = " SELECT c FROM CLASSIFICADO c WHERE c.classificadoId = :id_cass";  
		
		TypedQuery<Classificado> query = this.manager.createQuery(hql, Classificado.class);
		query.setParameter("id_cass", id_cass).getResultList();
		List<Classificado> classificados = query.getResultList();
		Classificado c = classificados.get(0);
		
		return c;
	}

	
}
