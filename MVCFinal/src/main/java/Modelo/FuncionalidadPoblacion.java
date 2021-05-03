package Modelo;

import java.sql.SQLException;

import javax.swing.DefaultListModel;

public class FuncionalidadPoblacion {

	private Modelo modelo;

	public FuncionalidadPoblacion(Modelo modelo) {
		this.modelo = modelo;
	}

	public void insertarProductoActividad(int nombreProducto, int transaccion, int cantidad, String nif) {
		String producto = devolverNombreProducto(nombreProducto);
		this.modelo.getInserciones().insertarProductoActividad(transaccion,
				this.modelo.getConsultas().obtenerCodigoAlimentoProducto(producto), cantidad,
				cogerPrecioString(producto), nif);
	}

	public String devolverNombreProducto(int i) {
		return this.modelo.funProd.devolverNombreProducto(i);
	}

	public double cogerPrecioString(String nombreProducto) {
		return this.modelo.getListaTemporal().precioProductoString(nombreProducto);
	}

	public void insertarDatos(DefaultListModel<String> lista, int transaccion, String nif, String tipo,
			String nifComprador, String nombre, String apellido, String domicilio,DefaultListModel<String> listaPlatos) throws SQLException {
		//Insertamos los productos
		for (int i = 0; i < lista.getSize(); i++) {
			String textoSpliteado[] = lista.get(i).split(" ");
			insertarProductoActividad(i, transaccion, Integer.parseInt(textoSpliteado[0]), nif);
		}
		if (tipo.equalsIgnoreCase("Aprovisionamiento")) {
			this.modelo.insercionesActividades.insertarAprovisionamiento(transaccion);
		}
		if (tipo.equalsIgnoreCase("Factura")) {
			insertarFactura( nifComprador,  nombre,  apellido,  transaccion);
		}
		if (tipo.equalsIgnoreCase("Pedido")) {
			this.modelo.insercionesActividades.insertarPedido(transaccion, domicilio);
		}
		if (tipo.equalsIgnoreCase("Comanda")) {
			insertarComanda(listaPlatos, transaccion);
		}
		this.modelo.insercionesActividades.ejecutarFuncion(transaccion, tipo);
	}

	public void insertarFactura(String nifComprador, String nombre, String apellido, int transaccion) {
		// insertamos en factura y en comprador si toca
		if (this.modelo.getConsultasComprobaciones().comprobarSiExisteComprador(nifComprador)) {
			System.out.println("El comprador ya existe, no se hace la insert en la tabla comprador");
		} else {
			this.modelo.getInserciones().insertarComprador(nifComprador, nombre, apellido);
		}
		this.modelo.insercionesActividades.insertarFactura(transaccion, nifComprador);
	}
	
	public void insertarComanda(DefaultListModel<String> listaPlatos, int transaccion) {
		this.modelo.insercionesActividades.insertarComanda(transaccion);

		for (int i = 0; i < listaPlatos.getSize(); i++) {
			String textoSpliteado[] = listaPlatos.get(i).split(" ");
			this.modelo.getInserciones().insertarPlatoActividad(transaccion,
					this.modelo.getConsultas()
							.obtenerCodigoPlato(this.modelo.getListaTemporalPlatos().getListaPlatosString()[i]),
					Integer.parseInt(textoSpliteado[0]));
		}
	}

}
