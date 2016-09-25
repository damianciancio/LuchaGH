package console;

import entities.Personaje;
import logic.*;

public class Prueba {

	public static void main(String[] args) {
		
		
		
		PersonajeLogic pl = new PersonajeLogic();
		Personaje p = new Personaje();
		p.setNombre("damian");
		try{
		System.out.println(pl.GetByNombre(p).getNombre());
		}
		catch(Exception e)
		{
			System.out.println("no");
		}

	}

}
