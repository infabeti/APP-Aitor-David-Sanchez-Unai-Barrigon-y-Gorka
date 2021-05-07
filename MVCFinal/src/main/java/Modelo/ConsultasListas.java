package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConsultasListas {

	private Modelo modelo;
	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();


	public ConsultasListas(Modelo modelo) throws SQLException {
		this.modelo = modelo;
	}

	public ArrayList<String[]> cogerProductosLocal(String NIFLocal) throws SQLException {
		ResultSet rs = null;
		ArrayList<String[]> productos = new ArrayList<String[]>();
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.CONSULTAPRODUCTOLOCAL);) {
			st.setString(1, NIFLocal);
			rs = this.modelo.getEjecutarAccion().consultar(st);
			productos = this.modelo.getConseguirDatosBbdd().cogerProductosLocal(rs);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			rs.close();
		}
		return productos;
	}
	
	public ArrayList<String[]> cogerListaPlatos(String NIFLocal) throws SQLException {
		ResultSet rs = null;
		ArrayList<String[]> platos = new ArrayList<String[]>();
		try (java.sql.Connection conexionConn = this.modelo.getConexion().getConn();
				PreparedStatement st = (PreparedStatement) ((java.sql.Connection) conexionConn)
						.prepareStatement(sentenciasBBDD.PLATOJOINCARTA);) {
			st.setString(1, NIFLocal);
			rs = this.modelo.getEjecutarAccion().consultar(st);
			platos = this.modelo.getConseguirDatosBbdd().cogerListaPlatos(rs);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			rs.close();
		}
		return platos;
	}

}
