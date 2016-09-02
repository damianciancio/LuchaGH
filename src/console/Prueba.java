package console;

import entities.Personaje;

public class Prueba {

	public static void main(String[] args) {
		
		
		
		Personaje p1 = new Personaje();
		Personaje p2 = new Personaje();
		
		p1.setNombre("Chizzo");
		p2.setNombre("Algy");
		
		p2.setEvasion(50);
		
		
		for (int i = 0; i < 10; i++)
			System.out.println(p1.atacar(p2,20));
		

	}

}
