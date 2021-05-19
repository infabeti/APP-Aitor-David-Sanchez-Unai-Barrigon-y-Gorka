package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasComprobaciones {

	private Modelo modelo;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();

	public ConsultasComprobaciones(Modelo modelo) throws SQLException {
		this.modelo = modelo;
	}

	public boolean comprobarSiExisteNIF(String nif) {
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.CONSULTANIF);) {
			return consultaReal(st, nif);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean comprobarSiExisteComprador(String nif) {
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.EXISTECOMPRADOR);) {
			return consultaReal(st, nif);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean comprobarSiExisteDNI(String nif) {
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.CONSULATDNI);) {
			return consultaReal(st, nif);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean consultaReal(PreparedStatement st, String nif) throws SQLException {
		ResultSet rs = null;
		try {
			st.setString(1, nif);
			rs = this.modelo.getEjecutarAccion().consultar(st);
			return rs.next();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		finally {
			rs.close();
			st.close();
		}

		return false;
	}

	public double consultaComprobarPrecio(String nombre) {
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.CONSEGUIRPRECIOPRODUCTO);) {
			st.setString(1, nombre);
			ResultSet rs = this.modelo.getEjecutarAccion().consultar(st);
			try {
				rs.next();
				return rs.getDouble("PCompra");
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				rs.close();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return 0.0;
	}
}
