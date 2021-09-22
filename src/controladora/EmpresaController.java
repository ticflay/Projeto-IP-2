package controladora;
import dados.IRepositorioEmpresaList;

import java.util.ArrayList;
import java.util.Arrays;

import exceptions.JaExisteException;
import exceptions.LoginInvalidoException;
import exceptions.NaoExisteException;
import exceptions.SenhasDiferentesException;

import texto.Dono;
import texto.Empresa;
import texto.Funcionario;

public class EmpresaController {
	
	private IRepositorioEmpresaList repositorio;
	
	public EmpresaController(IRepositorioEmpresaList instanciaRepositorio)
	{
		this.repositorio = instanciaRepositorio;
	}
	
	public boolean cadastrarEmpresa(String login, char[] senha1, char[] senha2, String nome) throws SenhasDiferentesException, JaExisteException, LoginInvalidoException
	{
		if(!this.existeEmpresa(login) && Arrays.equals(senha1, senha2))
		{
			Empresa empresa = new Empresa(login, senha1, nome);
			return repositorio.cadastrar(empresa);
		}else if(this.existeEmpresa(login))
		{
			throw new LoginInvalidoException();
		}else if(!Arrays.equals(senha1, senha2))
		{
			throw new SenhasDiferentesException();
		}
		return false;
	}
	
	private boolean existeEmpresa(String login)
	{
		return this.repositorio.existeEmpresa(login);
	}
	
	

	
	public boolean entrarEmpresa(String login, char[] senha) throws SenhasDiferentesException, JaExisteException, NaoExisteException, LoginInvalidoException
	{
		Empresa empresa = new Empresa();
		empresa.setLogin(login);
		empresa.setSenha(senha);
		return repositorio.entrarEmpresa(empresa);
	}
	
	public Empresa isLogado()
	{
		return this.repositorio.isLogado();
	}

	public Empresa getUltimo()
	{
		return this.repositorio.getUltimo();
	}
	
	public boolean sair(Empresa empresa)
	{
		return this.repositorio.sair(empresa);
	}



	
}
