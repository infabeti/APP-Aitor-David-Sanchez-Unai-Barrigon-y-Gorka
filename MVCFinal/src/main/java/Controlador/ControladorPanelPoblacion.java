package Controlador;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Modelo.Modelo;
import Vista.PanelPoblacion;
import Vista.Vista;

public class ControladorPanelPoblacion extends ControladoresPaneles{

	private PanelPoblacion panelPoblacion;
	private ArrayList<String[]> locales;

	public ControladorPanelPoblacion(Modelo modelo, Vista vista, Controlador controlador) {
		super(modelo, vista, controlador);
		this.locales = this.getModelo().getConsultas().conseguirLocales();
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
	
	public String[] conseguirLocales() {
		String [] nombreLocales = new String[locales.size()];
		int i = 0;
		for (String[] array : locales) {
                nombreLocales[i] = array[1];
                i++;
            }
		return nombreLocales;
	}
	
	public String devolverFechaHora() {
		return this.getModelo().getFechaHoraSys();
	}
	
	public int conseguirStock(String nif, String producto) {
		return this.getModelo().getConsultas().obtenerStock(nif, producto);
	}
	

	public void insertarTicket(int transaccion, String fecha, double totalOperacion, String nif,
			DefaultListModel<String> lista) {
		this.getModelo().insercionesActividades.insertarActividad(transaccion, devolverFechaFormateada(fecha), totalOperacion, "TICKET", nif);
		for (int i = 0; i < lista.getSize(); i++) {
			String textoSpliteado[] = lista.get(i).split(" ");
			insertarProductoActividad(i, transaccion, Integer.parseInt(textoSpliteado[0]), nif);
		}
	}

	public void insertarProductoActividad(int nombreProducto, int transaccion, int cantidad, String nif) {
		String producto = devolverNombreProducto(nombreProducto);
		this.getModelo().getInserciones().insertarProductoActividad(transaccion,
				this.getModelo().getConsultas().obtenerCodigoAlimentoProducto(producto), cantidad,
				cogerPrecioString(producto),nif);
	}
	public String devolverNombreProducto(int i) {
		return this.getModelo().funProd.devolverNombreProducto(i);
	}
	
	public double cogerPrecioString(String nombreProducto) {
		return this.getModelo().getListaTemporal().precioProductoString(nombreProducto);
	}
	
	public String devolverFechaFormateada(String input) {
		return this.getModelo().validaciones.devolverFechaFormateada(input);
	}

}
