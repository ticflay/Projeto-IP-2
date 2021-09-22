package controladora;

import dados.RepositorioCarrinhoList;
import dados.RepositorioEmpresaList;
import dados.RepositorioFuncionarioList;
import dados.RepositorioHistoricoList;
import dados.RepositorioProdutoList;
import dados.RepositorioServicoList;
import exceptions.CodigoPequenoException;
import exceptions.JaExisteException;
import exceptions.LoginInvalidoException;
import exceptions.NaoExisteException;
import exceptions.SenhasDiferentesException;
import exceptions.StringVaziaException;
import texto.Dono;
import texto.Empresa;
import texto.Funcionario;
import texto.Historico;
import texto.Produto;
import texto.Servico;

public class EmpresaFachada implements IEmpresaFachada{
	
	private FuncionarioController funcionarios;
	private ProdutoController produtos;
	private ServicoController servicos;
	private EmpresaController empresas;
	private CarrinhoController carrinho;
	private HistoricoController historico;
	
	private static IEmpresaFachada instance;
	
	private EmpresaFachada()
	{
		this.funcionarios = new FuncionarioController(RepositorioFuncionarioList.getInstance());
		this.produtos = new ProdutoController(RepositorioProdutoList.getInstance());
		this.servicos = new ServicoController(RepositorioServicoList.getInstance());
		this.empresas = new EmpresaController(RepositorioEmpresaList.getInstance());
		this.carrinho = new CarrinhoController(RepositorioCarrinhoList.getInstance());
		this.historico = new HistoricoController(RepositorioHistoricoList.getInstance());
	}
	
	public static IEmpresaFachada getInstance()
	{
		if(instance == null)
		{
			instance = new EmpresaFachada();
		}
		return instance;
	}
	
	public boolean cadastrarEmpresa(String login, char[] senha1, char[] senha2, String nome) throws SenhasDiferentesException, JaExisteException, LoginInvalidoException
	{
		return this.empresas.cadastrarEmpresa(login, senha1, senha2, nome);
	}
	

	public boolean entrar(String login, char[] senha, Empresa empresa) throws LoginInvalidoException, SenhasDiferentesException, NaoExisteException, StringVaziaException
	{
		return this.funcionarios.entrar(login, senha, empresa);
	}
	
	public boolean entrarEmpresa(String login, char[] senha) throws SenhasDiferentesException, JaExisteException, NaoExisteException, LoginInvalidoException
	{
		return this.empresas.entrarEmpresa(login, senha);
	}
	
	public boolean cadastrarDono(String nome, String login, char[] senha1, char[] senha2, Empresa empresa) throws JaExisteException, StringVaziaException, SenhasDiferentesException
	{
		return this.funcionarios.cadastrarDono(nome, login, senha1, senha2, empresa);
	}
	
	public boolean cadastrarFuncionario(String login, char[] senha, String nome, boolean vendeProdutos, boolean vendeServicos, boolean gerenciaProdutos,
			boolean gerenciaFuncionarios, int codigo, Empresa empresa) throws LoginInvalidoException, StringVaziaException, CodigoPequenoException, JaExisteException
	{
		return this.funcionarios.adicionarFuncionario(login, senha, nome, vendeProdutos, vendeServicos, gerenciaProdutos, gerenciaFuncionarios, codigo, empresa);
	}
	
	
	public boolean removerFuncionario(Funcionario funcionario) throws NaoExisteException, LoginInvalidoException
	{
		return this.funcionarios.removerFuncionario(funcionario);
	}
	
	public boolean atualizarFuncionario(Funcionario funcionarioAntigo, String login, char[] senha, String nome, boolean vendeProdutos, boolean vendeServicos, boolean gerenciaProdutos,
			boolean gerenciaFuncionarios, int codigo ) throws NaoExisteException, LoginInvalidoException, StringVaziaException, CodigoPequenoException
	{
		return this.funcionarios.atualizarFuncionario(funcionarioAntigo, login, senha, nome, vendeProdutos, vendeServicos, gerenciaProdutos, gerenciaFuncionarios, codigo);
	}
	
	public boolean cadastrarProduto(String nome, int codigo, double preco, int quantidade, Empresa empresa) throws NaoExisteException, StringVaziaException, CodigoPequenoException 
	{
		return this.produtos.cadastrarProduto(nome, codigo, preco, quantidade, empresa);
	}
	
	public boolean removerProduto(Produto produto) throws NaoExisteException
	{
		return this.produtos.removerProduto(produto);
	}
	
	public boolean atualizarProduto(String nome, int codigo, double preco, int quantidade, Empresa empresa, Produto produtoAnterior) throws StringVaziaException, CodigoPequenoException, NaoExisteException
	{
		return this.produtos.atualizarProduto(nome, codigo, preco, quantidade, empresa, produtoAnterior);
	}
	
	public boolean adicionarServico(String nome, int codigo, Double preco, Empresa empresa) throws StringVaziaException, CodigoPequenoException, JaExisteException
	{
		return this.servicos.adicionarServico(nome, codigo, preco, empresa);
	}
	
	public boolean removerServico(Servico servico) throws NaoExisteException
	{
		return this.servicos.removerServico(servico);
	}
	
