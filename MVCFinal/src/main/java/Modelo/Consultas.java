package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bbdd.EjecutarAccion;

public class Consultas {

	private Modelo modelo;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();
	private EjecutarAccion ejecutarAccion;

	public Consultas(Modelo modelo, EjecutarAccion ejecutarAccion) throws SQLException {
		this.modelo = modelo;
		this.ejecutarAccion = new EjecutarAccion();
	}

	public PreparedStatement conseguirPreparedStatement(String sentenciaBbdd) {
		PreparedStatement st = null;
		java.sql.Connection conexionConn = null;
		try {
			conexionConn = this.modelo.getConexion().getConn();
			st = (PreparedStatement) ((java.sql.Connection) conexionConn).prepareStatement(sentenciaBbdd);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexionConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return st;
	}

	public ResultSet conseguirLocales() {
		return ejecutarAccion.consultar(conseguirPreparedStatement(sentenciasBBDD.CONSEGUIRLOCAL));
	}

	public int leerNumTransBBDD() {
		ResultSet rs = ejecutarAccion.consultar(conseguirPreparedStatement(sentenciasBBDD.CONSULTAACTIVIDAD));
		int numero = 1;
		try {
			while (rs.next()) {
				numero++;
			}
			return numero;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public int obtenerStock(String nif, String codigoAlimento) {
		int cantidadActual = 0;
		try {
			PreparedStatement st = conseguirPreparedStatement(sentenciasBBDD.CONSEGUIRCANTIDADSTOCK);
			st.setString(1, codigoAlimento);
			st.setString(2, nif);
			ResultSet rs = ejecutarAccion.consultar(st);
			while (rs.next()) {
				cantidadActual = rs.getInt("cantidad");
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return cantidadActual;
	}

	public String obtenerCodigoAlimentoProducto(String producto) {
		ResultSet rs = ejecutarAccion.consultar(conseguirPreparedStatement(sentenciasBBDD.CONSULTAALIMENTO));
		try {
			while (rs.next()) {
				if (rs.getString("nombre").equalsIgnoreCase(producto)) {
					return rs.getString("codigoalimento");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String obtenerCodigoPlato(String plato) {
		ResultSet rs = ejecutarAccion.consultar(conseguirPreparedStatement(sentenciasBBDD.CONSULTAPLATO));
		try {
			while (rs.next()) {
				if (rs.getString("nombre").equalsIgnoreCase(plato)) {
					return rs.getString("codigoplato");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}