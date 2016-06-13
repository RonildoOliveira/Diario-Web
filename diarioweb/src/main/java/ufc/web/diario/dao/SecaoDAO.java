package ufc.web.diario.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ufc.web.diario.models.Secao;

@Repository
public class SecaoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Secao s){
		this.manager.persist(s);	
	}
	
	public void alterar(Secao s){
		this.manager.merge(s);
	}
	
	public List<Secao> listar() {
		String hql = "select s from SECAO s";
		return manager.createQuery(hql, Secao.class).getResultList();
	}

	
	public void remover (Secao s){
		Secao sc = this.manager.find(Secao.class, s.getSecaoId());
		this.manager.remove(sc);
	}
	
	public Secao getSecao(Long id){
		return this.manager.find(Secao.class, id);
	}
	
}
