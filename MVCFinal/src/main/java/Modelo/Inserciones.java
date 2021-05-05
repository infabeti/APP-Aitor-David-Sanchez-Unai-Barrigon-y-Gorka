package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import bbdd.EjecutarAccion;

public class Inserciones {

	private final SentenciasBBDD sentenciasBBDD = new SentenciasBBDD();
	private Modelo modelo;
	private InsercionesActividades insercionesActividades;
	private EjecutarAccion ejecutarAccion;

	public Inserciones(Modelo modelo, EjecutarAccion ejecutarAccion) throws SQLException {
		this.modelo = modelo;
		this.insercionesActividades = new InsercionesActividades(modelo,ejecutarAccion);
		this.ejecutarAccion = new EjecutarAccion();
	}

	public void insertarProductoActividad(int transaccion, String codigoAlimento, int cantidad, double precioFinal,String nif) {
		java.sql.Connection conexionConn = null;
		try {
			PreparedStatement st = null;
			conexionConn = this.modelo.getConexion().getConn();
			st = (PreparedStatement) ((java.sql.Connection) conexionConn)
					.prepareStatement(sentenciasBBDD.INSERTARPRODUCTOACTIVIDAD);
			st.setString(1, codigoAlimento);
			st.setInt(2, transaccion);
			st.setInt(3, cantidad);
			st.setDouble(4, precioFinal);
			try {
				ejecutarAccion.insertar(st);
				try {
					PreparedStatement st2 = null;
					st2 = (PreparedStatement) ((java.sql.Connection) conexionConn)
							.prepareStatement(sentenciasBBDD.COMPROBARSIESAPROVISIONAMIENTO);
					st2.setInt(1, transaccion);
					ResultSet rs = ejecutarAccion.consultar(st2);
					rs.next();
					if (rs.getString("tipo").equalsIgnoreCase("aprovisionamiento")) {
						actualizarStockMenorQueCinco(codigoAlimento, nif, transaccion);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (precioFinal != 0) {
					actualizarStockMenorQueCinco(codigoAlimento, nif, transaccion);
				}
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
	}

	public void actualizarStockMenorQueCinco(String codigoAlimento, String nif, int transaccion) {
		java.sql.Connection conexionConn = null;
		try {
			PreparedStatement st = null;
			conexionConn = this.modelo.getConexion().getConn();
			st = (PreparedStatement) ((java.sql.Connection) conexionConn)
					.prepareStatement(sentenciasBBDD.CODIGOALIMENTO);
			st.setString(1, codigoAlimento);
			st.setString(2, nif);

			Calendar fecha = new GregorianCalendar();

			int anio = fecha.get(Calendar.YEAR);
			int mes = fecha.get(Calendar.MONTH);
			int dia = fecha.get(Calendar.DAY_OF_MONTH);

			String fechaAct = anio + "/" + mes + "/" + dia;

			try {
				ResultSet rs = ejecutarAccion.consultar(st);
				rs.next();
				int cantidad = rs.getInt("cantidad");
				if (cantidad < 5) {
					try {
						PreparedStatement st1 = null;
						st1 = (PreparedStatement) ((java.sql.Connection) conexionConn)
								.prepareStatement(sentenciasBBDD.PRECIOALIMENTO);
						st1.setString(1, codigoAlimento);
						ResultSet rs1 = ejecutarAccion.consultar(st1);
						rs1.next();
						double pcompra = rs1.getDouble("PCompra");
						insercionesActividades.insertarActividad(transaccion, fechaAct, pcompra * 50,
								"aprovisionamiento", nif);
						insercionesActividades.insertarAprovisionamiento(transaccion);
						insertarProductoActividad(transaccion, codigoAlimento, 50, pcompra, nif);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

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
	}

	public void updateStock(String nif, String codigoAlimento, int cantidad) {
		java.sql.Connection conexionConn = null;
		try {
			PreparedStatement st = null;
			conexionConn = this.modelo.getConexion().getConn();
			st = (PreparedStatement) ((java.sql.Connection) conexionConn)
					.prepareStatement(sentenciasBBDD.ACTUALIZARSTOCK);
			st.setInt(1, (cantidad + 50));
			st.setString(2, nif);
			st.setString(3, codigoAlimento);

			try {
				ejecutarAccion.insertar(st);
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
	}

	public void insertarComprador(String nif, String nombre, String apellido) {
		java.sql.Connection conexionConn = null;
		try {
			PreparedStatement st = null;
			conexionConn = this.modelo.getConexion().getConn();
			st = (PreparedStatement) ((java.sql.Connection) conexionConn)
					.prepareStatement(sentenciasBBDD.INSERTARCOMPRADOR);
			st.setString(1, nif);
			st.setString(2, nombre);
			st.setString(3, apellido);
			try {
				ejecutarAccion.insertar(st);
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
	}

	public boolean insertarRegistro(String dni, String Nombre, String Apellido, String contrasena, String nif) {
		java.sql.Connection conexionConn = null;
		try {
			PreparedStatement st = null;
			conexionConn = this.modelo.getConexion().getConn();
			st = (PreparedStatement) ((java.sql.Connection) conexionConn)
					.prepareStatement(sentenciasBBDD.INSERTAREMPLEADO);
			try {
				st.setString(1, dni);
				st.setString(2, Nombre);
				st.setString(3, Apellido);
				st.setString(4, contrasena);
				st.setString(5, nif);
				ejecutarAccion.insertar(st);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return false;
		} finally {
			try {
				conexionConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertarPlatoActividad(int transaccion, String codigoPlato, int cantidad) {
		java.sql.Connection conexionConn = null;
		try {
			PreparedStatement st = null;
			conexionConn = this.modelo.getConexion().getConn();
			st = (PreparedStatement) ((java.sql.Connection) conexionConn)
					.prepareStatement("insert into lineaplato (codigoplato,transaccion,cantidad)" + " values("
							+ codigoPlato + "," + transaccion + "," + cantidad + ");");
			try {
				ejecutarAccion.insertar(st);
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
	}
}