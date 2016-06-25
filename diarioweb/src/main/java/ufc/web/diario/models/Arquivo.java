package ufc.web.diario.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "ARQUIVO")
public class Arquivo {
	
	@Id
	@GeneratedValue
	@Column(name = "ID_ARQUIVO")
	private Long idArquivo;
	
	@Column(name = "NOME_ARQUIVO")
	private String nomeArquivo;
	
	@Lob
	@Column(name = "DADO_ARQUIVO")	
	private byte[] conteudoArquivo;
	
	@Column(name="TIPO_ARQUIVO")
	private String tipoArquivo;

	public Long getIdArquivo() {
		return idArquivo;
	}

	public void setIdArquivo(Long idArquivo) {
		this.idArquivo = idArquivo;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public byte[] getConteudoArquivo() {
		return conteudoArquivo;
	}

	public void setConteudoArquivo(byte[] conteudoArquivo) {
		this.conteudoArquivo = conteudoArquivo;
	}

	public String getTipoArquivo() {
		return tipoArquivo;
	}

	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

}
