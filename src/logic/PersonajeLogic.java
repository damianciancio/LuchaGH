package logic;

import java.util.ArrayList;
import util.PersonajeInvalidoException;
import util.PersonajeNoEncontradoException;
import entities.*;
import data.*;

public class PersonajeLogic {
	private PersonajeAdapter _db;
	
	public PersonajeLogic() {
		_db = new PersonajeAdapter();
	}
	
	public void guardar(Personaje p) throws PersonajeInvalidoException
	{
		try {
			String error = "";
			
			int def = p.getDefensa();
			int ene = p.getEnergia();
			int vid = p.getVida();
			int eva = p.getEvasion();
			
			int ptosDisp = p.getPtsDisp();
			
			if (def + ene + vid + eva > ptosDisp) {
				error += "Los atributos elegidos superan a los disponible \n";
			}
			if (eva > 80) {
				error += "La evasión no puede superar los 80 puntos \n";
			}
			if (def > 20) {
				error += "La defensa no puede superar los 20 puntos \n";
			}
			
			if (error.length() != 0) {
				throw new PersonajeInvalidoException(error);
			}
			
			_db.Guardar(p);
			
		} catch (PersonajeInvalidoException piEx) {
			throw piEx;
		}
	}

	public ArrayList<Personaje> GetAll() {
		return _db.GetAll();
	}
	
	public Personaje GetByNombre(Personaje pj) throws PersonajeNoEncontradoException {
		return _db.GetByNombre(pj);
	}
}
