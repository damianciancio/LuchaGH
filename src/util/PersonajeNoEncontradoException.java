package util;

@SuppressWarnings("serial")
public class PersonajeNoEncontradoException extends Exception {
	
	public PersonajeNoEncontradoException () {
		super();
	}
	
	public PersonajeNoEncontradoException (String msj) {
		super(msj);
	}
}
