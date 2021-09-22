package dados;
import texto.Dono;
import exceptions.JaExisteException;
import exceptions.LoginInvalidoException;
import exceptions.NaoExisteException;
import exceptions.SenhasDiferentesException;
import texto.Empresa;
import texto.Funcionario;

public interface IRepositorioFuncionarioList {
	boolean adicionar(Funcionario funcionario) throws LoginInvalidoException, JaExisteException;
	boolean remover(Funcionario funcionario) throws NaoExisteException, LoginInvalidoException;
	boolean atualizar(Funcionario funcionarioAntigo, Funcionario funcionarioNovo) throws NaoExisteException, LoginInvalidoException;
	boolean entrar(String login, char[] senha, Empresa empresa) throws LoginInvalidoException, SenhasDiferentesException;
	Funcionario isLogadoFuncionario();
	Dono isLogadoDono();
	boolean cadastrarDono(Dono dono);
	boolean sair(Dono dono);
	boolean sair(Funcionario funcionario);
	Funcionario getFuncionarioEntrar(int index, Empresa empresa);
	Dono getDonoEntrar(int index, Empresa empresa);
	int getTamanhoFuncionario();
	int getTamanhoDono();
}
