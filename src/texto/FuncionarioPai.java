package texto;

public abstract class FuncionarioPai {
	protected String login;
	protected char[] senha;
	protected String nome;
    protected int codigo;
    protected boolean logado;
    protected Empresa empresa;
	
	public FuncionarioPai(String login, char[] senha, String nome, Empresa empresa) {
		this.login = login;
		this.senha = senha;
		
		this.nome = nome;
		logado = false;
		this.empresa = empresa;
		
		
	}
	
	
	

	public FuncionarioPai() {
		super();
	}



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public char[] getSenha() {
		return senha;
	}

	public void setSenha(char[] senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}




	public boolean isLogado() {
		return logado;
	}




	public void setLogado(boolean logado) {
		this.logado = logado;
	}




	public Empresa getEmpresa() {
		return empresa;
	}




	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	

}
