package exception;

public class DataNascAberturaException extends Exception {
	
	public DataNascAberturaException(String msg, Exception e) {
		super(msg, e);
	}
	
	public DataNascAberturaException(String msg) {
		super(msg);
	}


}
