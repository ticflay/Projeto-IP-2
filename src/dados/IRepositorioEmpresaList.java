package dados;

import exceptions.LoginInvalidoException;
import exceptions.SenhasDiferentesException;
import texto.Dono;
import texto.Empresa;
import texto.Funcionario;

public interface IRepositorioEmpresaList {
	
	boolean cadastrar(Empresa empresa);
	boolean atualizar(Empresa empresa);
	boolean remover(Empresa empresa);
	boolean entrarEmpresa(Empresa empresa) throws SenhasDiferentesException, LoginInvalidoException;
	boolean sair(Empresa empresa);
	boolean existeEmpresa(String login);
	Empresa isLogado();
	Empresa getUltimo();
	


}
