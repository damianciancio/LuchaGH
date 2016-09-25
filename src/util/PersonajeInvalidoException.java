package util;

@SuppressWarnings("serial")
public class PersonajeInvalidoException extends Exception {
	
	public PersonajeInvalidoException () {
		super();
	}
	
	public PersonajeInvalidoException (String msj) {
		super(msj);
	}
}
