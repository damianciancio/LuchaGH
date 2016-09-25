package logic;
import entities.*;
import util.PersonajeState;

public class PersonajeLuchando {
	private Personaje p;
	private int vidaActual;
	private int energiaActual;
	public PersonajeState estado;
	
	public PersonajeLuchando(Personaje p)
	{
		this.setP(p);
		this.estado = PersonajeState.NORMAL;
	}
	
	public Personaje getP() {
		return p;
	}
	public void setP(Personaje p) {
		this.p = p;
	}
	public int getVidaActual() {
		return vidaActual;
	}
	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}
	public int getEnergiaActual() {
		return energiaActual;
	}
	public void setEnergiaActual(int energiaActual) {
		this.energiaActual = energiaActual;
	}
	
	public boolean atacar(PersonajeLuchando pAtacado, int cantPtos)
	{
		if(this.getP().atacar(pAtacado.getP(), cantPtos))
		{
			pAtacado.restarVida(cantPtos);
			this.restarEnergia(cantPtos);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void restarVida(int cantPtos)
	{
		this.setVidaActual(this.getVidaActual()-cantPtos);
		if(this.getVidaActual()<=0)
		{
			this.estado = PersonajeState.SIN_VIDA;
		}
	}
	public void restarEnergia(int cantPtos)
	{
		this.setEnergiaActual(this.getEnergiaActual()-cantPtos);
		if(this.getEnergiaActual()<=0)
		{
			this.estado = PersonajeState.SIN_ENERGIA;
		}
	}
}