package mx.com.igv.pointofsale.exception;

public class MyNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -3512826895507611842L;
	
	public MyNotFoundException(String mensaje) {
		super(mensaje);
	}
}