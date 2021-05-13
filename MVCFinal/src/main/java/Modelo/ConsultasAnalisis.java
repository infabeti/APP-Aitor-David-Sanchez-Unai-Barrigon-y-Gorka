package Modelo;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultasAnalisis {

	private Modelo modelo;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();

	public ConsultasAnalisis(Modelo modelo) throws SQLException {
		this.modelo = modelo;
	}

	public ArrayList<String> obtenerHistoricoLocal(String codigoAlimento, String codigoLocal) {
		System.out.println("******* " + codigoLocal);
		ArrayList<String> historicoLocal = new ArrayList<String>();
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.CONSULTAHISTORICOLOCAL);) {
			st.setString(1, codigoAlimento);
			st.setString(2, codigoLocal);
			ResultSet rs = this.modelo.getEjecutarAccion().consultar(st);
			while (rs.next()) {

				String codigoAlimento2 = rs.getString("nombre");
				String probabilidad = rs.getString("probabilidad");
				historicoLocal.add(codigoAlimento2 + " - " + probabilidad + "%");
			}
			rs.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return historicoLocal;
	}

	public ArrayList<String> obtenerHistoricoGlobal(String codigoAlimento) {
		ArrayList<String> historicoGlobal = new ArrayList<String>();
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.CONSULTAHISTORICOGLOBAL);) {
			st.setString(1, codigoAlimento);
			ResultSet rs = this.modelo.getEjecutarAccion().consultar(st);
			if (rs.next()) {
				while (rs.next()) {
					String codigoAlimento2 = rs.getString("nombre");
					String probabilidad = rs.getString("probabilidad");
					historicoGlobal.add(codigoAlimento2 + " - " + probabilidad + "%");
				}
				rs.close();
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return historicoGlobal;
	}

	public void ejecutarAlgoritmosCalculoProbabilidades() {
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				CallableStatement cStmt = conexionConn.prepareCall(sentenciasBBDD.PROCESOSANALISIS);) {
			this.modelo.getEjecutarAccion().consultar(cStmt);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
