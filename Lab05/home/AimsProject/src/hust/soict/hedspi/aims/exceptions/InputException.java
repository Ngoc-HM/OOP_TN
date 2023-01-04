package hust.soict.hedspi.aims.exceptions;

public class InputException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public InputException(String msg) {
		super(msg);
	}
	
	public InputException(String msg, Throwable cause) {
		super(msg, cause);
	}
}