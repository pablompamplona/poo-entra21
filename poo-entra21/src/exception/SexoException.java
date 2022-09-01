package exception;

public class SexoException extends Exception {
	
	public SexoException(String msg, Exception e) {
		super(msg, e);
	}
	
	public SexoException(String msg) {
		super(msg);
	}

}
