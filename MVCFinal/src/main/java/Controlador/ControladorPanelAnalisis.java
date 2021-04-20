package Controlador;

import Modelo.Modelo;
import Vista.PanelAnalisis;
import Vista.Vista;

public class ControladorPanelAnalisis {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelAnalisis panelAnalisis;

	public ControladorPanelAnalisis(Modelo modelo, Vista vista, Controlador controlador) {
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

	public void mostrarPanelAnalisis() {
		this.panelAnalisis = makePanelAnalisis(this);
		this.vista.mostrarPanel(this.panelAnalisis);
	}

	public void accionadoBottonVolverPanelPrincipal() {
		this.controlador.navegarPanelPrincipal();
	}

	public PanelAnalisis makePanelAnalisis(ControladorPanelAnalisis controladorPanelAnalisis) {
		return new PanelAnalisis(controladorPanelAnalisis);
	}


	
}
