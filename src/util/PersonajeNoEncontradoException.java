package util;

public class PersonajeNoEncontradoException extends Exception {
	
	public PersonajeNoEncontradoException () {
		super();
	}
	
	public PersonajeNoEncontradoException (String msj) {
		super(msj);
	}
}
