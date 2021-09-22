package exceptions;

public class SenhasDiferentesException extends Exception{

	public SenhasDiferentesException()
	{
		super("As senhas não coincidem!");
	}
}
