package texto;

public abstract class ProdutoPai {
	
	protected String nome;
	protected int codigo;
	protected double preco;
	protected Empresa empresa;
	
	public ProdutoPai()
	{
		
	}
	
	public ProdutoPai(String nome, int codigo, double preco, Empresa empresa) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
		this.empresa = empresa;
	}
	public String getNome() {
		return nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public double getPreco() {
		return preco;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	

}
