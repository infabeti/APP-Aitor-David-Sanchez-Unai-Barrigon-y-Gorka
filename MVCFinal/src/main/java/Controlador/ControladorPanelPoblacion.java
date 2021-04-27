package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;import javax.swing.DefaultListModel;import Modelo.Modelo;import Vista.PanelPoblacion;import Vista.Vista;

public class ControladorPanelPoblacion extends ControladoresPaneles {

	private PanelPoblacion panelPoblacion;
	private ArrayList<String[]> locales;
	private double total;

	public ControladorPanelPoblacion(Modelo modelo, Vista vista, Controlador controlador) {
		super(modelo, vista, controlador);
		this.locales = this.getModelo().getConsultas().conseguirLocales(); }

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
		return locales.get(selectedIndex)[2];}

	public String[] cogerListaProductos() {
		return this.getModelo().getListaProductos().getListaProductosString();}

	public String devolverFechaHora() {
		return this.getModelo().getFechaHoraSys(); }

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
				devolverFechaFormateada(this.getModelo().getFechaHoraSys()), 0, "aprovisionamiento",devolverNifLocal(selectedIndex));
		this.getModelo().insercionesActividades
				.insertarAprovisionamiento(this.getModelo().getConsultas().leerNumTransBBDD() - 1);
		this.getModelo().getInserciones().insertarProductoActividad( this.getModelo().getConsultas().leerNumTransBBDD() - 1,
				this.getModelo().getConsultas().obtenerCodigoAlimentoProducto(nombre), cantidad, precioTotal,devolverNifLocal(selectedIndex)); 
		this.getModelo().insercionesActividades.ejecutarFuncion(this.getModelo().getConsultas().leerNumTransBBDD(),"aprovisionamiento");
	
	}

	public void insercionDatosBbdd(int transaccion, String fecha, double totalOperacion, int selectedIndex,
			DefaultListModel<String> lista, String tipo, String nombre, String nifComprador, String apellido,String domicilio, DefaultListModel<String> listaPlatos) throws SQLException {
		String nif = devolverNifLocal(selectedIndex);
		this.getModelo().insercionesActividades.insertarActividad(transaccion, devolverFechaFormateada(fecha),
				0, tipo, nif); // insertamos actividad y productos


		for (int i = 0; i < lista.getSize(); i++) {
			String textoSpliteado[] = lista.get(i).split(" ");
			insertarProductoActividad(i, transaccion, Integer.parseInt(textoSpliteado[0]), nif); }
		if (tipo.equalsIgnoreCase("Aprovisionamiento")) {
			this.getModelo().insercionesActividades.insertarAprovisionamiento(transaccion); }
		if (tipo.equalsIgnoreCase("Factura")) {
			// insertamos en factura y en comprador si toca
			if (this.getModelo().getConsultasComprobaciones().comprobarSiExisteComprador(nifComprador)) {
				System.out.println("El comprador ya existe, no se hace la insert en la tabla comprador"); } 
			else {
				this.getModelo().getInserciones().insertarComprador(nifComprador, nombre, apellido);
			}
			this.getModelo().insercionesActividades.insertarFactura(transaccion, nifComprador);
		}
		if (tipo.equalsIgnoreCase("Pedido")) {
			this.getModelo().insercionesActividades.insertarPedido(transaccion, domicilio);
		}
		if (tipo.equalsIgnoreCase("Comanda")) {
			for (int i = 0; i < listaPlatos.getSize(); i++) {
				String textoSpliteado[] = listaPlatos.get(i).split(" ");
				this.getModelo().getInserciones().insertarPlatoActividad(transaccion, this.getModelo().getConsultas().obtenerCodigoPlato(
								this.getModelo().getListaTemporalPlatos().getListaPlatosString()[i]), Integer.parseInt(textoSpliteado[0])); }
		}
		
		this.getModelo().insercionesActividades.ejecutarFuncion(transaccion,tipo);
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

	public void insertarProductoActividad(int nombreProducto, int transaccion, int cantidad, String nif) {
		String producto = devolverNombreProducto(nombreProducto);
		this.getModelo().getInserciones().insertarProductoActividad(transaccion, this.getModelo().getConsultas().obtenerCodigoAlimentoProducto(producto), cantidad,
				cogerPrecioString(producto), nif); }

	public String devolverNombreProducto(int i) {
		return this.getModelo().funProd.devolverNombreProducto(i); }

	public double cogerPrecioString(String nombreProducto) {
		return this.getModelo().getListaTemporal().precioProductoString(nombreProducto); }

	public String devolverFechaFormateada(String input) {
		return this.getModelo().validaciones.devolverFechaFormateada(input); }

	public String devolverNifLocal(int selectedIndex) {
		return locales.get(selectedIndex)[0]; }

	public String[] cogerListaPlatos() {
		return this.getModelo().getListaPlatos().getListaPlatosString(); }
}
