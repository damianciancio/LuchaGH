package data;
import java.util.ArrayList;
import util.PersonajeNoEncontradoException;
import entities.*;

public class PersonajeAdapter {
	
	private ArrayList<Personaje> _list;
	
	public PersonajeAdapter() 
	{
		_list = new ArrayList<Personaje>();
	}
	
	public ArrayList<Personaje> GetAll() 
	{
		return _list;
	}

	public Personaje GetByNombre(Personaje pj) throws PersonajeNoEncontradoException
	{
		int indice = _list.indexOf(pj);
		
		if (indice == -1) throw new PersonajeNoEncontradoException("No se ha encontrado el personaje");

		Personaje result = _list.get(indice);
		
		return result;
	}
	
	public void Guardar(Personaje pj)
	{
		_list.add(pj);
		
	}
}
