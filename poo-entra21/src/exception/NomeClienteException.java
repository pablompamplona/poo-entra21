package exception;

public class NomeClienteException extends Exception {
	
	public NomeClienteException(String msg, Exception e) {
		super(msg, e);
	}
	
	public NomeClienteException(String msg) {
		super(msg);
	}


}
