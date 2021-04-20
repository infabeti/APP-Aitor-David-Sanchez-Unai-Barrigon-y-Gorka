package Controlador;
import Modelo.Modelo;
import Vista.PanelPrincipal;
import Vista.Vista;

public class ControladorPanelPrincipal {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelPrincipal panelPrincipal;

	public ControladorPanelPrincipal(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;
	}
	
	public Modelo getModelo() {
		return modelo;
	}

	public Vista getVista() {
		return vista;
	}

	public Controlador getControlador() {
		return controlador;
	}

	public void mostrarPanelPrincipal() {
		this.panelPrincipal = makePanelPrincipal(this);
		this.vista.mostrarPanel(this.panelPrincipal);
	}
	
	public PanelPrincipal makePanelPrincipal(ControladorPanelPrincipal controladorPanelPrincipal) {
		return new PanelPrincipal(controladorPanelPrincipal);
	}

	public void accionadoBottonMostrarPanelAnalisis() {
		this.controlador.controladorAnalisisMostrarPanelAnalisis();
	}

	public void accionadoBottonMostrarPanelPoblacion() {
		this.controlador.controladorPoblacionMostrarPanelPoblacion();
	}

}
