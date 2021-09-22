package controladora;

import dados.IRespositorioServicoList;
import exceptions.CodigoPequenoException;
import exceptions.JaExisteException;
import exceptions.NaoExisteException;
import exceptions.StringVaziaException;
import texto.Empresa;
import texto.Servico;

public class ServicoController {
	
	private IRespositorioServicoList repositorio;
	
	public ServicoController(IRespositorioServicoList instanciaRepositorio)
	{
		this.repositorio = instanciaRepositorio;
	}
	
	
	public boolean adicionarServico(String nome, int codigo, Double preco, Empresa empresa) throws StringVaziaException, CodigoPequenoException, JaExisteException
	{
		if(nome != null && nome.length() > 0 && codigo > 9)
		{
			return this.repositorio.adicionar(nome, codigo, preco, empresa);
		}else if(nome == null || nome.length() <= 0)
		{
			throw new StringVaziaException("nome");
		}else if(codigo <= 9)
		{
			throw new CodigoPequenoException();
		}
		return false;
	}
	
	public boolean removerServico(Servico servico) throws NaoExisteException
	{
		
			if(servico != null)
			{
				return this.repositorio.remover(servico);
			}
		return false;
	}
	
	public boolean atualizarServico(String nome, int codigo, Double preco, Servico servico) throws NaoExisteException, StringVaziaException, CodigoPequenoException, JaExisteException
	{
		if(servico != null && nome != null && nome.length() > 0 && codigo > 9)
		{
			Servico servicoNovo = new Servico(nome, codigo, preco, servico.getEmpresa());
			return this.repositorio.atualizar(servicoNovo, servico);
		}else if(nome == null || nome.length() <= 0)
		{
			throw new StringVaziaException("nome");
		}else if(codigo <= 9)
		{
			throw new CodigoPequenoException();
		}
		return false;
	}
	
	public Servico getServicoEntrar(int index, Empresa empresa)
	{
		return this.repositorio.getServicoEntrar(index, empresa);
	}
	
	public int getTamanho()
	{
		return this.repositorio.getTamanho();
	}

}
