
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConseguirDatosBbdd {

	public ArrayList<String[]> conseguirLocales(ResultSet rs) {
		ArrayList<String[]> locales = new ArrayList<String[]>();
		try {
			while (rs.next()) {
				String nif = rs.getString("nif");
				String nombre = rs.getString("nombre");
				String tiponegocio = rs.getString("tiponegocio");
				locales.add(new String[] { nif, nombre, tiponegocio });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locales;
	}

	public ArrayList<String[]> cogerProductosLocal(ResultSet rs) throws SQLException {
		ArrayList<String[]> listaProd = new ArrayList<String[]>();

		try {
			while (rs.next()) {
				String nombre = rs.getString("a.nombre");
				String pCompra = String.valueOf(rs.getDouble("a.PCompra"));
				String pVenta = String.valueOf(rs.getDouble("p.PVenta"));
				String tipo = rs.getString("a.Tipo");
				String feCad = String.valueOf(rs.getDate("a.FeCad"));
				String[] producto = new String[] { nombre, feCad, tipo, pCompra, pVenta };

				listaProd.add(producto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rs.close();
		}
		return listaProd;
	}
	
	public ArrayList<String[]> cogerListaPlatos(ResultSet rs) throws SQLException {
		ArrayList<String[]> listaPlatos = new ArrayList<String[]>();

		try {
			while (rs.next()) {
				String nombre = rs.getString("p.Nombre");
				String pvp = String.valueOf(rs.getDouble("p.pvp"));
				String[] producto = new String[] {nombre, pvp};
				listaPlatos.add(producto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rs.close();
		}
		return listaPlatos;
	}
}
