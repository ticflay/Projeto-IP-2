package controladora;

import dados.IRepositorioHistoricoList;
import texto.Empresa;
import texto.Historico;

public class HistoricoController {
	
	private IRepositorioHistoricoList repositorio;
	
	public HistoricoController(IRepositorioHistoricoList instanciaRepositorio)
	{
		this.repositorio = instanciaRepositorio;
	}
	
	public boolean adicionar(String texto, Empresa empresa)
	{
		return this.repositorio.adicionar(texto, empresa);
	}
	
	public boolean adicionar(Historico historico)
	{
		return this.repositorio.adicionar(historico);
	}
	
	public Historico getHistorico(Empresa empresa)
	{
		return this.repositorio.getHistorico(empresa);
	}
	
	public int getTamanho()
	{
		return this.repositorio.getTamanho();
	}
	

}
