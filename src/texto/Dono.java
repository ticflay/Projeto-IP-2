package texto;

public class Dono extends FuncionarioPai{
	
	
	public Dono()
	{
		
	}
	public Dono(String login, char[] senha, String nome, Empresa empresa) {
		super(login, senha, nome, empresa);
		
		
		
		
	}
	
	
	
	@Override
	public String toString()
	{
		return "Nome: " +nome + " | Código: " +codigo;
	}
	
	public boolean equals(Dono dono)
	{
		if(dono != null)
		{
			if(dono.getLogin().equals(this.login) && dono.getEmpresa().equals(this.empresa))
			{
				return true;
			}
		}
		return false;
	}
	
	



	
	
	

}
