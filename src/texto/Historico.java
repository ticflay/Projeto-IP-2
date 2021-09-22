package texto;

import java.util.ArrayList;

public class Historico {
	
	private ArrayList<String> historico;
	private Empresa empresa;
	
	public Historico()
	{
		this.historico = new ArrayList<>();
		this.empresa = new Empresa();
	}
	
	public Historico(ArrayList<String> historico, Empresa empresa)
	{
		this.historico = new ArrayList<>();
		this.empresa = new Empresa();
		this.historico = historico;
		this.empresa = empresa;
	}
	
	public void adicionar(String hist)
	{
		if(hist != null)
		{
			this.historico.add(hist);
		}
	}

	public ArrayList<String> getHistorico() {
		return historico;
	}

	public void setHistorico(ArrayList<String> historico) {
		this.historico = historico;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public boolean equals(Historico historico)
	{
		if(historico != null)
		{
			if(historico.empresa.equals(this.empresa))
			{
				return true;
			}
		}
		return false;
	}
	
	
	
	

}
