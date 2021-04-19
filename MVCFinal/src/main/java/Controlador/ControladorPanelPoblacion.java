package Controlador;

import Modelo.Modelo;
import Vista.PanelPoblacion;
import Vista.Vista;

public class ControladorPanelPoblacion {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelPoblacion panelPoblacion;

	public ControladorPanelPoblacion(Modelo modelo, Vista vista, Controlador controlador) {
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

	public void mostrarPanelPoblacion() {
		this.panelPoblacion = makePanelPoblacion(this);
		this.vista.mostrarPanel(this.panelPoblacion);
	}

	public void accionadoBottonVolverPanelPrincipal() {
		this.controlador.navegarPanelPrincipal();
	}

	public PanelPoblacion makePanelPoblacion(ControladorPanelPoblacion controladorPanelPoblacion) {
		return new PanelPoblacion(controladorPanelPoblacion);
	}

	public void accionadoBottonMostrarPanelAnalisis() {
		// TODO Auto-generated method stub

	}

}
