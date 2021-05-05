package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bbdd.EjecutarAccion;

public class ConsultasComprobaciones {

	private Modelo modelo;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();
	private EjecutarAccion ejecutarAccion;

	public ConsultasComprobaciones(Modelo modelo, EjecutarAccion ejecutarAccion) throws SQLException {
		this.modelo = modelo;
		this.ejecutarAccion = new EjecutarAccion();

	}

	public boolean comprobarSiExisteNIF(String nif) {
		PreparedStatement st = null;
		java.sql.Connection conexionConn = null;

		try {
			conexionConn = this.modelo.getConexion().getConn();
			st = (PreparedStatement) ((java.sql.Connection) conexionConn).prepareStatement(sentenciasBBDD.CONSULTANIF);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexionConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return consultaReal(st, nif);
	}

	public boolean comprobarSiExisteComprador(String nif) {
		PreparedStatement st = null;
		java.sql.Connection conexionConn = null;
		try {
			conexionConn = this.modelo.getConexion().getConn();
			st = (PreparedStatement) ((java.sql.Connection) conexionConn)
					.prepareStatement(sentenciasBBDD.EXISTECOMPRADOR);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexionConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return consultaReal(st, nif);
	}

	public boolean comprobarSiExisteDNI(String nif) {
		PreparedStatement st = null;
		java.sql.Connection conexionConn = null;
		try {
			conexionConn = this.modelo.getConexion().getConn();
			st = (PreparedStatement) ((java.sql.Connection) conexionConn).prepareStatement(sentenciasBBDD.CONSULATDNI);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexionConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return consultaReal(st, nif);
	}

	public boolean consultaReal(PreparedStatement st, String nif) {
		try {
			st.setString(1, nif);
			ResultSet rs = ejecutarAccion.consultar(st);

			return rs.next();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return false;
	}

	public double consultaComprobarPrecio(String nombre) {
		java.sql.Connection conexionConn = null;
		try {
			conexionConn = this.modelo.getConexion().getConn();
			PreparedStatement st = null;
			st = (PreparedStatement) ((java.sql.Connection) conexionConn)
					.prepareStatement(sentenciasBBDD.CONSEGUIRPRECIOPRODUCTO);
			st.setString(1, nombre);
			ResultSet rs = ejecutarAccion.consultar(st);
			try {
				rs.next();
				return rs.getDouble("PCompra");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			try {
				conexionConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0.0;
	}
}