package dados;

import java.util.ArrayList;

import texto.Empresa;
import texto.Historico;

public class RepositorioHistoricoList implements IRepositorioHistoricoList {
	private static RepositorioHistoricoList instance;
	
	private ArrayList<Historico> historicos;
	
	private RepositorioHistoricoList()
	{
		this.historicos = new ArrayList<>();
	}
	
	public static RepositorioHistoricoList getInstance()
	{
		if(instance == null)
		{
			instance = new RepositorioHistoricoList();
		}
		return instance;
	}
	
	public boolean adicionar(String historico, Empresa empresa)
	{
		if(historico != null && !this.historicos.isEmpty())
		{
			for(Historico h : this.historicos)
			{
				if(h.getEmpresa().equals(empresa))
				{
					 int index = this.historicos.indexOf(h);
					 this.historicos.get(index).adicionar(historico);
					 return true;
				}
			}
		}
		return false;
	}
	
	public boolean adicionar(Historico historico)
	{
		boolean existe = false;
		if(historico != null && !this.historicos.isEmpty())
		{
			for(Historico h : this.historicos)
			{
				if(h.getEmpresa().equals(historico.getEmpresa()))
				{
					existe = true;
					
				}
			}
			
			if(!existe)
			{
				this.historicos.add(historico);
				return true;
			}
		}else if(this.historicos.isEmpty())
		{
			this.historicos.add(historico);
			return true;
		}
		return !existe;
	}
	
	public Historico getHistorico(Empresa empresa)
	{
		Historico historico = null;
		if(empresa != null)
		{
			for(Historico h : this.historicos)
			{
				if(h.getEmpresa().equals(empresa))
				{
					historico = h;
					return historico;
				}
			}
		}
		return historico;
		
	}
	
	public int getTamanho()
	{
		if(!this.historicos.isEmpty())
		{
			return this.historicos.size();
		}
		return -1;
	}
	

	

}
