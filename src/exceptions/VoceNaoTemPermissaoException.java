package exceptions;

public class VoceNaoTemPermissaoException extends Exception{
	
	private String nome;
	
	public VoceNaoTemPermissaoException(String nome)
	{
		super("Você não tem permissão para " + nome);
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
