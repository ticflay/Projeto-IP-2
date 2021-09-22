package dados;

import exceptions.JaExisteException;
import exceptions.NaoExisteException;
import texto.Empresa;
import texto.Historico;
import texto.Produto;
import texto.Servico;

public interface IRepositorioCarrinhoList {
	boolean cadastrarCarrinho(Produto produto) throws NaoExisteException, JaExisteException;
	boolean cadastrarCarrinho(Servico servico) throws NaoExisteException, JaExisteException;
	boolean removerCarrinho(Produto produto) throws NaoExisteException;
	boolean removerCarrinho(Servico servico) throws NaoExisteException;
	boolean atualizarCarrinho(Produto produto, int quantidade) throws NaoExisteException; 
	boolean vender(Produto produto) throws NaoExisteException;
	boolean vender(Servico servico) throws NaoExisteException;
	boolean existeServico(Servico servico);
	boolean existeProduto(Produto produto);
	Double getPrecoTotal();
	Double getPrecoProdutos();
	Double getPrecoServicos();
	void limpar();
	int getTamanhoProduto();
	int getTamanhoServico();
	Produto getProduto(Produto produto);
	Servico getServico(Servico servico);
	Produto getProduto(int index);
	Servico getServico(int index);







}
