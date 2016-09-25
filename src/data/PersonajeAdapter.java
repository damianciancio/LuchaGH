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
	
	public ArrayList<Personaje> GetAll() throws Exception
	{
	
		ResultSet rs=null;
		PreparedStatement stmt=null;
		ArrayList<Personaje> personajes = new ArrayList<Personaje>();
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("SELECT * FROM personajes");
			rs = stmt.executeQuery();
			
			while (rs.next()) 
			{
				Personaje p = new Personaje();
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setPtsDisp(rs.getInt(3));
				p.setVida(rs.getInt(4));
				p.setEnergia(rs.getInt(5));
				p.setDefensa(rs.getInt(6));
				p.setEvasion(rs.getInt(7));
				personajes.add(p);
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return personajes;
		//return _list;
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
		switch(pj.getEstData()) {
		case New:
			addPersonaje(pj);
			break;
		case Modified:
			editPersonaje(pj);
			break;
		case Deleted:
			deletePersonaje(pj);
			break;
		default:
			break;
		}
	}

	private void addPersonaje(Personaje pj) throws Exception, ErrorConexionException {
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
	
	private void editPersonaje(Personaje pj) throws Exception, ErrorConexionException {
		//
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"Update personajes Set "
					+ "nombre = ?, "
					+ "puntos_disp = ?, "
					+ "vida = ?, "
					+ "energia = ?, "
					+ "defensa = ?, "
					+ "evasion = ? "
					+ "Where id_personaje = ?");
						
			stmt.setString(1, pj.getNombre());
			stmt.setInt(2, pj.getPtsDisp());
			stmt.setInt(3, pj.getVida());
			stmt.setInt(4, pj.getEnergia());
			stmt.setInt(5, pj.getDefensa());
			stmt.setInt(6, pj.getEvasion());
			stmt.setInt(7, pj.getId());
			stmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception("Error al editar personaje", e);
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
	
	private void deletePersonaje(Personaje pj) throws Exception, ErrorConexionException {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"Delete From personajes "
					+ "Where id_personaje = ?");
						
			stmt.setInt(1, pj.getId());
			stmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception("Error al editar personaje", e);
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
