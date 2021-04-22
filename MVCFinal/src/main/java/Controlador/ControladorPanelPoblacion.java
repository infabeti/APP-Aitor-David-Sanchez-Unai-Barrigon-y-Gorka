package Controlador;

import javax.swing.DefaultListModel;

import Modelo.Modelo;
import Vista.PanelPoblacion;
import Vista.Vista;
import bbdd.*;

public class ControladorPanelPoblacion extends ControladoresPaneles{

	private PanelPoblacion panelPoblacion;

	public ControladorPanelPoblacion(Modelo modelo, Vista vista, Controlador controlador) {
		super(modelo, vista, controlador);
	}

	public void mostrarPanel() {
		this.panelPoblacion = makePanelPoblacion(this);
		super.getVista().mostrarPanel(this.panelPoblacion);
	}

	public PanelPoblacion makePanelPoblacion(ControladorPanelPoblacion controladorPanelPoblacion) {
		return new PanelPoblacion(controladorPanelPoblacion);
	}
	
	public String leerNumTransBBDD() {
		return String.valueOf(this.getModelo().getConsultas().leerNumTransBBDD());
	}
	
	public String devolverFechaHora() {
		return this.getModelo().getFechaHoraSys();
	}
	
	public int conseguirStock(String nif, String producto) {
		return this.modelo.getConsultas().obtenerStock(nif, producto);
	}
	

	public void insertarTicket(int transaccion, String fecha, double totalOperacion, String nif,
			DefaultListModel<String> lista) {
		this.modelo.insercionesActividades.insertarActividad(transaccion, devolverFechaFormateada(fecha), totalOperacion, "TICKET", nif);
		for (int i = 0; i < lista.getSize(); i++) {
			String textoSpliteado[] = lista.get(i).split(" ");
			insertarProductoActividad(i, transaccion, Integer.parseInt(textoSpliteado[0]));
		}
	}

	public void insertarProductoActividad(int nombreProducto, int transaccion, int cantidad) {
		String producto = devolverNombreProducto(nombreProducto);
		this.modelo.getInserciones().insertarProductoActividad(transaccion,
				this.modelo.getConsultas().obtenerCodigoAlimentoProducto(producto), cantidad,
				cogerPrecioString(producto));
	}

}
