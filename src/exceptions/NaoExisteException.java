package exceptions;

public class NaoExisteException extends Exception {
	private String codigo;
	private String tipo;
	
	public NaoExisteException(String codigo, String tipo, String tipoMenor)
	{
	super("Erro, " + tipo + " de "+tipoMenor+ " " + codigo + " não existe!");
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
