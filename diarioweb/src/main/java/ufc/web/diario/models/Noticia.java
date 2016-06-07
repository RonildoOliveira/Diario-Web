package ufc.web.diario.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

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

	@Column (name = ("TEXTO"), nullable = false)
	private String texto;

	// Um noticia pode ter várias comentários..
	@OneToMany(mappedBy = "noticiaDeOrigem", targetEntity = Comentario.class, fetch = FetchType.LAZY)
	private List<Comentario> comentarios;

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

}
