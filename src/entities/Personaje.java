package entities;

import java.util.Random;

public class Personaje extends Entidad {
	private String nombre;
	private int ptsDisp;
	private int vida;
	private int energia;
	private int defensa;
	private int evasion;
	
	public Personaje()
	{
		setEstData(Entidad.estadoData.Unmodified);
		ptsDisp = 200;
	}	
	
	public String toString()
	{
		return this.nombre +" "+ "\tPuntos restantes: "+this.ptsDisp;
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

	public boolean atacar(Personaje atacado, int cantPtos)
	{
		return atacado.recibirAtaque(cantPtos);
	}
	public boolean recibirAtaque(int cantPtos)
	{
		Random rdm = new Random();
		int tirada = (int)Math.round(rdm.nextDouble() * 100);

		return tirada > this.getEvasion();
	}
	
	public boolean equals(Personaje pj) {
		return pj.getNombre().equals(pj.getNombre());
	}
}
