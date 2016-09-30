package util;

@SuppressWarnings("serial")
public class DriverNoEncontradoException extends Exception {
	
	public DriverNoEncontradoException () {
		super();
	}
	
	public DriverNoEncontradoException (String msj) {
		super(msj);
	}

}
