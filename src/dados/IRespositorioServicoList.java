package dados;

import exceptions.JaExisteException;
import exceptions.NaoExisteException;
import texto.Empresa;
import texto.Servico;

public interface IRespositorioServicoList {
	boolean adicionar(String nome, int codigo, Double preco, Empresa empresa) throws JaExisteException;
	boolean remover(Servico servico) throws NaoExisteException;
	boolean atualizar(Servico servicoAtual, Servico servicoAnterior) throws JaExisteException, NaoExisteException;
	Servico getServicoEntrar(int index, Empresa empresa);
	int getTamanho();

}
