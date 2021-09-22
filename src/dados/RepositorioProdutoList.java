package dados;
import java.util.ArrayList;

import exceptions.JaExisteException;
import exceptions.NaoExisteException;
import texto.Empresa;
import texto.Produto;

public class RepositorioProdutoList implements IRespositorioProdutoList{

	private static RepositorioProdutoList instance;

	ArrayList<Produto> produtos;

	private RepositorioProdutoList()
	{
		this.produtos = new ArrayList<>();
	}

	public static RepositorioProdutoList getInstance()
	{
		if(instance == null)
		{
			instance = new RepositorioProdutoList();
		}
		return instance;
	}

	public boolean cadastrar(Produto produto)
	{
		if(produto != null)
		{
			if(!this.existe(produto))
			{
				this.produtos.add(produto);
				return true;
			}
		}
		return false;
	}

	public boolean remover(Produto produto) throws NaoExisteException
	{
		if(produto != null)
		{
			if(this.existe(produto))
			{
				int index = this.buscar(produto);
				this.produtos.remove(index);
			}else
			{
				throw new NaoExisteException("codigo", "produto", Integer.toString(produto.getCodigo()));
			}
		}
		return false;
	}

	public boolean atualizar(Produto produtoAtual, Produto produtoAnterior) throws NaoExisteException
	{
		if(produtoAtual != null && produtoAnterior != null)
		{
			if(this.existe(produtoAnterior))
			{
				int index = this.buscar(produtoAnterior);
				if(produtoAtual.getCodigo() == produtoAnterior.getCodigo() || !this.existe(produtoAtual))
				{
					this.produtos.set(index, produtoAtual);
					return true;
				}
			}else
			{
				throw new NaoExisteException("codigo", "produto", Integer.toString(produtoAnterior.getCodigo()));
			}
		}
		return false;
	}


	
	private boolean existe(Produto produto)
	{
		int buscar = this.buscar(produto);
		boolean retorno = false;
		
		if(buscar >= 0)
		{
			
			retorno = true;
			return retorno;
		}
	
		return retorno;
	}

	public int buscar(Produto produto)
	{
		int a = -1;
		if(this.produtos != null && !this.produtos.isEmpty())
		{
			for(Produto p : produtos)
			{
				if(p.equals(produto))
				{
					a = this.produtos.indexOf(p);
					return a;
				}
			}
		}
	
		return a;
	}

	public Produto getProduto(Produto produto) throws NaoExisteException
	{
		int buscar = this.buscar(produto);
		if(buscar >= 0)
		{
			return this.produtos.get(buscar);
		}else
		{
			throw new NaoExisteException("produto", "codigo", Integer.toString(produto.getCodigo()));
		}
	}
	

	public int tamanho()
	{
		if(!this.produtos.isEmpty())
		{
			return this.produtos.size();
		}
		return -1;
	}
	
	public Produto getProdutoEntrar(int index, Empresa empresa) throws NaoExisteException
	{
		Produto produto = null;
		if(!this.produtos.isEmpty())
		{
			
			if(this.produtos.get(index).getEmpresa().equals(empresa))
			{
				produto = this.produtos.get(index);
				return produto;
			
			}else
			{
				throw new NaoExisteException("produto", "posição", Integer.toString(index));
			}
			
		}
		return produto;
		
	}
	
	



}
