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
		//Utilizamos getters para acceder a los propios Modelo y controlador de la clase
		//ya que a la hora de testear no podemos instanciar esta clase ya que es abstracta
		this.getModelo().getListaTemporal().limpiarLista();
		this.getModelo().getListaTemporalPlatos().limpiarLista();
		this.getControlador().navegarPanelPrincipal();
	}
	
	public abstract void mostrarPanel();
	
}
