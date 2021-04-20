package Controlador;

import Modelo.Modelo;
import Vista.Vista;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private ControladorPanelPrincipal controladorPanelPrincipal;
	private ControladorPanelPoblacion controladorPanelPoblacion;
	private ControladorPanelAnalisis controladorPanelAnalisis;

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.controladorPanelPrincipal = new ControladorPanelPrincipal(this.modelo, this.vista, this);
		this.controladorPanelPoblacion = new ControladorPanelPoblacion(this.modelo, this.vista, this);
		this.controladorPanelAnalisis = new ControladorPanelAnalisis(this.modelo, this.vista, this);
		this.navegarPanelPrincipal();
	}
	
	public void navegarPanelPoblacion() {
		System.out.println("Navegar panel Poblacion");
		controladorPoblacionMostrarPanelPoblacion();
	}

	public void controladorPoblacionMostrarPanelPoblacion() {
		this.controladorPanelPoblacion.mostrarPanelPoblacion();
	}
	
	public void navegarPanelAnalisis() {
		System.out.println("Navegar panel Analisis");
		controladorPoblacionMostrarPanelPoblacion();
	}

	public void controladorAnalisisMostrarPanelAnalisis() {
		this.controladorPanelAnalisis.mostrarPanelAnalisis();
	}

	public void navegarPanelPrincipal() {
		System.out.println("Navegar panel principal");
		controladorPanelPrincipalMostrarPanelPrincipal();
	}

	public void controladorPanelPrincipalMostrarPanelPrincipal() {
		this.controladorPanelPrincipal.mostrarPanelPrincipal();
	}

	//Necesarias para el testeo
	public ControladorPanelPrincipal makeControladorPanelPrincipal(Modelo modelo, Vista vista,
			Controlador controlador) {
		return new ControladorPanelPrincipal(this.modelo, this.vista, this);
	}
	
	public ControladorPanelPoblacion makeControladorPanelPoblacion(Modelo modelo, Vista vista,
			Controlador controlador) {
		return new ControladorPanelPoblacion(this.modelo, this.vista, this);
	}

}
