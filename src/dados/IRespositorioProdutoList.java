package dados;

import exceptions.JaExisteException;
import exceptions.NaoExisteException;
import texto.Empresa;
import texto.Produto;

public interface IRespositorioProdutoList {
	boolean cadastrar(Produto produto);
	boolean remover(Produto produto) throws NaoExisteException;
	boolean atualizar(Produto produtoAtual, Produto produtoAnterior) throws NaoExisteException;
	int buscar(Produto produto);
	Produto getProduto(Produto produto) throws NaoExisteException;
	int tamanho();
	Produto getProdutoEntrar(int index, Empresa empresa) throws NaoExisteException;


}
