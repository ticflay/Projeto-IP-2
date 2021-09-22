package exceptions;

public class AbertoNoCarrinhoException extends Exception{
	private String nome;
	
	public AbertoNoCarrinhoException(String nome)
	{
		super("O " +nome+" já está aberto no carrinho!");
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
