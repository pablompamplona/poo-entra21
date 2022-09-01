package exception;

public class CpfOuCnpjException extends Exception {
	
	public CpfOuCnpjException(String msg, Exception e) {
		super(msg, e);
	}
	
	public CpfOuCnpjException(String msg) {
		super(msg);
	}

}
