package texto;

public class Servico extends ProdutoPai{
	
	public Servico(String nome, int codigo, Double preco, Empresa empresa) {
		super(nome, codigo, preco, empresa);
	}
	
	
	public void atualizar(String nome, int codigo, Double preco)
	{
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
	}
	
	

	
	public boolean equals(Servico servico)
	{
		if(servico != null)
		{
			if(servico.codigo == this.codigo && servico.empresa.equals(this.empresa))
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString()
    {
		return "Nome: " +nome + " | Preço: " +preco + "R$ " + " | Código: " +this.codigo; 
	}
	

}
