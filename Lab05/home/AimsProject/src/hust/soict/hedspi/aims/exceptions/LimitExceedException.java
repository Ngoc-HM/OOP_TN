package hust.soict.hedspi.aims.exceptions;

public class LimitExceedException extends Exception{
	private static final long serialVersionUID = 1L;

	public LimitExceedException(String msg) {
		super(msg);
	}
	
	public LimitExceedException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
