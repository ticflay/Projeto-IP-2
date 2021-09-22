package exceptions;

public class CodigoPequenoException extends Exception{
	
	public CodigoPequenoException()
	{
		super("O código deve ter pelo menos dois caracteres!");
	}

}
