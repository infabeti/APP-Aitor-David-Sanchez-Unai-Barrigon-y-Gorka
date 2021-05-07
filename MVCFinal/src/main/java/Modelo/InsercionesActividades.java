package Modelo;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class InsercionesActividades {

	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();
	private Modelo modelo;

	public InsercionesActividades(Modelo modelo) throws SQLException {
		this.modelo = modelo;
	}

	public void insertarActividad(int transaccion, String fecha, double totalOperacion, String tipo, String nif)
			throws SQLException {
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.INSERTARACTIVIDAD);) {
			st.setInt(1, transaccion);
			st.setString(2, fecha);
			st.setDouble(3, totalOperacion);
			st.setString(4, tipo);
			st.setString(5, nif);
			try {
				this.modelo.getEjecutarAccion().insertar(st);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	public void ejecutarFuncion(int numTrans, String tipo) throws SQLException {
		ResultSet rs = null;
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				CallableStatement cStmt = conexionConn.prepareCall(sentenciasBBDD.LLAMARFUNCION);) {
			boolean comanda = false;
			if (tipo.equalsIgnoreCase("comanda"))
				comanda = true;

			cStmt.setInt(1, numTrans);
			cStmt.setBoolean(2, comanda);
			rs = this.modelo.getEjecutarAccion().consultar(cStmt);
			Double output = 0.0;

			if (rs.next()) {
				output = rs.getDouble(1);
			}

			PreparedStatement st = null;

			st = (PreparedStatement) ((java.sql.Connection) conexionConn)
					.prepareStatement(sentenciasBBDD.ACTUALIZARTOTALOPERACION);
			st.setDouble(1, output);
			st.setInt(2, numTrans);

			try {
				this.modelo.getEjecutarAccion().insertar(st);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
		}
	}

	public void insertarPedido(int transaccion, String domicilio) {
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.INSERTARPEDIDO);) {
				st.setInt(1, transaccion);
			try {
				if (domicilio.equalsIgnoreCase("")) {
					st.setNull(2, Types.NULL);
				} else {
					st.setString(2, domicilio);
				}
				this.modelo.getEjecutarAccion().insertar(st);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	public void insertarFactura(int transaccion, String nif) {
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.INSERTARFACTURA);) {
			st.setInt(1, transaccion);
			st.setString(2, nif);
			try {
				this.modelo.getEjecutarAccion().insertar(st);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	public boolean insertarComanda(int transaccion) {
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.INSERTARCOMANDA);) {
			try {
				st.setInt(1, transaccion);
				this.modelo.getEjecutarAccion().insertar(st);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return false;
		}
	}

	public boolean insertarAprovisionamiento(int transaccion) {
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.INSERTARAPROVISIONAMIENTO);) {
			try {
				st.setInt(1, transaccion);
				this.modelo.getEjecutarAccion().insertar(st);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return false;
		}
	}
}
