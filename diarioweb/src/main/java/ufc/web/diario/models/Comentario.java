package ufc.web.diario.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "COMENTARIO")
@Table(name = "COMENTARIO")
public class Comentario {
	
	@Id
	@Column(name = ("COMENTARIO_ID"), nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long comentId;

	@Column(name = ("NOTICIA_ID"), nullable = false, insertable=false, updatable=false)
	private Long noticiaId;

	@Column(name = ("TEXTO"), nullable = false)
	private String texto;

	// Várias Comentarios podem ter o mesmo noticia
	@ManyToOne(optional = false) //false
	@JoinColumn(name = "noticia_id", referencedColumnName = "noticia_id")
	private Noticia noticiaDeOrigem;

	public Long getComentId() {
		return comentId;
	}

	public void setComentId(Long comentId) {
		this.comentId = comentId;
	}

	public Long getNoticiaId() {
		return noticiaId;
	}

	public void setNoticiaId(Long noticiaId) {
		this.noticiaId = noticiaId;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Noticia getNoticiaDeOrigem() {
		return noticiaDeOrigem;
	}

	public void setNoticiaDeOrigem(Noticia noticiaDeOrigem) {
		this.noticiaDeOrigem = noticiaDeOrigem;
	}

	

}
