package Controlador;

import Modelo.Modelo;
import Vista.Vista;

public abstract class ControladoresPaneles {

	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	
	public ControladoresPaneles(Modelo modelo, Vista vista, Controlador controlador) {
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

	public void accionadoBottonVolverPanelPrincipal() {
		this.controlador.navegarPanelPrincipal();
	}
	
	public abstract void mostrarPanel();
	
}
