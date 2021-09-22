package exceptions;

public class StringVaziaException extends Exception{
	private String nome;
	
	public StringVaziaException(String nome)
	{
		super("Informe o " + nome + "!");
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
