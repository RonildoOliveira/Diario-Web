package ufc.web.diario.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ufc.web.diario.models.RegraUsuario;

@Repository
public class RegraDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void adicionar(RegraUsuario regra){
		this.manager.persist(regra);
	}
	
	public void atualizar(RegraUsuario regra){
		this.manager.merge(regra);
	}
	
	public List<RegraUsuario> listar(){
			
		String hql = "select r from REGRA r";
		List<RegraUsuario> regras = this.manager.createQuery(hql, RegraUsuario.class).getResultList();
		
		return regras;
	}
	
	public void remover(Long id){
		RegraUsuario regra  = this.manager.find(RegraUsuario.class, new Long(id)); 
		this.manager.remove(regra);
	}
	
	public RegraUsuario getRoleById(Long id){
		return this.manager.find(RegraUsuario.class, id); // Criar um novo id
	}
	
	public Long getRoleNome(String nome){
		
		String hql = " SELECT r FROM REGRA r WHERE r.regra = :nome"; // 
		
		TypedQuery<RegraUsuario> query = this.manager.createQuery(hql, RegraUsuario.class);
		query.setParameter("nome", nome).getResultList();
		List<RegraUsuario> regrasUsuario = query.getResultList();
		RegraUsuario regra = regrasUsuario.get(0);
		
		return regra.getRegraId();	
	
	}
}
