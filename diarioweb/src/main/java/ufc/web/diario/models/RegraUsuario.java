package ufc.web.diario.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "REGRA")
@Table(name = "REGRA")
public class RegraUsuario {

	@Id
	@Column(name = ("REGRA_ID"), nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long regraId;
		
	@Column(name = ("REGRA_NOME"), nullable = false)
	private String regra;

	public Long getRegraId() {
		return regraId;
	}

	public void setRegraId(Long regraId) {
		this.regraId = regraId;
	}

	public String getRegra() {
		return regra;
	}

	public void setRegra(String regra) {
		this.regra = regra;
	}
	
	
}
