package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;import javax.swing.DefaultListModel;import Modelo.Modelo;import Vista.PanelPoblacion;import Vista.Vista;

public class ControladorPanelPoblacion extends ControladoresPaneles {

	private PanelPoblacion panelPoblacion;
	private ArrayList<String[]> locales;
	private double total;

	public ControladorPanelPoblacion(Modelo modelo, Vista vista, Controlador controlador) {
		super(modelo, vista, controlador);
		this.locales = this.getModelo().getConseguirDatosBbdd().conseguirLocales(this.getModelo().getConsultas().conseguirLocales());
	}

	public void mostrarPanel() {
		this.total = 0;
		this.panelPoblacion = makePanelPoblacion(this);
		super.getVista().mostrarPanel(this.panelPoblacion); }
	
	public void borrarPlatosyProductosPanel() {
		this.getModelo().getListaTemporal().limpiarLista();
		this.getModelo().getListaTemporalPlatos().limpiarLista();
		this.total = 0;	}
	

	public PanelPoblacion makePanelPoblacion(ControladorPanelPoblacion controladorPanelPoblacion) {
		return new PanelPoblacion(controladorPanelPoblacion); }

	public String leerNumTransBBDD() {
		return String.valueOf(this.getModelo().getConsultas().leerNumTransBBDD()); }

	public String[] conseguirLocales() {
		String[] nombreLocales = new String[locales.size()];
		int i = 0;
		for (String[] array : locales) {
			nombreLocales[i] = array[1];
			i++; }
		return nombreLocales;
	}
	public String conseguirActividadesLocal(int selectedIndex) {
		if(locales.size()<=0)
			return "Error de  lectura";
		else
		return locales.get(selectedIndex)[2];}

	public String[] cogerListaProductos() {
		return this.getModelo().getListaProductos().getListaProductosString();}

	public String devolverFechaHora() {
		return this.getModelo().getUtiles().getFechaHoraSys(); }

	public int conseguirStock(int indexSelected, String producto) {
		return this.getModelo().getConsultas().obtenerStock(devolverNifLocal(indexSelected), producto); }

	public boolean comprobarCampos(double total, String nif, String nombre, String apellido) {
		return total > 0 && this.getModelo().validaciones.comprobarCamposString(nif, nombre, apellido); }

	public String accionadoBotonEliminar(int pos, String eliminar) {
		this.total = this.getModelo().funProd.funcionalidadeliminarProducto(pos, eliminar, this.total);
		return String.valueOf(total); }

	public void accionadoBotonAnadirAprovisionamiento(int cantidad, int indice, String nombre, int selectedIndex) throws SQLException {
		double precioTotal = this.getModelo().getConsultasComprobaciones().consultaComprobarPrecio(nombre);
		this.getModelo().insercionesActividades.insertarActividad(this.getModelo().getConsultas().leerNumTransBBDD(),
				devolverFechaFormateada(this.getModelo().getUtiles().getFechaHoraSys()), 0, "aprovisionamiento",devolverNifLocal(selectedIndex));
		this.getModelo().insercionesActividades
				.insertarAprovisionamiento(this.getModelo().getConsultas().leerNumTransBBDD() - 1);
		this.getModelo().getInserciones().insertarProductoActividad( this.getModelo().getConsultas().leerNumTransBBDD() - 1,
				this.getModelo().getConsultas().obtenerCodigoAlimentoProducto(nombre), cantidad, precioTotal,devolverNifLocal(selectedIndex)); 
		this.getModelo().insercionesActividades.ejecutarFuncion(this.getModelo().getConsultas().leerNumTransBBDD(),"aprovisionamiento");
	}

	public void insercionDatosBbdd(int transaccion, String fecha, double totalOperacion, int selectedIndex,
			DefaultListModel<String> lista, String tipo, String nombre, String nifComprador, String apellido,String domicilio, DefaultListModel<String> listaPlatos) throws SQLException {
		this.getModelo().insercionesActividades.insertarActividad(transaccion, devolverFechaFormateada(fecha),
				0, tipo, devolverNifLocal(selectedIndex)); // insertamos actividad
		this.getModelo().getFuncionalidadPoblacion().insertarDatos(lista ,transaccion,devolverNifLocal(selectedIndex),tipo,
				 nifComprador, nombre, apellido, domicilio, listaPlatos);
	}

	public int existePlato(String plato) {
		return this.getModelo().getListaTemporalPlatos().devolverPosPlatoString(plato); }

	public String[] accionadoBotonAnnadirPlato(String plato, String cantidad) {
		String[] devolver = this.getModelo().funPlat.funcionalidadAnadirPlato(plato, cantidad, this.total);
		this.total = Double.parseDouble(devolver[1]);
		return devolver; }

	public String accionadoBotonEliminarPlato(int pos, String eliminar) {
		this.total = this.getModelo().funPlat.funcionalidadeliminarPlato(pos, eliminar, this.total);
		return String.valueOf(total); }

	public int existeProducto(String nombreProducto) {
		return this.getModelo().getListaTemporal().devolverPosProductoString(nombreProducto); }

	public String[] cambiarCantidadProductos(String nombreProductoAnadido, int cantidadAnadir, String nombreProducto, String tipo) {
		String[] devolver = this.getModelo().funProd.cambiarCantidadProductos(nombreProductoAnadido, cantidadAnadir, nombreProducto, this.total, tipo);
		this.total = Double.parseDouble(devolver[1]);
		return devolver; }

	public String[] accionadoBotonAnnadirProducto(String producto, String cantidad) {
		String[] devolver = this.getModelo().funProd.funcionalidadAnadirProducto(producto, cantidad, this.total);
		this.total = Double.parseDouble(devolver[1]);
		return devolver; }

	public String devolverFechaFormateada(String input) {
		return this.getModelo().validaciones.devolverFechaFormateada(input); }

	public String devolverNifLocal(int selectedIndex) {
		if(locales.size()<=0)
			return "Error de  lectura";
		else
		return locales.get(selectedIndex)[0]; }

	public String[] cogerListaPlatos() {
		return this.getModelo().getListaPlatos().getListaPlatosString(); }
}
