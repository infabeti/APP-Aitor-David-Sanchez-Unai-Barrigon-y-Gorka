package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConsultasListas {

	private Modelo modelo;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();


	public ConsultasListas(Modelo modelo) throws SQLException {
		this.modelo = modelo;
	}

	public ResultSet cogerProductosLocal(String NIFLocal) {
		ResultSet rs = null;
		java.sql.Connection conexionConn = null;
		try {
			PreparedStatement st = null;
			conexionConn = this.modelo.getConexion().getConn();
			st = (PreparedStatement) ((java.sql.Connection) conexionConn)
					.prepareStatement(sentenciasBBDD.CONSULTAPRODUCTOLOCAL);
			st.setString(1, NIFLocal);
			rs = this.modelo.getEjecutarAccion().consultar(st);

			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return rs;
	}

	public ResultSet cogerProductosAprovisionamiento() {
		ResultSet rs = null;
		java.sql.Connection conexionConn = null;
		try {
			PreparedStatement st = null;
			conexionConn = this.modelo.getConexion().getConn();
			st = (PreparedStatement) ((java.sql.Connection) conexionConn)
					.prepareStatement(sentenciasBBDD.ALIMENTOORDENADO);
			rs = this.modelo.getEjecutarAccion().consultar(st);
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet cogerListaPlatos(String NIFLocal) {
		ResultSet rs = null;
		java.sql.Connection conexionConn = null;
		try {
			PreparedStatement st = null;
			conexionConn = this.modelo.getConexion().getConn();
			st = (PreparedStatement) ((java.sql.Connection) conexionConn)
					.prepareStatement(sentenciasBBDD.PLATOJOINCARTA);
			st.setString(1, NIFLocal);
			rs = this.modelo.getEjecutarAccion().consultar(st);
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return rs;
	}

}
