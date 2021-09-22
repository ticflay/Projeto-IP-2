package texto;

public class Funcionario extends FuncionarioPai{
	
	private boolean vendeProdutos;
	private boolean vendeServicos;
	private boolean gerenciaProdutosServicos;
	private boolean gerenciaFuncionarios;


	
	
	
	public Funcionario() {
		super();
	}



	public Funcionario(String login, char[] senha, String nome, boolean vendeProdutos, boolean vendeServicos, boolean gerenciaProdutos,
			boolean gerenciaFuncionarios, int codigo, Empresa empresa) {
		super(login, senha, nome, empresa);
		
		this.vendeProdutos = vendeProdutos;
		this.vendeServicos = vendeServicos;
		this.gerenciaProdutosServicos = gerenciaProdutos;
		this.gerenciaFuncionarios = gerenciaFuncionarios;
		this.codigo = codigo;
	
		
	}
	
	
	
	public void add(Funcionario funcionario)
	{
		this.login = funcionario.login;
		this.senha = funcionario.senha;
		this.nome = funcionario.nome;
		this.vendeProdutos = funcionario.vendeProdutos;
		this.gerenciaProdutosServicos = funcionario.gerenciaProdutosServicos;
		this.gerenciaFuncionarios = funcionario.gerenciaFuncionarios;
		this.codigo = funcionario.codigo;
		
	}
	
	public boolean isVendeProduto() {
		return vendeProdutos;
	}
	public void setVendeProduto(boolean vendeProdutos) {
		this.vendeProdutos = vendeProdutos;
	}
	public boolean isVendeServico() {
		return vendeServicos;
	}
	public void setVendeServico(boolean vendeServiços) {
		this.vendeServicos = vendeServiços;
	}
	public boolean isGerenciaProdutosServicos() {
		return gerenciaProdutosServicos;
	}
	public void setGerenciaProdutosServicos(boolean GerenciaProdutos) {
		this.gerenciaProdutosServicos = GerenciaProdutos;
	}
	public boolean isGerenciaFuncionarios() {
		return gerenciaFuncionarios;
	}
	public void setGerenciaFuncionarios(boolean GerenciaFuncionarios) {
		this.gerenciaFuncionarios = GerenciaFuncionarios;
	}
	
	@Override
	public String toString()
	{
		String vendeP, vendeS, GerenP, GerencF;
		if(vendeServicos == false)
		{
			vendeS = "Não";
		}else
		{
			vendeS = "Sim";
		}
		if(gerenciaProdutosServicos == false)
		{
			GerenP = "Não";
		}else
		{
			GerenP = "Sim";
		}
		
		if(gerenciaFuncionarios == false)
		{
			GerencF = "Não";
		}else
		{
			GerencF = "Sim";
		}
		if(vendeProdutos == false)
		{
			vendeP = "Não";
		}else
		{
			vendeP = "Sim";
		}
		return "Nome: " +nome+ " | Código: " +codigo;
	}
	public boolean equals(Funcionario funcionario)
	{
		if(funcionario != null)
		{
			if(funcionario.getLogin().equals(this.login) && funcionario.getEmpresa().equals(this.empresa))
			{
				return true;
			}
		}
		return false;
	}



	
	
	

}
