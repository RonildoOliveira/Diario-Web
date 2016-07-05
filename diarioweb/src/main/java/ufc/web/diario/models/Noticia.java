package ufc.web.diario.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Type;


@Entity(name = "NOTICIA")
@Table(name = "NOTICIA")
public class Noticia {

	@Id 
	@Column (name = ("NOTICIA_ID"), nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long noticiaId;

	@Column (name = ("TITULO"), nullable = false)
	private String titulo;

	@Column (name = ("SUBTITULO"), nullable = false)
	private String subtitulo;

	@Type(type="text")
	@Column (name = ("TEXTO"), nullable = false)
	private String texto;

	@Version
	@Column (name = ("DATA_NOTICIA"), nullable = false, columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNoticia;
	
	/** Uma Notícia  tem Vários Comentários **/
	@OneToMany(mappedBy = "noticiaDeOrigem", targetEntity = Comentario.class, cascade=CascadeType.REMOVE)
	private List<Comentario> comentarios;
	
	@Column (name = "SECAO_ID", nullable = false, insertable=false, updatable=false)
	private Long secaoId;

	// Muitas notícias podem estar para uma única seção
	@ManyToOne(optional = false)
	@JoinColumn(name = "secao_id", referencedColumnName = "secao_id") // ID_SECAO referencia ID
	private Secao secao;
	
	// Várias Notícias podem ter o mesmo autor
	@ManyToOne(optional = false)
	@JoinColumn(name = "autor_id", referencedColumnName = "usuario_id")
	private Usuario autorNoticia;
    
	/******************/
	@Column(name = "NOME_ARQUIVO")
	private String nomeArquivo;
	
	@Lob
	@Column(name = "DADO_ARQUIVO")	
	private byte[] conteudoArquivo;
	
	@Column(name="TIPO_ARQUIVO")
	private String tipoArquivo;

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public Usuario getAutorNoticia() {
		return autorNoticia;
	}

	public void setAutorNoticia(Usuario autorNoticia) {
		this.autorNoticia = autorNoticia;
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


	/******************/
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Long getSecaoId() {
		return secaoId;
	}

	public void setSecaoId(Long secaoId) {
		this.secaoId = secaoId;
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

	public Long getNoticiaId() {
		return noticiaId;
	}

	public void setNoticiaId(Long noticiaId) {
		this.noticiaId = noticiaId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDataNoticia() {
		return dataNoticia;
	}

	public void setDataNoticia(Date dataNoticia) {
		this.dataNoticia = dataNoticia;
	}

}
