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
	
	public Long getRegraNome(String nome){
		
		String hql = " SELECT r FROM REGRA r WHERE r.nome = :nome"; // 
		
		TypedQuery<RegraUsuario> query = this.manager.createQuery(hql, RegraUsuario.class);
		query.setParameter("nome", nome).getResultList();
		List<RegraUsuario> regrasUsuario = query.getResultList();
		RegraUsuario regra = regrasUsuario.get(0);
		
		return regra.getRegraId();	
	
	}
	
	public List<RegraUsuario> usuarioRegras(Long id_usuario){ // Em hql utiliza-se da entidade ou seja da classe da aplicação e não da tabela do banco, Mas defini que usariam da tabela
		
		// Uma consulta usando JOIN FETCH nesse caso pega todos os papeis do usuário passado. 
		String hql = " SELECT r FROM REGRA r JOIN FETCH  r.usuarioList u WHERE u.id = :id_usuario"; // 
	
		TypedQuery<RegraUsuario> query = this.manager.createQuery(hql, RegraUsuario.class);
		query.setParameter("id_usuario", id_usuario).getResultList();
		List<RegraUsuario> regraUsuario = query.getResultList();
		
		return regraUsuario;
		
	}
}
