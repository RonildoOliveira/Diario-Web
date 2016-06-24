package ufc.web.diario.models;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "ARQUIVO")
public class ArquivoUpload {
	
	@Id
	@GeneratedValue
	@Column(name = "ID_ARQUIVO")
	private Long idArquivo;
	
	@Column(name = "NOME_ARQUIVO")
	private String nomeArquivo;
	
	@Column(name = "DADO_ARQUIVO")
	@Lob
	private byte[] dadoArquivo;
	
	@Column(name="CONTEUDO_ARQUIVO")
	private String conteudoArquivo;

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

	public byte[] getDadoArquivo() {
		return dadoArquivo;
	}

	public void setDadoArquivo(byte[] dadoArquivo) {
		this.dadoArquivo = dadoArquivo;
	}

	public String getConteudoArquivo() {
		return conteudoArquivo;
	}

	public void setConteudoArquivo(String conteudoArquivo) {
		this.conteudoArquivo = conteudoArquivo;
	}
}
