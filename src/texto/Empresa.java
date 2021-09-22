package texto;

import java.util.ArrayList;

import dados.RepositorioFuncionarioList;


public class Empresa {
	private String login;
	private char[] senha;
	private String nome;
	private boolean logado;
	public Empresa(String login, char[] senha, String nome) {
		super();
		this.login = login;
		this.senha = senha;
		this.nome = nome;
	
		this.logado = false;
	}
	
	
	public Empresa() {
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
	
	@Override
	public String toString()
	{
		return "Nome: " +nome;
	}
	
	public boolean equals(Empresa empresa)
	{
		if(empresa != null)
		{
			if(empresa.getLogin().equals(this.login))
			{
				return true;
			}
		}
		return false;
	}


	

	public boolean isLogado() {
		return logado;
	}


	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	
	
	
	

}
