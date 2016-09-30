package util;

@SuppressWarnings("serial")
public class ErrorConexionException extends Exception {

	public ErrorConexionException () {
		super();
	}
	
	public ErrorConexionException (String msj) {
		super(msj);
	}
}
