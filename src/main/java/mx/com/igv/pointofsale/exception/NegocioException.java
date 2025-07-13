package mx.com.igv.pointofsale.exception;

public class NegocioException extends RuntimeException{
	
	private static final long serialVersionUID = -8343482432214280084L;

	public NegocioException(String mensaje) {
        super(mensaje);
    }
}
