package data;
import util.*;
import java.sql.*;

public class FactoryConexion {
	private String dbDriver="com.mysql.jdbc.Driver";
	private String host="85.10.205.173";
	private String port="3306";
	private String user="usergh";
	private String pass="rootgh";
	private String db="luchagh";
	private String dbType="mysql";
	
	private Connection conn;
	private int cantConn=0;
	
	private FactoryConexion() throws DriverNoEncontradoException{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			throw new DriverNoEncontradoException("Error del Driver JDBC");
		}
	}
	
	private static FactoryConexion instancia;
	
	public static FactoryConexion getInstancia() throws DriverNoEncontradoException{
		if (instancia==null){
			instancia = new FactoryConexion();
		}
		return instancia;
	}
	
	public Connection getConn() throws ErrorConexionException{
		try {
			if(conn==null || conn.isClosed()){
				conn = DriverManager.getConnection(
						"jdbc:"+dbType+"://"+host+":"+port+"/"+
						db+"?user="+user+"&password="+pass+"&useSSL=false");
				cantConn++;
			}
		} catch (SQLException e) {
			throw new ErrorConexionException("Error al conectar a la DB");

		}
		return conn;
	}
	
	public void releaseConn() throws ErrorConexionException{
		try {
			cantConn--;
			if(cantConn==0){
				conn.close();
			}
		} catch (SQLException e) {
			throw new ErrorConexionException("Error al cerrar conexión");
		}
		
	}
}
