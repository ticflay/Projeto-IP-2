package texto;

public class Produto extends ProdutoPai{
	
	private int quantidade;

	public Produto()
	{
		
	}
	
	
	public Produto(String nome, int codigo, double preco, int quantidade, Empresa empresa) {
		super(nome, codigo, preco, empresa);
		this.codigo = codigo;
		this.quantidade = quantidade;
	
	}
	
	public void adicionar(String nome, int codigo, double preco, int quantidade)
	{
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public boolean equals(Produto produto)
	{
		if(produto != null)
		{
			if(produto.codigo == this.codigo && produto.empresa.equals(this.empresa))
			{
				return true;
			}
		}
		return false;
	}
	
	public void quantidadeRemovida(int quantidade)
	{
		this.quantidade = this.quantidade - quantidade;
	}
	
	@Override
	public String toString()
	{
		return "Nome: " +this.nome + " | Quantidade: " +this.quantidade + " | Código: " +this.codigo + " | Preço: " +this.preco;
	}

	
}
