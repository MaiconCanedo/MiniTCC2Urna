package br.gov.tse.urna.dto;

/**
 * @author Maicon Canedo
 */
public class UsuarioDTO {
    
	private Integer IdUsuario;
    private String nome, login, senha;
    private Boolean situacao, admin;
    
    public UsuarioDTO() {}
    
    public UsuarioDTO(Integer idUsuario, String nome, String login, String senha, Boolean situacao, Boolean admin) {
		super();
		IdUsuario = idUsuario;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.situacao = situacao;
		this.admin = admin;
	}

	public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

	@Override
	public String toString() {
		return "Usuario [IdUsuario=" + IdUsuario + ", nome=" + nome + ", situacao=" + situacao + ", admin=" + admin + "]";
	}
	
	@Override
	public boolean equals(Object objeto) {
		return this.IdUsuario == ((UsuarioDTO)objeto).IdUsuario;
	}
}