package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas {

	private Modelo modelo;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();

	public Consultas(Modelo modelo) throws SQLException {
		this.modelo = modelo;
	}

	public PreparedStatement conseguirPreparedStatement(String sentenciaBbdd) {
		PreparedStatement st = null;
		java.sql.Connection conexionConn = null;
		try {
			conexionConn = this.modelo.getConexion().getConn();
			st = (PreparedStatement) ((java.sql.Connection) conexionConn).prepareStatement(sentenciaBbdd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}

	public ResultSet conseguirLocales() {
		return this.modelo.getEjecutarAccion().consultar(conseguirPreparedStatement(sentenciasBBDD.CONSEGUIRLOCAL));
	}

	public int leerNumTransBBDD() {
		ResultSet rs = this.modelo.getEjecutarAccion().consultar(conseguirPreparedStatement(sentenciasBBDD.CONSULTAACTIVIDAD));
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
			ResultSet rs = this.modelo.getEjecutarAccion().consultar(st);
			while (rs.next()) {
				cantidadActual = rs.getInt("cantidad");
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		return cantidadActual;
	}

	public String obtenerCodigoAlimentoProducto(String producto) {
		ResultSet rs = this.modelo.getEjecutarAccion().consultar(conseguirPreparedStatement(sentenciasBBDD.CONSULTAALIMENTO));
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
		ResultSet rs = this.modelo.getEjecutarAccion().consultar(conseguirPreparedStatement(sentenciasBBDD.CONSULTAPLATO));
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