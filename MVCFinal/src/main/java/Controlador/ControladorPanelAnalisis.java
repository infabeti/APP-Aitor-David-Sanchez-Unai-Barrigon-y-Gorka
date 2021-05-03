package Controlador;

import Modelo.Modelo;
import Vista.PanelAnalisis;
import Vista.Vista;

public class ControladorPanelAnalisis extends ControladoresPaneles{

	private PanelAnalisis panelAnalisis;

	public ControladorPanelAnalisis(Modelo modelo, Vista vista, Controlador controlador) {
		super(modelo, vista, controlador);
	}

	public void mostrarPanel() {
		this.panelAnalisis = makePanelAnalisis(this);
		super.getVista().mostrarPanel(this.panelAnalisis);
	}

	public PanelAnalisis makePanelAnalisis(ControladorPanelAnalisis controladorPanelAnalisis) {
		return new PanelAnalisis(controladorPanelAnalisis);
	}
	
}
