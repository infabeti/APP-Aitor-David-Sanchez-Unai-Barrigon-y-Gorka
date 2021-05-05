package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bbdd.Conexion;
import bbdd.EjecutarAccion;

public class ConsultasListas {

	private Modelo modelo;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();
	private EjecutarAccion ejecutarAccion;


	public ConsultasListas(Modelo modelo, EjecutarAccion ejecutarAccion) throws SQLException {
		this.modelo = modelo;
		this.ejecutarAccion = new EjecutarAccion();
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
			rs = ejecutarAccion.consultar(st);

			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				conexionConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
			rs = ejecutarAccion.consultar(st);
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				conexionConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
			rs = ejecutarAccion.consultar(st);
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				conexionConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

}
