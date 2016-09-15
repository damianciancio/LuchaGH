package util;

public class PersonajeInvalidoException extends Exception {
	
	public PersonajeInvalidoException () {
		super();
	}
	
	public PersonajeInvalidoException (String msj) {
		super(msj);
	}
}
