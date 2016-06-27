package ufc.web.diario.models;

import javax.persistence.Embeddable;

public enum TipoUsuario {
	
	LEITOR("Leitor"), JORNALISTA("Jornalista"), EDITOR("Editor");
	
	private String nomeTipoUsuario;
	
	private TipoUsuario(String nomeTipoUsuario) {
		this.setNomeTipoUsuario(nomeTipoUsuario);
	}

	public String getNomeTipoUsuario() {
		return nomeTipoUsuario;
	}

	public void setNomeTipoUsuario(String nomeTipoUsuario) {
		this.nomeTipoUsuario = nomeTipoUsuario;
	}
}
