package ufc.web.diario.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "USUARIO")
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@Column(name = ("USUARIO_ID"), nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = ("LOGIN"), nullable = false, length = 50)
	private String login;

	//
	@Column(name = ("SENHA"), nullable = false, length = 100)
	private String senha;

	@Column(name = ("NOME"), nullable = false, length = 50)
	private String nome;

	@Column(name = ("EMAIL"), nullable = false)
	private String email;
	
	private Long regraId;
	
	/******************/
	@Column(name = "IMAGEM_PROFILE")
	private String nomeArquivo;
	
	@Lob
	@Column(name = "DADO_IMAGEM")	
	private byte[] conteudoArquivo;
	
	@Column(name="TIPO_ARQUIVO")
	private String tipoArquivo;

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

	/******************/
	// Regras Usuário
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "USUARIO_REGRA", 
	joinColumns = @JoinColumn(name = "usuario_id" ,referencedColumnName = "usuario_id" ), 
	inverseJoinColumns = @JoinColumn(name = "regra_id", referencedColumnName = "regra_id" ) )
	private List<RegraUsuario> regras;
	
	// Comentários
	// Um usuário pode adicionar várias comentários..
	@OneToMany(mappedBy = "autorComentario", targetEntity = Comentario.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Comentario> comentarios;
	
	// Classificados
	// Usuário pode ter vários pedido em um classificado
	@OneToMany(mappedBy = "autorOferta", targetEntity = Classificado.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Classificado> classificados;
	
	// Notícias
	// Um usuário pode adicionar várias noticias..
	@OneToMany(mappedBy = "autorNoticia", targetEntity = Noticia.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Noticia> noticias;

	public List<RegraUsuario> getRegras() {
		return regras;
	}

	public void setRegras(List<RegraUsuario> regras) {
		this.regras = regras;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getRegraId() {
		return regraId;
	}

	public void setRegraId(Long regraId) {
		this.regraId = regraId;
	}

}