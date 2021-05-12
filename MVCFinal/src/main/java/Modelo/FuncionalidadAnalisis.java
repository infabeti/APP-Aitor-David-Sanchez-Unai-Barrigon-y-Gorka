package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.CallableStatement;

public class FuncionalidadAnalisis {

	private Modelo modelo;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();
	private java.sql.Connection conexionConn; 

	public FuncionalidadAnalisis(Modelo modelo) {
		this.modelo = modelo;
	}
	
	public ArrayList<String> procedimientoBayesGlobal() throws SQLException {
		
		ArrayList<String> array = new ArrayList();
		
		conexionConn = this.modelo.getConexion().getConn();
		
		java.sql.CallableStatement bayestm = conexionConn.prepareCall(sentenciasBBDD.BAYESGLOBAL);
		
		java.sql.ResultSet rs = bayestm.executeQuery();
		
		while(rs.next()) {
			
			int i = 0;
			
			array.add(rs.getString(i));
			
			i++;
		}
		
		
		return array;
	}
	
	public ArrayList<String> procedimientoBayesLocal() throws SQLException {
		
		conexionConn = this.modelo.getConexion().getConn();
		
		ArrayList<String> array = new ArrayList();
		
		java.sql.CallableStatement bayestm = conexionConn.prepareCall(sentenciasBBDD.BAYESLOCAL);
		
		java.sql.ResultSet rs = bayestm.executeQuery();
		
		while(rs.next()) {
			
			int i = 0;
			
			array.add(rs.getString(i));
			
			i++;
		}
		
		
		return array;
	}
	
	
}
