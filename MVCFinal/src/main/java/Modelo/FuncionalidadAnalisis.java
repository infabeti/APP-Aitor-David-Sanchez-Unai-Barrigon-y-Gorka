package Modelo;

import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;

public class FuncionalidadAnalisis {

	private Modelo modelo;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();
	private java.sql.Connection conexionConn; 

	public FuncionalidadAnalisis(Modelo modelo) {
		this.modelo = modelo;
	}
	
	public String [] procedimientoBayesGlobal() throws SQLException {
		
		conexionConn = this.modelo.getConexion().getConn();
		
		java.sql.CallableStatement bayestm = conexionConn.prepareCall(sentenciasBBDD.BAYESGLOBAL);
		
		java.sql.ResultSet rs = bayestm.executeQuery();
		
		if(rs.next()) {
			
			
		}
		
		
		return null;
	}
	
	public String [] procedimientoBayesLocal() throws SQLException {
		
		conexionConn = this.modelo.getConexion().getConn();
		
		java.sql.CallableStatement bayestm = conexionConn.prepareCall(sentenciasBBDD.BAYESLOCAL);
		
		java.sql.ResultSet rs = bayestm.executeQuery();
		
		if(rs.next()) {
			
			
		}
		
		
		return null;
	}
	
	
}
