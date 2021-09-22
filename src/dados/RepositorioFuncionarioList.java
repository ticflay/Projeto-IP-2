package dados;

import java.util.ArrayList;
import java.util.Arrays;

import exceptions.JaExisteException;
import exceptions.LoginInvalidoException;
import exceptions.NaoExisteException;
import exceptions.SenhasDiferentesException;
import texto.Dono;
import texto.Empresa;
import texto.Funcionario;
import texto.FuncionarioPai;

public class RepositorioFuncionarioList implements IRepositorioFuncionarioList{
	private static RepositorioFuncionarioList instance;
	
	ArrayList<Funcionario> funcionarios;
	ArrayList<Dono> donos;
	
	private RepositorioFuncionarioList()
	{
		this.funcionarios = new ArrayList<>();
		this.donos = new ArrayList<>();
	}
	
	public static RepositorioFuncionarioList getInstance()
	{
		if(instance == null)
		{
			instance = new RepositorioFuncionarioList();
		}
		return instance;
	}
	
	private int buscarFuncionario(Funcionario funcionario)
	{
		if(funcionario != null && this.funcionarios != null && !this.funcionarios.isEmpty())
		{
			for(Funcionario f : this.funcionarios)
			{
				if(f.equals(funcionario))
				{
					return this.funcionarios.indexOf(f);
				}
			}
		}
		return -1;
	}
	
	private int buscarDono(Dono dono)
	{
		if(dono != null && this.donos != null && !this.donos.isEmpty())
		{
			for(Dono d : this.donos)
			{
				if(d.equals(dono))
				{
					return this.donos.indexOf(d);
				}
			}
		}
		return -1;
	}
	
	private boolean existeDono(Dono dono)
	{
		if(dono != null)
		{
			if(this.buscarDono(dono) >= 0)
			{
				return true;
			}
		}
		return false;
			
	}
	
	private boolean existeFuncionario(Funcionario funcionario)
	{
		if(funcionario != null)
		{
			if(this.buscarFuncionario(funcionario) >= 0)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean adicionar(Funcionario funcionario) throws LoginInvalidoException, JaExisteException
	{
		
		if(!this.existeFuncionario(funcionario))
		{
			this.funcionarios.add(funcionario);
			return true;
		}else
		{
			throw new JaExisteException("funcionário", "login", funcionario.getLogin());
		}
	}
	
	public boolean remover(Funcionario funcionario) throws NaoExisteException, LoginInvalidoException
	{
		
		if(this.existeFuncionario(funcionario))
		{
			int index = this.buscarFuncionario(funcionario);
			this.funcionarios.remove(index);
			return true;
			
		}else
		{
			throw new NaoExisteException("funcionário", "login", funcionario.getLogin());
		}
		
	}
	
	public boolean atualizar(Funcionario funcionarioAntigo, Funcionario funcionarioNovo) throws NaoExisteException, LoginInvalidoException
	{
		if(this.existeFuncionario(funcionarioAntigo))
		{
			if(funcionarioAntigo.getLogin().equals(funcionarioNovo.getLogin()) || !this.existeFuncionario(funcionarioNovo))
			{
				int index = this.buscarFuncionario(funcionarioAntigo);
				this.funcionarios.set(index, funcionarioNovo);
				return true;
			}
		}
		return false;
	}
	
	public boolean entrar(String login, char[] senha, Empresa empresa) throws LoginInvalidoException, SenhasDiferentesException
	{
		Dono dono = new Dono();
		dono.setLogin(login);
		dono.setSenha(senha);
		dono.setEmpresa(empresa);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setLogin(login);
		funcionario.setSenha(senha);
		funcionario.setEmpresa(empresa);
		if(empresa.isLogado())
		{
			if(this.existeDono(dono))
			{
				int index = this.buscarDono(dono);
				if(Arrays.equals(senha, this.donos.get(index).getSenha()))
				{
					this.donos.get(index).setLogado(true);
					return true;
				}else
				{
					throw new SenhasDiferentesException();
				}
			}else if(this.existeFuncionario(funcionario))
			{
				int index = this.buscarFuncionario(funcionario);
				if(Arrays.equals(senha, this.funcionarios.get(index).getSenha()))
				{
					this.funcionarios.get(index).setLogado(true);
					return true;
				}else
				{
					throw new SenhasDiferentesException();
				}
			}else
			{
				throw new LoginInvalidoException();
			}
			
		}
		return false;
		
			
		
	}
	
	public boolean cadastrarDono(Dono dono)
	{
		if(!this.existeDono(dono))
		{
			this.donos.add(dono);
			return true;
		}
		return false;

	}
	
	
	
	public Dono isLogadoDono()
	{
		Dono dono = null;
		for(int i = 0; i < donos.size(); i++)
		{
			if(this.donos.get(i).isLogado())
			{
				dono = donos.get(i);
				return dono;
			}
		}
		return dono;
	}

	@Override
	public Funcionario isLogadoFuncionario() {
		
			Funcionario funcionario = null;
				for(int i = 0; i < this.funcionarios.size(); i++)
				{
					if(this.funcionarios.get(i).isLogado())
					{
						funcionario = funcionarios.get(i);
						return funcionario;
					}
				}
				
			
			return funcionario;
		
	}
	
	public boolean sair(Dono dono)
	{
		if(dono != null)
		{
			if(this.existeDono(dono))
			{
				int index = this.buscarDono(dono);
				if(this.donos.get(index).isLogado())
				{
					this.donos.get(index).setLogado(false);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean sair(Funcionario funcionario)
	{
		if(funcionario != null)
		{
			if(this.existeFuncionario(funcionario))
			{
				int index = this.buscarFuncionario(funcionario);
				if(this.funcionarios.get(index).isLogado())
				{
					funcionarios.get(index).setLogado(false);
					return true;
				}
			}
		}
		return false;
	}
	
	public Funcionario getFuncionarioEntrar(int index, Empresa empresa)
	{
		Funcionario funcionario = null;
		if(!this.funcionarios.isEmpty())
		{
			if(this.funcionarios.get(index).getEmpresa().equals(empresa))
			{
				funcionario = this.funcionarios.get(index);
				return funcionario;
			}
			
					
		}
		return funcionario;
	}
	

	
	public Dono getDonoEntrar(int index, Empresa empresa)
	{
		Dono dono = null;
		if(!this.donos.isEmpty())
		{
			if(this.donos.get(index).getEmpresa().equals(empresa))
			{
				dono = this.donos.get(index);
				return dono;
			}
		}
		return dono;
	}
	
	 public int getTamanhoFuncionario()
	 {
		 if(!this.funcionarios.isEmpty())
		 {
			 return this.funcionarios.size();
		 }
		 return -1;
	 }
	 
	 public int getTamanhoDono()
	 {
		 if(!this.donos.isEmpty())
		 {
			 return this.donos.size();
		 }
		 return -1;
	 }
	 


}
