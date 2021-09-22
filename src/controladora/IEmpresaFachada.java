package controladora;

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

public interface IEmpresaFachada {
	boolean cadastrarEmpresa(String login, char[] senha1, char[] senha2, String nome) throws SenhasDiferentesException, JaExisteException, LoginInvalidoException;
	boolean entrar(String login, char[] senha, Empresa empresa) throws LoginInvalidoException, SenhasDiferentesException, NaoExisteException, StringVaziaException;
	boolean entrarEmpresa(String login, char[] senha) throws SenhasDiferentesException, JaExisteException, NaoExisteException, LoginInvalidoException;
	boolean cadastrarDono(String nome, String login, char[] senha1, char[] senha2, Empresa empresa) throws JaExisteException, StringVaziaException, SenhasDiferentesException;
	boolean cadastrarFuncionario(String login, char[] senha, String nome, boolean vendeProdutos, boolean vendeServicos, boolean gerenciaProdutos,boolean gerenciaFuncionarios, int codigo, Empresa empresa) throws LoginInvalidoException, StringVaziaException, CodigoPequenoException, JaExisteException;
	boolean removerFuncionario(Funcionario funcionario) throws NaoExisteException, LoginInvalidoException;
	boolean atualizarFuncionario(Funcionario funcionarioAntigo, String login, char[] senha, String nome, boolean vendeProdutos, boolean vendeServicos, boolean gerenciaProdutos,
			boolean gerenciaFuncionarios, int codigo ) throws NaoExisteException, LoginInvalidoException, StringVaziaException, CodigoPequenoException;
	boolean cadastrarProduto(String nome, int codigo, double preco, int quantidade, Empresa empresa) throws NaoExisteException, StringVaziaException, CodigoPequenoException ;
	boolean removerProduto(Produto produto) throws NaoExisteException;
	boolean atualizarProduto(String nome, int codigo, double preco, int quantidade, Empresa empresa, Produto produtoAnterior) throws StringVaziaException, CodigoPequenoException, NaoExisteException;
	boolean adicionarServico(String nome, int codigo, Double preco, Empresa empresa) throws StringVaziaException, CodigoPequenoException, JaExisteException;
	boolean removerServico(Servico servico) throws NaoExisteException;
	boolean atualizarServico(String nome, int codigo, Double preco, Servico servico) throws NaoExisteException, StringVaziaException, CodigoPequenoException, JaExisteException;
	Funcionario getLogadoFuncionario();
	Dono getLogadoDono();
	Empresa getEmpresaLogada();
	boolean cadastrarCarrinho(Produto produto) throws NaoExisteException, JaExisteException;
	boolean cadastrarCarrinho(Servico servico) throws NaoExisteException, JaExisteException;
	boolean removerCarrinho(Produto produto) throws NaoExisteException;
	boolean removerCarrinho(Servico servico) throws NaoExisteException;
	boolean atualizarCarrinho(Produto produto, int quantidade) throws NaoExisteException;
	boolean vender(Produto produto) throws NaoExisteException;
	boolean vender(Servico servico) throws NaoExisteException;
	Empresa getUltimo();
	boolean existeServicoCarrinho(Servico servico);
	boolean existeProdutoCarrinho(Produto produto);
	Double getPrecoServico();
	Double getPrecoProduto();
	Double getPrecoTotal();
	int buscarProduto(Produto produto) throws NaoExisteException;
    Produto getProduto(Produto produto) throws NaoExisteException;
    boolean sairEmpresa(Empresa empresa);
    boolean sairFuncionario(Funcionario funcionario);
    boolean sairDono(Dono dono);
    int getTamanhoProduto();
    Produto getProdutoEntrar(int index, Empresa empresa) throws NaoExisteException;
    Funcionario getFuncionarioEntrar(int index, Empresa empresa);
    Servico getServicoEntrar(int index, Empresa empresa);
    void limparCarrinho();
    int getTamanhoServico();
    int getTamanhoFuncionario();
    Dono getDonoEntrar(int index, Empresa empresa);
    int getTamanhoDono();
    boolean adicionar(Historico historico);
    boolean adicionar(String texto, Empresa empresa);
    Historico getHistorico(Empresa empresa);
    int getTamanhoHistorico();
    int getTamanhoProdutoCarrinho();
    int getTamanhoServicoCarrinho();
    Servico getServicoCarrinho(Servico servico);
    Produto getProdutoCarrinho(Produto produto);
    Servico getServicoCarrinho(int index);
    Produto getProdutoCarrinho(int index);

}

