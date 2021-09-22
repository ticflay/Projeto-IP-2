package dados;

import texto.Empresa;
import texto.Historico;

public interface IRepositorioHistoricoList {
	boolean adicionar(String historico, Empresa empresa);
	boolean adicionar(Historico historico);
	Historico getHistorico(Empresa empresa);
	int getTamanho();

}
