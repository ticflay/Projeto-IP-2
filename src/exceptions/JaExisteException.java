package exceptions;

public class JaExisteException extends Exception{
	private String tipo;
	private String codigo;
	private String tipoMenor;
	
	public JaExisteException(String codigo, String tipo, String tipoMenor)
	{
		super("O " +tipo+  " de " +tipoMenor+ " " +codigo + " já existe!");
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
