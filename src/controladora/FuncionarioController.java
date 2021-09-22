package controladora;

import java.util.Arrays;

import dados.IRepositorioFuncionarioList;
import exceptions.JaExisteException;
import exceptions.LoginInvalidoException;
import exceptions.NaoExisteException;
import exceptions.SenhasDiferentesException;
import exceptions.StringVaziaException;
import exceptions.CodigoPequenoException;
import texto.Dono;
import texto.Empresa;
import texto.Funcionario;

public class FuncionarioController {
	
	private IRepositorioFuncionarioList repositorio;
	
	public FuncionarioController(IRepositorioFuncionarioList instanciaRepositorio)
	{
		this.repositorio = instanciaRepositorio;
	}
	
	public boolean adicionarFuncionario(String login, char[] senha, String nome, boolean vendeProdutos, boolean vendeServicos, boolean gerenciaProdutos,
			boolean gerenciaFuncionarios, int codigo, Empresa empresa) throws LoginInvalidoException, StringVaziaException, CodigoPequenoException, JaExisteException
	{
		if(login.length() > 0 && senha.length > 0 && nome.length() > 0 && codigo > 9)
		{
			Funcionario funcionario = new Funcionario(login, senha, nome, vendeProdutos, vendeServicos, gerenciaProdutos, gerenciaFuncionarios, codigo, empresa);
		    return this.repositorio.adicionar(funcionario);
		}else if(login.length() <= 0)
		{
			throw new StringVaziaException("login");
		}else if(senha.length <= 0)
		{
			throw new StringVaziaException("senha");
		}else if(nome.length() <= 0)
		{
			throw new StringVaziaException("nome");
		}else if(codigo <= 9)
		{
			throw new CodigoPequenoException();
		}
		return false;
	}
	
	public boolean removerFuncionario(Funcionario funcionario) throws NaoExisteException, LoginInvalidoException
	{
		if(funcionario != null)
		{

			return this.repositorio.remover(funcionario);
			
		}
		

		return false;
	}
	
	public boolean atualizarFuncionario(Funcionario funcionarioAntigo, String login, char[] senha, String nome, boolean vendeProdutos, boolean vendeServicos, boolean gerenciaProdutos,
			boolean gerenciaFuncionarios, int codigo) throws NaoExisteException, LoginInvalidoException, StringVaziaException, CodigoPequenoException
	{
		if(funcionarioAntigo != null && nome != null && nome.length() > 0 && login != null && login.length() > 0 && codigo > 9 && senha != null && senha.length > 0)
		{
			Funcionario funcionarioNovo = new Funcionario(login, senha, nome, vendeProdutos, vendeServicos, gerenciaProdutos, gerenciaFuncionarios, codigo, funcionarioAntigo.getEmpresa());
			return this.repositorio.atualizar(funcionarioAntigo, funcionarioNovo);
		}else if(nome == null || nome.length() <= 0)
		{
			throw new StringVaziaException("nome");
		}else if(login == null || login.length() <= 0)
		{
			throw new StringVaziaException("login");
		}else if(senha == null || senha.length <= 0)
		{
			throw new StringVaziaException("senha");
		}else if(codigo <= 9)
		{
			throw new CodigoPequenoException(); 
		}
		
		return false;
	}
	
	public boolean entrar(String login, char[] senha, Empresa empresa) throws LoginInvalidoException, SenhasDiferentesException, StringVaziaException
	{
		if(login!= null && login.length() > 0 && senha != null && senha.length > 0 && empresa != null)
		{
			return this.repositorio.entrar(login, senha, empresa);
		}else if(login == null || senha.length <= 0)
		{
			throw new StringVaziaException("login");
		}else if( senha == null || senha.length <= 0)
		{
			throw new StringVaziaException("senha");
		}
		return false;
	}
	
	public Funcionario isLogadoFuncionario()
	{
		return this.repositorio.isLogadoFuncionario();
	}
	
	public Dono isLogadoDono()
	{
		return this.repositorio.isLogadoDono();
	}
	
	public boolean cadastrarDono(String nome, String login, char[] senha1, char[] senha2, Empresa empresa) throws StringVaziaException, SenhasDiferentesException
	{
		if(nome != null && nome.length() > 0 && login != null && login.length() > 0 && senha1 != null && senha1.length > 0 && senha2 != null && senha2.length > 0 && empresa != null && Arrays.equals(senha1, senha2))
		{
			Dono dono = new Dono(login, senha1, nome, empresa);
			return this.repositorio.cadastrarDono(dono);
		}else if(nome == null || nome.length() <= 0)
		{
			throw new StringVaziaException("nome");
		}else if(login == null || login.length() <= 0)
		{
			throw new StringVaziaException("login");
		}else if(senha1 == null || senha1.length <= 0)
		{
			throw new StringVaziaException("senha");
			
		}else if(senha2 == null || senha2.length <= 0)
		{
			throw new StringVaziaException("'Repita sua senha'");
		}else if(!Arrays.equals(senha1, senha2))
		{
			throw new SenhasDiferentesException();
		}
		return false;
	}
	
	public boolean sair(Dono dono)
	{
		return this.repositorio.sair(dono);
	}
	
	public boolean sair(Funcionario funcionario)
	{
		return this.repositorio.sair(funcionario);
	}
	
	public Funcionario getFuncionarioEntrar(int index, Empresa empresa)
	{
		return this.repositorio.getFuncionarioEntrar(index, empresa);
	}
	
	public Dono getDonoEntrar(int index, Empresa empresa)
	{
		return this.repositorio.getDonoEntrar(index, empresa);
	}
	
	public int getTamanhoFuncionarios()
	{
		return this.repositorio.getTamanhoFuncionario();
	}
	
	public int getTamanhoDono()
	{
		return this.repositorio.getTamanhoDono();
	}

	

}
	

