package data;
import java.util.ArrayList;
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
	
	//ToDo crear una excepción más decente para diferenciar distintos errores (como los de sql)
	public Personaje GetByNombre(Personaje pj) throws Exception
	{
		int indice = _list.indexOf(pj);
		
		if (indice == -1) throw new Exception("No se ha encontrado el personaje");

		Personaje result = _list.get(indice);
		
		return result;
	}
}
