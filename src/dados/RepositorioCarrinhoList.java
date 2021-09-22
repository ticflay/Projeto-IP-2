package dados;

import java.util.ArrayList;

import exceptions.JaExisteException;
import exceptions.NaoExisteException;
import texto.Empresa;
import texto.Historico;
import texto.Produto;
import texto.Servico;

public class RepositorioCarrinhoList implements IRepositorioCarrinhoList {
	private static RepositorioCarrinhoList instance;
	
	private ArrayList<Produto> produtosCarrinho;
	private ArrayList<Servico> servicosCarrinho;
	

	
	private RepositorioCarrinhoList()
	{
		this.produtosCarrinho = new ArrayList<>();
		this.servicosCarrinho = new ArrayList<>();
		
	}
	
	public static RepositorioCarrinhoList getInstance()
	{
		if(instance == null)
		{
			instance = new RepositorioCarrinhoList();
		}
		return instance;
	}
	
	public boolean vender(Produto produto) throws NaoExisteException
	{
	
		if(!this.produtosCarrinho.isEmpty())
		{
			return this.removerCarrinho(produto);
		}
		return false;
	}
	
	public boolean vender(Servico servico) throws NaoExisteException
	{
		if(!this.servicosCarrinho.isEmpty())
		{
			return this.removerCarrinho(servico);
		}
		return false;
	}
	
	public Double getPrecoTotal()
	{
		return getPrecoProdutos() + getPrecoServicos();
	}
	
	public Double getPrecoProdutos()
	{
		Double preco = 0.0;
		if(!this.produtosCarrinho.isEmpty())
		{
			for(int i = 0; i < this.produtosCarrinho.size(); i++)
			{
				preco = preco + (this.produtosCarrinho.get(i).getPreco() * this.produtosCarrinho.get(i).getQuantidade());
			}
		}
		return preco;
	}
	
	public Double getPrecoServicos()
	{
		Double preco = 0.0;
		if(!this.servicosCarrinho.isEmpty())
		{
			for(int i = 0; i < servicosCarrinho.size(); i++)
			{
				preco = preco + this.servicosCarrinho.get(i).getPreco();
			}
		}
		return preco;
	}
	
	
	public boolean cadastrarCarrinho(Produto produto) throws NaoExisteException, JaExisteException
	{
		if(!this.existeProduto(produto))
		{
			this.produtosCarrinho.add(produto);
			return true;
		}else
		{
			throw new JaExisteException("codigo", "produto", Integer.toString(produto.getCodigo()));
		}
		
	}
	
	public boolean cadastrarCarrinho(Servico servico) throws NaoExisteException, JaExisteException
	{
		
			this.servicosCarrinho.add(servico);
			return true;
		
	}
	
	public boolean removerCarrinho(Produto produto) throws NaoExisteException
	{
		if(this.existeProduto(produto))
		{
			int index = this.buscarProduto(produto);
			this.produtosCarrinho.remove(index);
			return true;
		}
		return false;
	}
	
	public boolean removerCarrinho(Servico servico) throws NaoExisteException
	{
		if(this.existeServico(servico))
		{
			int index = this.buscarServico(servico);
			this.servicosCarrinho.remove(index);
			return true;
		}
		return false;
	}
	
	public boolean atualizarCarrinho(Produto produto, int quantidade) throws NaoExisteException
	{
		if(this.existeProduto(produto))
		{
			int index = this.buscarProduto(produto);
			this.produtosCarrinho.get(index).setQuantidade(quantidade);
			return true;
		}
		return false;
	}
	
	 public boolean existeServico(Servico servico)
	    {
	    	if(servico != null)
	    	{
	    		if(this.buscarServico(servico) >= 0)
	    		{
	    			return true;
	    		}
	    	}
	    	return false;
	    }
	    
	    private int buscarServico(Servico servico)
	    {
	    	if(servico != null && this.servicosCarrinho != null && !this.servicosCarrinho.isEmpty())
	    	{
	    		for(Servico s : this.servicosCarrinho)
	    		{
	    			if(servico.equals(s))
	    			{
	    				return this.servicosCarrinho.indexOf(s);
	    			}
	    		}
	    	}
	    	return -1;
	    }
	    
	   
	    
	   
	    
	    private int buscarProduto(Produto produto)
	    {
	    	if(produto != null)
	    	{
	    		for(Produto p : this.produtosCarrinho)
	    		{
	    			if(p.equals(produto))
	    			{
	    				return this.produtosCarrinho.indexOf(p);
	    			}
	    		}
	    	}
	    	return -1;
	    }
	    
	    public boolean existeProduto(Produto produto)
	    {
	    	int buscar = this.buscarProduto(produto);
	    	if(buscar >= 0)
	    	{
	    		return true;
	    	}
	    	return false;
	    }
	 
		
		public void limpar()
		{
			this.produtosCarrinho.clear();
			this.servicosCarrinho.clear();
		}
		
		public int getTamanhoProduto()
		{
			if(!this.produtosCarrinho.isEmpty())
			{
				return this.produtosCarrinho.size();
			}
			return -1;
		}
		
		public int getTamanhoServico()
		{
			if(!this.servicosCarrinho.isEmpty())
			{
				return this.servicosCarrinho.size();
			}
			return -1;
		}
		
		public Produto getProduto(Produto produto)
		{
			
			if(produto != null)
			{
				for(Produto p : this.produtosCarrinho)
				{
					if(p.equals(produto))
					{
						return p;
					}
				}
			}
			return null;
		}
		
		public Servico getServico(Servico servico)
		{
			if(servico != null)
			{
				for(Servico s : this.servicosCarrinho)
				{
					if(s.equals(servico))
					{
						return s;
					}
				}
			}
			return null;
		}
		
		public Produto getProduto(int index)
		{
			return this.produtosCarrinho.get(index);
		}
		
		public Servico getServico(int index)
		{
			return this.servicosCarrinho.get(index);
		}
		
	

}
