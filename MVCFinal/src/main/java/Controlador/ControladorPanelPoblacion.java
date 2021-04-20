package Controlador;

import Modelo.Modelo;
import Vista.PanelPoblacion;
import Vista.Vista;

public class ControladorPanelPoblacion extends ControladoresPaneles{

	private PanelPoblacion panelPoblacion;

	public ControladorPanelPoblacion(Modelo modelo, Vista vista, Controlador controlador) {
		super(modelo, vista, controlador);
	}

	public void mostrarPanel() {
		this.panelPoblacion = makePanelPoblacion(this);
		super.getVista().mostrarPanel(this.panelPoblacion);
	}

	public PanelPoblacion makePanelPoblacion(ControladorPanelPoblacion controladorPanelPoblacion) {
		return new PanelPoblacion(controladorPanelPoblacion);
	}

}