	public boolean atualizarServico(String nome, int codigo, Double preco, Servico servico) throws NaoExisteException, StringVaziaException, CodigoPequenoException, JaExisteException
	{
		return this.servicos.atualizarServico(nome, codigo, preco, servico);
	}
	
	public Funcionario getLogadoFuncionario()
	{
		return this.funcionarios.isLogadoFuncionario();
	}
	
	public Dono getLogadoDono()
	{
		return this.funcionarios.isLogadoDono();
	}
	
	public Empresa getEmpresaLogada()
	{
		return this.empresas.isLogado();
	}
	
	public boolean cadastrarCarrinho(Produto produto) throws NaoExisteException, JaExisteException
	{
		return this.carrinho.cadastrar(produto);
	}
	
	public boolean cadastrarCarrinho(Servico servico) throws NaoExisteException, JaExisteException
	{
		return this.carrinho.cadastrar(servico);
	}
	
	public boolean removerCarrinho(Produto produto) throws NaoExisteException
	{
		return this.carrinho.remover(produto);
	}
	
	public boolean removerCarrinho(Servico servico) throws NaoExisteException
	{
		return this.carrinho.remover(servico);
	}
	
	public boolean atualizarCarrinho(Produto produto, int quantidade) throws NaoExisteException
	{
		return this.carrinho.atualizar(produto, quantidade);
	}
	
	public boolean vender(Produto produto) throws NaoExisteException
	{
		return this.carrinho.vender(produto);
	}
	
	public boolean vender(Servico servico) throws NaoExisteException
	{
		return this.carrinho.vender(servico);
	}
	
	public Empresa getUltimo()
	{
		return this.empresas.getUltimo();
	}
	
	public boolean existeServicoCarrinho(Servico servico)
	{
		return this.carrinho.existeServico(servico);
	}
	public boolean existeProdutoCarrinho(Produto produto)
	{
		return this.carrinho.existeProduto(produto);
	}
	
	public Double getPrecoServico()
	{
		return this.carrinho.getPrecoServico();
	}
	
	public Double getPrecoProduto()
	{
		return this.carrinho.getPrecoProduto();
	}
	
	public Double getPrecoTotal()
	{
		return this.carrinho.getPrecoTotal();
	}
	
	public int buscarProduto(Produto produto) throws NaoExisteException
	{
		return this.produtos.buscar(produto);
	}
	
	 public Produto getProduto(Produto produto) throws NaoExisteException
	 {
		 return this.produtos.getProduto(produto);
	 }
	 
	 public boolean sairEmpresa(Empresa empresa)
	 {
		 return this.empresas.sair(empresa);
	 }
	 
	 public boolean sairFuncionario(Funcionario funcionario)
	 {
		 return this.funcionarios.sair(funcionario);
	 }
	 
	 public boolean sairDono(Dono dono)
	 {
		 return this.funcionarios.sair(dono);
	 }
	 
	 public int getTamanhoProduto()
	 {
		 return this.produtos.tamanho();
	 }
	 
	 public Produto getProdutoEntrar(int index, Empresa empresa) throws NaoExisteException
	 {
		 return this.produtos.getProdutoEntrar(index, empresa);
	 }
	 
	 public Funcionario getFuncionarioEntrar(int index, Empresa empresa)
	 {
		 return this.funcionarios.getFuncionarioEntrar(index, empresa);
	 }
	 
	 public Servico getServicoEntrar(int index, Empresa empresa)
	 {
		 return this.servicos.getServicoEntrar(index, empresa);
	 }
	 
	 public void limparCarrinho()
	 {
		 this.carrinho.limpar();
	 }
	 
	 public int getTamanhoServico()
	 {
		 return this.servicos.getTamanho();
	 }
	 
	 public int getTamanhoFuncionario()
	 {
		return this.funcionarios.getTamanhoFuncionarios();
	 }
	 
	 public int getTamanhoDono()
	 {
		 return this.funcionarios.getTamanhoDono();
	 }
	 
	 public Dono getDonoEntrar(int index, Empresa empresa)
	 {
		 return this.funcionarios.getDonoEntrar(index, empresa);
	 }
	 
	 public boolean adicionar(Historico historico)
	 {
		 return this.historico.adicionar(historico);
	 }
	 
	 public boolean adicionar(String texto, Empresa empresa)
	 {
		 return this.historico.adicionar(texto, empresa);
	 }
	 
	 public Historico getHistorico(Empresa empresa)
	 {
		 return this.historico.getHistorico(empresa);
	 }
	 
	 public int getTamanhoHistorico()
	 {
		 return this.historico.getTamanho();
	 }
	 
	 public int getTamanhoProdutoCarrinho()
	 {
		 return this.carrinho.getTamanhoProduto();
	 }
	 
	 public int getTamanhoServicoCarrinho()
	 {
		 return this.carrinho.getTamanhoServico();
	 }
	 
	 public Produto getProdutoCarrinho(Produto produto)
	 {
		 return this.carrinho.getProduto(produto);
	 }
	 
	 public Servico getServicoCarrinho(Servico servico)
	 {
		 return this.carrinho.getServico(servico);
	 }

	 public Produto getProdutoCarrinho(int index)
	 {
		 return this.carrinho.getProduto(index);
	 }
	 
	 public Servico getServicoCarrinho(int index)
	 {
		 return this.carrinho.getServico(index);
	 }
	 



}
