package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Personaje {
	private String nombre;
	private int ptsDisp;
	private int vida;
	private int energia;
	private int defensa;
	private int evasion;
	
	public Personaje()
	{
		ptsDisp = 200;
	}	
		
	public String getNombre() {
		return nombre;
	}

	public int getPtsDisp() {
		return ptsDisp;
	}

	public int getVida() {
		return vida;
	}

	public int getEnergia() {
		return energia;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getEvasion() {
		return evasion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPtsDisp(int ptsDisp) {
		this.ptsDisp = ptsDisp;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}

	public String atacar(Personaje atacado, int cantPtos)
	{
		if(atacado.recibirAtaque(cantPtos))
		{
			return this.getNombre()+" ha atacado satisfactoriamente a "+ atacado.getNombre();
		}
		else
		{
			return this.getNombre()+" siga participando.";
		}
		
		
	}
	public boolean recibirAtaque(int cantPtos)
	{
		Random rdm = new Random();
		int tirada = (int)Math.round(rdm.nextDouble() * 100);

		return tirada > this.getEvasion();
	}
}
