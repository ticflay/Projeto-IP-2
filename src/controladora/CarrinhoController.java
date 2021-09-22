package controladora;

import dados.IRepositorioCarrinhoList;
import exceptions.JaExisteException;
import exceptions.NaoExisteException;
import texto.Empresa;
import texto.Historico;
import texto.Produto;
import texto.Servico;

public class CarrinhoController {
	
	private IRepositorioCarrinhoList repositorio;
	
	public CarrinhoController(IRepositorioCarrinhoList instanciaRepositorio)
	{
		this.repositorio = instanciaRepositorio;
	}
	
	public boolean cadastrar(Produto produto) throws NaoExisteException, JaExisteException
	{
		if(produto != null)
		{
			return this.repositorio.cadastrarCarrinho(produto);
		}
		return false;
	}
	
	public boolean cadastrar(Servico servico) throws NaoExisteException, JaExisteException
	{
		if(servico != null)
		{
			return this.repositorio.cadastrarCarrinho(servico);
		}
		return false;
	}
	
	public boolean remover(Produto produto) throws NaoExisteException
	{
		if(produto != null)
		{
			this.repositorio.removerCarrinho(produto);
		}
		return false;
	}
	
	public boolean remover(Servico servico) throws NaoExisteException
	{
		if(servico != null)
		{
			this.repositorio.removerCarrinho(servico);
		}
		return false;
	}
	
	public boolean atualizar(Produto produto, int quantidade) throws NaoExisteException
	{
		if(produto != null)
		{
			return this.repositorio.atualizarCarrinho(produto, quantidade);
		}
		return false;
	}
	
	public boolean vender(Produto produto) throws NaoExisteException
	{
		if(produto != null)
		{
			return this.repositorio.vender(produto);
		}
		return false;
	}
	
	public boolean vender(Servico servico) throws NaoExisteException
	{
		if(servico != null)
		{
			return this.repositorio.vender(servico);
		}
		return false;
	}
	
	public boolean existeServico(Servico servico)
	{
		return this.repositorio.existeServico(servico);
	}
	public boolean existeProduto(Produto produto)
	{
		return this.repositorio.existeProduto(produto);
	}
	
	public Double getPrecoProduto()
	{
		return this.repositorio.getPrecoProdutos();
	}
	
	public Double getPrecoServico()
	{
		return this.repositorio.getPrecoServicos();
	}
	
	public Double getPrecoTotal()
	{
		return this.repositorio.getPrecoTotal();
	}
	
	public void limpar()
	{
		this.repositorio.limpar();
	}
	
	public int getTamanhoProduto()
	{
		return this.repositorio.getTamanhoProduto();
	}
	public int getTamanhoServico()
	{
		return this.repositorio.getTamanhoServico();
	}
	
	public Produto getProduto(Produto produto)
	{
		return this.repositorio.getProduto(produto);
	}
	
	public Servico getServico(Servico servico)
	{
		return this.repositorio.getServico(servico);
	}
	
	public Produto getProduto(int index)
	{
		return this.repositorio.getProduto(index);
	}
	
	public Servico getServico(int index)
	{
		return this.repositorio.getServico(index);
	}
	



}
