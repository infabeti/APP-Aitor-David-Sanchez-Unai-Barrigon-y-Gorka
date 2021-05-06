package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Consultas {

	private Modelo modelo;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();

	public Consultas(Modelo modelo) throws SQLException {
		this.modelo = modelo;
	}

	public ArrayList<String[]> conseguirLocales() {

		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.CONSEGUIRLOCAL);) {
			return this.modelo.getConseguirDatosBbdd().conseguirLocales(this.modelo.getEjecutarAccion().consultar(st));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int leerNumTransBBDD() {
		int numero = 1;
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.CONSULTAACTIVIDAD);
				ResultSet rs = this.modelo.getEjecutarAccion().consultar(st);) {
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
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.CONSEGUIRCANTIDADSTOCK);) {
			st.setString(1, codigoAlimento);
			st.setString(2, nif);
			ResultSet rs = this.modelo.getEjecutarAccion().consultar(st);
			while (rs.next()) {
				cantidadActual = rs.getInt("cantidad");
			}
			rs.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		return cantidadActual;
	}

	public String obtenerCodigoAlimentoProducto(String producto) {
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.CONSULTAALIMENTO);
				ResultSet rs = this.modelo.getEjecutarAccion().consultar(st);) {
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
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.CONSULTAPLATO);
				ResultSet rs = this.modelo.getEjecutarAccion().consultar(st);) {
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