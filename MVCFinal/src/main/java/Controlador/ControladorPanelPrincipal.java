package Controlador;
import Modelo.Modelo;
import Modelo.Usuario;
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
		Usuario user = this.modelo.getUser();
		return new PanelPrincipal(controladorPanelPrincipal, user.getTipoLocal(), user.getNombre(), user.getLocal());
	}

	public void accionadoBottonMostrarPanelAnalisis() {
		// TODO Auto-generated method stub
		
	}

	public void accionadoBottonMostrarPanelPoblacion() {
		// TODO Auto-generated method stub
		
	}

}
