package controladora;


import dados.IRespositorioProdutoList;
import exceptions.CodigoPequenoException;
import exceptions.JaExisteException;
import exceptions.NaoExisteException;
import exceptions.StringVaziaException;
import texto.Empresa;
import texto.Produto;

public class ProdutoController{
	
	private IRespositorioProdutoList repositorio;
	
	public ProdutoController(IRespositorioProdutoList instanciaProduto)
	{
		this.repositorio = instanciaProduto;
	}
	
	public boolean cadastrarProduto(String nome, int codigo, double preco, int quantidade, Empresa empresa) throws StringVaziaException, CodigoPequenoException 
	{
		if(nome != null && nome.length() > 0 && codigo > 9)
		{
			Produto produto = new Produto(nome, codigo, preco, quantidade, empresa);
			return this.repositorio.cadastrar(produto);
			
		}else if(nome == null || nome.length() <= 0)
		{
			throw new StringVaziaException("nome");
			
		}else if(codigo <= 9)
		{
			throw new CodigoPequenoException();
		}
		return false;
		
	}
	
	public boolean removerProduto(Produto produto) throws NaoExisteException
	{
		if(produto != null)
		{
			return this.repositorio.remover(produto);
		}
		return false;
	}
	
	public boolean atualizarProduto(String nome, int codigo, double preco, int quantidade, Empresa empresa, Produto produtoAnterior) throws StringVaziaException, CodigoPequenoException, NaoExisteException
	{
		if(nome != null && nome.length() > 0 && codigo > 9)
		{
			Produto produtoAtual = new Produto(nome, codigo, preco, quantidade, empresa);
			return this.repositorio.atualizar(produtoAtual, produtoAnterior);
			
		}else if(nome == null || nome.length() <= 0)
		{
			throw new StringVaziaException(nome);
		}else if(codigo <= 9)
		{
			throw new CodigoPequenoException();
		}
		return false;
	}
	
	public int buscar(Produto produto) throws NaoExisteException
	{
		return this.repositorio.buscar(produto);
	}
	
	 public Produto getProduto(Produto produto) throws NaoExisteException
	 {
		 return this.repositorio.getProduto(produto);
	 }

	 public int tamanho()
	 {
		 return this.repositorio.tamanho();
	 }
	 
	 public Produto getProdutoEntrar(int index, Empresa empresa) throws NaoExisteException
	 {
		return this.repositorio.getProdutoEntrar(index, empresa);
	 }

}
