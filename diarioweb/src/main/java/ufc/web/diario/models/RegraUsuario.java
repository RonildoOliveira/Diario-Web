package ufc.web.diario.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "REGRA")
@Table(name = "REGRA")
public class RegraUsuario {

	@Id
	@Column(name = ("REGRA_ID"), nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long regraId;
		
	@Column(name = ("REGRA_NOME"), nullable = false)
	private String nome;

	//colocar cascade
	@ManyToMany(mappedBy = "regras" , fetch = FetchType.LAZY)
	private List<Usuario> usuarioList; 
	
	
	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

	public Long getRegraId() {
		return regraId;
	}

	public void setRegraId(Long regraId) {
		this.regraId = regraId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
