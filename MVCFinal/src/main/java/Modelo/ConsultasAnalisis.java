package Modelo;

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
	
	public  ArrayList<String[]> obtenerHistoricoLocal(String codigoAlimento, String codigoLocal) {
		ArrayList<String[]> historicoLocal = new ArrayList<String[]>();
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.CONSULTAHISTORICOLOCAL);) {
			st.setString(1, codigoAlimento);
			st.setString(2, codigoLocal);
			ResultSet rs = this.modelo.getEjecutarAccion().consultar(st);
			while (rs.next()) {
				String nif1 = rs.getString("NIF1");
				String nif2 = rs.getString("NIF2");
				String codigoAlimento1 = rs.getString("CodigoAlimento1");
				String codigoAlimento2 = rs.getString("CodigoAlimento2");
				String fecha = rs.getString("fecha");
				String probabilidad = rs.getString("probabilidad");
				historicoLocal.add(new String[] { nif1, nif2, codigoAlimento1, codigoAlimento2, fecha, probabilidad });
			}
			rs.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return historicoLocal;
	}
	
	public  ArrayList<String[]> obtenerHistoricoGlobal(String codigoAlimento) {
		ArrayList<String[]> historicoGlobal = new ArrayList<String[]>();
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.CONSULTAHISTORICOGLOBAL);) {
			st.setString(1, codigoAlimento);
			ResultSet rs = this.modelo.getEjecutarAccion().consultar(st);
			while (rs.next()) {
				String codigoAlimento1 = rs.getString("CodigoAlimento1");
				String codigoAlimento2 = rs.getString("CodigoAlimento2");
				String fecha = rs.getString("fecha");
				String probabilidad = rs.getString("probabilidad");
				historicoGlobal.add(new String[] {codigoAlimento1, codigoAlimento2, fecha, probabilidad });
			}
			rs.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return historicoGlobal;
	}
	

}
