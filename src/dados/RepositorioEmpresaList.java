package dados;

import java.util.ArrayList;
import java.util.Arrays;

import exceptions.LoginInvalidoException;
import exceptions.NaoExisteException;
import exceptions.SenhasDiferentesException;
import texto.Dono;
import texto.Empresa;
import texto.Funcionario;

public class RepositorioEmpresaList implements IRepositorioEmpresaList{
	private static RepositorioEmpresaList instance;

	
	private ArrayList<Empresa> empresas; //LEMBRAR AMANHA, TENTAR FAZER COM DADOS
	
	
	private RepositorioEmpresaList()
	{
		this.empresas = new ArrayList<>();
		
	}
	
	public static RepositorioEmpresaList getInstance()
	{
		if(instance == null)
		{
			instance = new RepositorioEmpresaList();
		}
		return instance;
	}
	
	public boolean cadastrar(Empresa empresa)
	{
		if(!this.existe(empresa.getLogin()))
		{
			this.empresas.add(empresa);
			return true;
		}
		return false;
	}
	
	public boolean atualizar(Empresa empresa)
	{
		int index = this.buscar(empresa.getLogin());
		if(index >= 0)
		{
			this.empresas.set(index, empresa);
			return true;
		}
		return false;
	}
	
	public boolean remover(Empresa empresa)
	{
		int index = this.buscar(empresa.getLogin());
		if(index >= 0)
		{
			this.empresas.set(index, empresa);
			return true;
		}
		return false;
	}
	
	
	
	public boolean entrarEmpresa(Empresa empresa) throws SenhasDiferentesException, LoginInvalidoException
	{
		int index = this.buscar(empresa.getLogin());
		if(this.existeEmpresa(empresa.getLogin()) && index >= 0 && Arrays.equals(empresas.get(index).getSenha(), empresa.getSenha()))
		{
			this.empresas.get(index).setLogado(true);
			return true;
		}else if(!this.existeEmpresa(empresa.getLogin()))
		{
			throw new LoginInvalidoException();
		}else if(!Arrays.equals(empresas.get(index).getSenha(), empresa.getSenha()))
		{
			throw new SenhasDiferentesException();
		}
		return false;
	}
	
	
	

	private int buscar(String login)
	{
		if(login != null)
		{
			 for(int i = 0; i < empresas.size(); i++)
			 {
				 if(login.equals(empresas.get(i).getLogin()))
				 {
					 return i;
				 }
			 }
		}
		 return -1;
	}
	
	public boolean existe(String login)
	{
		if(login != null)
		{
			if(this.buscar(login) >= 0)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean sair(Empresa empresa)
	{
		if(empresa != null)
		{
			if(this.existeEmpresa(empresa.getLogin()))
			{
				int index = this.buscar(empresa.getLogin());
				if(this.empresas.get(index).isLogado())
				{
					this.empresas.get(index).setLogado(false);
					return true;
				}
			}
		}
		return false;
	}

	public boolean existeEmpresa(String login)
	{
		if(this.buscar(login) == -1)
		{
			return false;
		}
		return true;
	}
	
	public Empresa isLogado()
	{
		Empresa empresa = null;
		if(!this.empresas.isEmpty())
		{
			for(int i = 0; i < empresas.size(); i++)
			{
				if(this.empresas.get(i).isLogado())
				{
					empresa = this.empresas.get(i);
					return empresa;
				}
			}
		}
		return empresa;
	}
	
	public Empresa getUltimo()
	{
		Empresa empresa = null;
		if(!this.empresas.isEmpty())
		{
			empresa = this.empresas.get(this.empresas.size() - 1);
		}
		return empresa;
	}
	
	
}
