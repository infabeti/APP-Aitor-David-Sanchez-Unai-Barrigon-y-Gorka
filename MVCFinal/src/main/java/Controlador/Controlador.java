package Controlador;

import Modelo.Modelo;
import Vista.Vista;
import Modelo.Usuario;

public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private ControladorPanelPrincipal controladorPanelPrincipal;


	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.controladorPanelPrincipal = new ControladorPanelPrincipal(this.modelo, this.vista, this);
		this.navegarPanelPrincipal();
	}

	public void navegarPanelPrincipal() {
		System.out.println("Navegar panel principal");
		controladorPanelPrincipalMostrarPanelPrincipal();
	}

	public void controladorPanelPrincipalMostrarPanelPrincipal() {
		this.controladorPanelPrincipal.mostrarPanelPrincipal();
	}

	public ControladorPanelPrincipal makeControladorPanelPrincipal(Modelo modelo, Vista vista,
			Controlador controlador) {
		return new ControladorPanelPrincipal(this.modelo, this.vista, this);
	}

}
