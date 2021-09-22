package dados;
import java.util.ArrayList;

import exceptions.JaExisteException;
import exceptions.NaoExisteException;
import texto.Empresa;
import texto.Funcionario;
import texto.Servico;
public class RepositorioServicoList implements IRespositorioServicoList {

	private static RepositorioServicoList instance;
	
	ArrayList<Servico> servicos;
	
	private RepositorioServicoList()
	{
		this.servicos = new ArrayList<>();
	}
	
	public static RepositorioServicoList getInstance()
	{
		if(instance == null)
		{
			instance = new RepositorioServicoList();
		}
		return instance;
	}
	
    public boolean adicionar(String nome, int codigo, Double preco, Empresa empresa) throws JaExisteException
    {
    	Servico servico = new Servico(nome, codigo, preco, empresa);
    	if(empresa != null)
    	{
    		if(!this.existe(servico))
    		{
    			this.servicos.add(servico);
    			return true;
    		}else
    		{
    			throw new JaExisteException("codigo", "serviço", Integer.toString(codigo));
    		}
    	}
    	return false;
    }
    
    public boolean remover(Servico servico) throws NaoExisteException
    {
    	if(servico != null)
    	{
    		if(this.existe(servico))
    		{
    			int index = this.buscar(servico);
    			this.servicos.remove(index);
    		}else
    		{
    			throw new NaoExisteException("código", "serviço", Integer.toString(servico.getCodigo()));
    		}
    	}
    	return false;
    }
    
    public boolean atualizar(Servico servicoAtual, Servico servicoAnterior) throws JaExisteException, NaoExisteException
    {
    	if(servicoAtual != null && servicoAnterior != null)
    	{
    		if(this.existe(servicoAnterior))
    		{
    			int index = this.buscar(servicoAnterior);
    			if(servicoAtual.getCodigo() == servicoAnterior.getCodigo() || !this.existe(servicoAtual)) 
    			{
    				this.servicos.set(index, servicoAtual);
    				return true;
    			}else
    			{
    				throw new JaExisteException("código", "serviço", Integer.toString(servicoAtual.getCodigo()));
    			}
    			
    		}else
    		{
    			throw new NaoExisteException("código", "serviço", Integer.toString(servicoAnterior.getCodigo()));
    		}
    	}
    	return false;
    }
    
  
    
    private boolean existe(Servico servico)
    {
    	int buscar = this.buscar(servico);
    	if(buscar >= 0)
    	{
    		return true;
    	}
    	return false;
    }
    
    private int buscar(Servico servico)
    {
    	if(servico != null)
    	{
    		for(Servico s : servicos)
    		{
    			if(s.equals(servico))
    			{
    				return this.servicos.indexOf(s);
    			}
    		}
    	}
    	return -1;
    }
    
    public Servico getServicoEntrar(int index, Empresa empresa)
	{
		Servico servico = null;
		if(!this.servicos.isEmpty())
		{
			if(this.servicos.get(index).getEmpresa().equals(empresa))
			{
				servico = this.servicos.get(index);
				return servico;
			}
			
					
		}
		return servico;
	}
    
    public int getTamanho()
    {
    	if(!this.servicos.isEmpty())
    	{
    		return this.servicos.size();
    	}
    	return -1;
    }
	
}
