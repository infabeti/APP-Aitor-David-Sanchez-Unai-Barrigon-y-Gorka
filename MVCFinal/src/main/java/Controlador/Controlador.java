package Controlador;

import Modelo.Modelo;
import Vista.Vista;
import Modelo.Usuario;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private ControladorPanelPrincipal controladorPanelPrincipal;
	private ControladorPanelPoblacion controladorPanelPoblacion;



	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.controladorPanelPrincipal = new ControladorPanelPrincipal(this.modelo, this.vista, this);
		this.controladorPanelPoblacion = new ControladorPanelPoblacion(this.modelo, this.vista, this);
		this.navegarPanelPrincipal();
	}
	
	public void navegarPanelPoblacion() {
		System.out.println("Navegar panel Poblacion");
		controladorPoblacionMostrarPanelPoblacion();
	}

	public void controladorPoblacionMostrarPanelPoblacion() {
		this.controladorPanelPoblacion.mostrarPanelPoblacion();
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
