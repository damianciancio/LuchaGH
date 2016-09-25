package logic;
import java.util.Random;

import data.*;
import entities.*;

public class ControladorPelea {
	public PersonajeLuchando p1;
	public PersonajeLuchando p2;
	
	public PersonajeLuchando turnoDe;
	public PersonajeLuchando esperando;
	
	public ControladorPelea(Personaje pe1, Personaje pe2)
	{
		p1 = new PersonajeLuchando(pe1);
		p2 = new PersonajeLuchando(pe2);
		
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
	public boolean atacar(int cantPtos)
	{
		boolean resultado;
		if(turnoDe.getEnergiaActual()<=cantPtos)
		{
			resultado = turnoDe.atacar(esperando, cantPtos);
		}
		else
			resultado =  false;
		cambiarDeTurno();
		return resultado;
	}
	
	public void defender()
	{
		turnoDe.defender();
		cambiarDeTurno();
	}
	
	public void cambiarDeTurno()
	{
		PersonajeLuchando aux = turnoDe;
		turnoDe = esperando;
		esperando = aux;
	}
}
