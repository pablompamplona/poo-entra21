package exception;

public class TitularException extends Exception{
	
	public TitularException(String msg, Exception e) {
		super (msg, e);
	}
	
	public TitularException(String msg) {
		super(msg);
	}

}
