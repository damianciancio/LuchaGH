package data;
import java.sql.*;
import java.util.ArrayList;
import util.PersonajeNoEncontradoException;
import entities.*;
import util.*;

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
	
	public void Guardar(Personaje pj) throws Exception, ErrorConexionException
	{
		//_list.add(pj);
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into personajes(nombre, puntos_disp,vida, energia, defensa, evasion)"+
					" values(?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			// PreparedStatement.RETURN_GENERATED_KEYS to be able to retrieve id generated on the db
			// by the autoincrement column. Otherwise don't use it
						
			stmt.setString(1, pj.getNombre());
			stmt.setInt(2, pj.getPtsDisp());
			stmt.setInt(3, pj.getVida());
			stmt.setInt(4, pj.getEnergia());
			stmt.setInt(5, pj.getDefensa());
			stmt.setInt(6, pj.getEvasion());
			stmt.execute();
			
			//after executing the insert use the following lines to retrieve the id
			rs=stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				pj.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception("Error al crear personaje", e);
		} catch (ErrorConexionException e) {
			throw e;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (ErrorConexionException e) {
				throw e;
			} catch (SQLException e) {
				throw new Exception("Error al cerrar conexion",e);
			}
		}
		
		
		
		
		
		
	}
}
