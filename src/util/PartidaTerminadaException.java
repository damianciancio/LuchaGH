package util;

import entities.Personaje;

public class PartidaTerminadaException extends Exception {
	
	public PartidaTerminadaException(Personaje ganador, Personaje perdedor)
	{
		super("¡¡¡Partida terminada!!! Felicitaciones "+ganador.getNombre()+", le ganaste a "+perdedor.getNombre());
	}

}
