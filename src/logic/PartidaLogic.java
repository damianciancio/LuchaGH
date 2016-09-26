package logic;

import java.util.Random;

import util.*;
import entities.*;

public class PartidaLogic {
	public boolean PartidaVigente;
	
	private PersonajeLuchando p1;
	private PersonajeLuchando p2;
	private PersonajeLuchando turnoDe;
	private PersonajeLuchando esperando;

	public PersonajeLuchando getP1() {
		return p1;
	}
	public void setP1(PersonajeLuchando p1) {
		this.p1 = p1;
	}
	public PersonajeLuchando getP2() {
		return p2;
	}
	public void setP2(PersonajeLuchando p2) {
		this.p2 = p2;
	}
	public PersonajeLuchando getTurnoDe() {
		return turnoDe;
	}
	public void setTurnoDe(PersonajeLuchando turnoDe) {
		this.turnoDe = turnoDe;
	}

	public PartidaLogic() {
		
	}
	
	public void comenzarPelea(Personaje pj1, Personaje pj2) throws PersonajeNoEncontradoException, PersonajeInvalidoException {
		if (pj1 == null || pj2 == null)
			throw new PersonajeNoEncontradoException("Elija ambos personajes");
		if (pj1.equals(pj2))
			throw new PersonajeInvalidoException("Elija personajes distintos");
		
		p1 = new PersonajeLuchando(pj1);
		p2 = new PersonajeLuchando(pj2);
		

		if(new Random().nextDouble()>0.5)
		{
			turnoDe = p1;
			esperando = p2;
		}
		else
		{
			turnoDe = p2;
			esperando = p1;
		}
	}

	
	public boolean atacar(int cantPtos) throws Exception
	{
		boolean ataqueExitoso = turnoDe.atacar(esperando, cantPtos);
		cambiarDeTurno();
		
		return ataqueExitoso;
	}
	
	public void defender()
	{
		turnoDe.defender();
		cambiarDeTurno();
	}
	
	private void cambiarDeTurno()
	{
		if (turnoDe == p1) {
			turnoDe = p2;
			esperando = p1;
		}
		else {
			turnoDe = p1;
			esperando = p2;
		}
	}
	
	
}
