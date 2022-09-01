package exception;

public class IdException extends Exception {
	
	public IdException(String msg, Exception e) {
		super(msg, e);
	}
	
	public IdException(String msg) {
		super(msg);
	}
	
}
